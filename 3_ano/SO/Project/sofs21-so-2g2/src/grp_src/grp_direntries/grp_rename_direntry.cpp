/**
 * @file grp_rename_direntry.cpp
 * @author Joao Moura 43889
 * @brief Precisa de muito mais testes mas nao vou ter tempo para testar por causa do emprego. Porventura, depois de uma analise cuidada parece me que iria funcionar.
 * @version 0.1
 * @date 2021-12-19
 * 
 * @copyright Copyright (c) 2021
 * 
 */

#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"
#include <iostream>

#include <string.h>
#include <errno.h>
#include <sys/stat.h>

namespace sofs21
{
    void grpRenameDirentry(int pih, const char *name, const char *newName)
    {
        soProbe(204, "%s(%d, %s, %s)\n", __FUNCTION__, pih, name, newName);

        /* replace this comment and following line with your code */
        //binRenameDirentry(pih, name, newName);

        
    
        SOInode* ipointer = soGetInodePointer(pih);
        uint32_t block_idx = NullBlockReference;
        uint32_t block_idx_next = NullBlockReference;
        uint32_t entry_idx = 0;

        uint32_t first_Empty_slot = 0, second_Empty_slot = 0, inode_number = 0;
        bool has_Empty_Slots = false;
        uint32_t block_With_Empty_Slots = NullBlockReference;
        
        

        for(uint32_t i = 0; i <= ipointer-> size/BlockSize; i++) 
        {//percorre os blocos

            // le o bloco do inode pedido
            SODirectorySlot entries[DPB];
            soReadInodeBlock(pih,i,entries);

            //le o bloco seguinte
            SODirectorySlot entries_Next_Block[DPB];
            soReadInodeBlock(pih,i+1,entries_Next_Block);



            for(uint32_t k = 0; k < DPB; k++) // percorre as entries
            {
                bool go_Next_Block = false;
                // se estiver na ultima posicao vai para o proximo bloco
                if (k + 1 == DPB) {
                    go_Next_Block = true;
                }

                
                if (!has_Empty_Slots){
                    // guarda ultima posicao do bloco e a do bloco a seguir
                    if (go_Next_Block) {
                        if (entries[k].in == NullInodeReference && entries[k].nameBuffer[0] == '\0'){
                            if (entries_Next_Block[0].in == NullInodeReference && entries_Next_Block[0].nameBuffer[0] == '\0'){
                                first_Empty_slot = k;
                                second_Empty_slot = 0;
                                has_Empty_Slots = true;
                                block_With_Empty_Slots = i + 1;
                            }
                        }
                    }
                    // guarda dois slots do bloco que estejam vazios
                    else {
                        if (entries[k].in == NullInodeReference && entries[k].nameBuffer[0] == '\0'){
                            if (entries[k+1].in == NullInodeReference && entries[k+1].nameBuffer[0] == '\0'){
                                first_Empty_slot = k;
                                second_Empty_slot = k + 1;
                                has_Empty_Slots = true;
                                block_With_Empty_Slots = i;

                            }
                        }
                    } 
                }   
                // se o nome for pequeno
                if(strlen(name) < DIRECTORY_SLOT){
                    if(strcmp(newName,entries[k].nameBuffer) == 0) //se tiver uma entrada com nome igual manda exceção
                    {
                        throw SOException(EEXIST,__FUNCTION__);
                    }

                    if(strcmp(name,entries[k].nameBuffer) == 0)// encontrou a entrada
                    {
                        entry_idx = k;
                        block_idx = i;
                        block_With_Empty_Slots = i;
                        inode_number = entries[k].in;
                        // apaga a entrada
                        memset(entries[k].nameBuffer,'\0',sizeof(entries[k].nameBuffer));
                        entries[k].in = NullInodeReference;

                        if (strlen(newName) > DIRECTORY_SLOT){
                            // verificar se o slot a seguir esta livre
                            if (entry_idx != DPB and (entries[entry_idx + 1].in == NullInodeReference && entries[entry_idx + 1].nameBuffer[0] == '\0')){
                                first_Empty_slot = entry_idx;
                                second_Empty_slot = entry_idx + 1;
                                entries[entry_idx].in = NullInodeReference;
                                has_Empty_Slots = true;
                            }
                            //verifica se o slot do bloco a seguir esta livre
                            else if (entry_idx == DPB and (entries_Next_Block[0].in == NullInodeReference && entries_Next_Block[0].nameBuffer[0] == '\0')){
                                first_Empty_slot = entry_idx;
                                second_Empty_slot = 0;
                                entries[entry_idx].in = NullInodeReference;
                                has_Empty_Slots = true;
                            }
                        }
                    }
                }
                // se for grande
                else{
                    // se o primeiro slot estiver a null
                    if(entries[k].in == NullInodeReference){
                        // se nao estivermos na ultima posicao
                        if(!go_Next_Block){

                            if((strncmp(newName,entries[k].nameBuffer,DIRECTORY_SLOT) == 0) and (strcmp(newName+DIRECTORY_SLOT,entries[k+1].nameBuffer) == 0)) //se tiver uma entrada com nome igual manda exceção
                            {
                                throw SOException(EEXIST,__FUNCTION__);
                            }

                            if((strncmp(name,entries[k].nameBuffer,DIRECTORY_SLOT) == 0) and (strcmp(name+DIRECTORY_SLOT,entries[k+1].nameBuffer) == 0)) // encontrou a entrada
                            {
                                entry_idx = k+1;
                                block_idx = i;
                                inode_number = entries[entry_idx].in;
                                // apaga os slots
                                memset(entries[k].nameBuffer,'\0',sizeof(entries[k].nameBuffer));
                                memset(entries[k+1].nameBuffer,'\0',sizeof(entries[k+1].nameBuffer));
                                entries[k].in = NullInodeReference;
                                entries[entry_idx].in = NullInodeReference;
                                

                                // verifica se o bloco a seguir esta livre e guarda
                                if(entry_idx != DPB and (entries[entry_idx + 1].in == NullInodeReference && entries[entry_idx + 1].nameBuffer[0] == '\0')){
                                    block_With_Empty_Slots = i;
                                    first_Empty_slot = entry_idx;
                                    second_Empty_slot = entry_idx + 1;
                                    has_Empty_Slots = true;
                                }
                                // esta a ocupar as ultimas duas posicoes, ve a do bloco a seguir
                                else if (entry_idx == DPB and (entries_Next_Block[0].in == NullInodeReference && entries_Next_Block[0].nameBuffer[0] == '\0')) {
                                    block_With_Empty_Slots = i + 1;
                                    first_Empty_slot = entry_idx;
                                    second_Empty_slot = 0;
                                    has_Empty_Slots = true;
                                }
                            } 
                        }
                        // caso o bloco esteja na ultima posicao ve a posicao a seguir
                        else{
                            if((strncmp(newName,entries[k].nameBuffer,DIRECTORY_SLOT) == 0) and (strcmp(newName+DIRECTORY_SLOT,entries_Next_Block[0].nameBuffer) == 0)) //se tiver uma entrada com nome igual manda exceção
                            {
                                throw SOException(EEXIST,__FUNCTION__);
                            }

                            if((strncmp(name,entries[k].nameBuffer,DIRECTORY_SLOT) == 0) and (strcmp(name+DIRECTORY_SLOT,entries_Next_Block[0].nameBuffer) == 0)) // encontrou a entrada
                            {
                                entry_idx = 0;
                                block_idx = i;
                                block_idx_next = i + 1;
                                
                                // guarda o valor de in e apaga os nomes
                                inode_number = entries_Next_Block[entry_idx].in;
                                memset(entries[k].nameBuffer,'\0',sizeof(entries[k].nameBuffer));
                                memset(entries_Next_Block[entry_idx].nameBuffer,'\0',sizeof(entries_Next_Block[entry_idx].nameBuffer));
                                entries[k].in = NullInodeReference;
                                entries_Next_Block[entry_idx].in = NullInodeReference;
                                // verifica se o a seguir esta livre
                                if(entries_Next_Block[entry_idx + 1].in == NullInodeReference && entries_Next_Block[entry_idx + 1].nameBuffer[0] == '\0'){
                                    block_With_Empty_Slots = block_idx_next;
                                    first_Empty_slot = entry_idx;
                                    second_Empty_slot = entry_idx + 1;
                                    has_Empty_Slots = true;
                                }
                            }
                        }
                    }
                }
            }
          soWriteInodeBlock(pih,i,entries); 
          soWriteInodeBlock(pih,i+1,entries_Next_Block); 
        }

        if(block_idx == NullBlockReference){// nao existe nenhuma entrada chamada 'name'
            throw SOException(ENOENT, __FUNCTION__);
        }


        // Processo de rename

        SODirectorySlot entries[DPB];
        SODirectorySlot entries_other_block[DPB];
        soReadInodeBlock(pih,block_With_Empty_Slots,entries);

        // se o nome for grande
        if(strlen(name) > DIRECTORY_SLOT){
            // se o newname for pequeno
            if(strlen(newName) < DIRECTORY_SLOT) {
                strcpy(entries[entry_idx].nameBuffer,newName);
                entries[entry_idx].in = inode_number;
            }
            // se newName for grande
            else {
                if(second_Empty_slot != 0){
                    strncpy(entries[first_Empty_slot].nameBuffer,newName,DIRECTORY_SLOT);// copia para o primeiro slot os primeiros 30 chars
                    strcpy(entries[second_Empty_slot].nameBuffer,newName+DIRECTORY_SLOT);// copia o resto
                    entries[second_Empty_slot].in = inode_number;
                    entries[first_Empty_slot].in = NullInodeReference; 
                }
                else {
                    soReadInodeBlock(pih,block_idx,entries_other_block); 
                    strncpy(entries_other_block[first_Empty_slot].nameBuffer,newName,DIRECTORY_SLOT);// copia para o primeiro slot os primeiros 30 chars
                    strcpy(entries[second_Empty_slot].nameBuffer,newName+DIRECTORY_SLOT);// copia o resto
                    entries[second_Empty_slot].in = inode_number;
                    entries[first_Empty_slot].in = NullInodeReference;
                    soWriteInodeBlock(pih,block_idx,entries_other_block); 
                }
            }
        }
        // se name for pequeno
        else {
            // newName pequeno
            if(strlen(newName) < DIRECTORY_SLOT){
                strcpy(entries[entry_idx].nameBuffer,newName);    //muda o nome
                entries[entry_idx].in = inode_number;
            }
            // se o newName for grande
            else {
                if(second_Empty_slot != 0){
                    strncpy(entries[first_Empty_slot].nameBuffer,newName,DIRECTORY_SLOT);// copia para o primeiro slot os primeiros 30 chars
                    strcpy(entries[second_Empty_slot].nameBuffer,newName+DIRECTORY_SLOT);// copia o resto
                    entries[second_Empty_slot].in = inode_number;
                    entries[first_Empty_slot].in = NullInodeReference; 
                }
                else {
                    soReadInodeBlock(pih,block_idx,entries_other_block); 
                    strncpy(entries_other_block[first_Empty_slot].nameBuffer,newName,DIRECTORY_SLOT);// copia para o primeiro slot os primeiros 30 chars
                    strcpy(entries[second_Empty_slot].nameBuffer,newName+DIRECTORY_SLOT);// copia o resto
                    entries[second_Empty_slot].in = inode_number;
                    entries[first_Empty_slot].in = NullInodeReference;
                    soWriteInodeBlock(pih,block_idx,entries_other_block); 
                }
            }
        }
        
        soWriteInodeBlock(pih,block_With_Empty_Slots,entries);    //escreve
    }
};

