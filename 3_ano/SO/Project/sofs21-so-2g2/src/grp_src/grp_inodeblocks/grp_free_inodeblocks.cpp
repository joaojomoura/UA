/*
 *  \authur Artur Pereira - 2016-2021
 * Joao Moura 43889
 */

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "freedatablocks.h"
#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <inttypes.h>
#include <errno.h>
#include <assert.h>
#include <iostream>

#define CHANGED 0x1
#define NOT_EMPTY 0x2

namespace sofs21
{

    /* free all blocks between positions idx and RPB - 1
     * existing in the block of references passed as argument.
     * The return value has the following meaning:
     * - bit CHANGED is raised if the block of references changed
     * - bit NOT_EMPTY is raised if the block of references contains non NullBlockReference references
     */
    static uint32_t grpFreeIndirectInodeBlocks(int ih, uint32_t *ref, uint32_t idx);

    /* free all blocks between positions idx and RPB*RPB - 1
     * covered by the block of indirect references passed as argument.
     * The return value has the following meaning:
     * - bit CHANGED is raised if the block of indirect references changed
     * - bit NOT_EMPTY is raised if the block of indirect references contains non NullBlockReference references
     */
    //#if false
    static uint32_t grpFreeDoubleIndirectInodeBlocks(int ih, uint32_t *iref, uint32_t idx);
    //#endif

    /* ********************************************************* */

    void grpFreeInodeBlocks(int ih, uint32_t ffbn)
    {
        soProbe(303, "%s(%d, %u)\n", __FUNCTION__, ih, ffbn);

        /* replace this comment and following line with your code */
        //binFreeInodeBlocks(ih, ffbn);

        SOInode* inode_pointer = soGetInodePointer(ih);
        

        uint32_t d_Start = 0;
        uint32_t i1_Start = -1;
        uint32_t i2_Start = -1;
        

        // posicao do bloco esta em d[]
        if (ffbn < N_DIRECT){
            d_Start = ffbn;
            i1_Start = 0;
            i2_Start = 0;
        }
        // esta em i1
        else if (ffbn < N_DIRECT + RPB){
            d_Start = N_DIRECT;
            i1_Start = (ffbn - N_DIRECT);
            i2_Start = 0;
        }
        //esta em i2
        else if (ffbn < N_DIRECT + RPB + RPB*RPB){
            d_Start = N_DIRECT;
            i1_Start = RPB + N_DIRECT;
            i2_Start = (ffbn - N_DIRECT - RPB)/(RPB*RPB);
        }
        
        
        //Apaga em d[]
        for(uint32_t i = d_Start; i < N_DIRECT; i++){
            if(inode_pointer->d[i] != NullBlockReference){
                soFreeDataBlock(inode_pointer->d[i]);
                inode_pointer->d[i] = NullBlockReference;
                inode_pointer->blkcnt--;
            }
        }

        // apaga i1[]
        grpFreeIndirectInodeBlocks(ih,&(inode_pointer->i1),i1_Start); 
        
        //apaga i2[]
        grpFreeDoubleIndirectInodeBlocks(ih,&(inode_pointer->i2),i2_Start);
        
    }

    /* ********************************************************* */

//#if false
    static uint32_t grpFreeIndirectInodeBlocks(int ih, uint32_t *ref, uint32_t idx)
    {
        soProbe(303, "%s(%d, %p, %u)\n", __FUNCTION__, ih, ref, idx);

        /* replace this comment and following line with your code */
        //throw SOException(ENOSYS, __FUNCTION__); 
        uint32_t check = 0;
        SOInode* inode_pointer = soGetInodePointer(ih);
        uint32_t refi1[RPB];
        //se o bloco nao estiver null
        if(*ref != NullBlockReference){
            //le o bloco
            soReadDataBlock(*ref,&refi1);
            // percorre as 256 referencias
            for(uint32_t i = 0; i < RPB; i++) {
                // se for maior ou igual que idx e nao for null, da free e mete a null
                if(i >= idx && refi1[i] != NullBlockReference){
                    soFreeDataBlock(refi1[i]);
                    refi1[i] = NullBlockReference;
                    inode_pointer->blkcnt--;
                    check |= CHANGED;
                }
                // aqueles que antes de idx nao estiverem null ativa o notEmpty
                if(refi1[i] != NullBlockReference)
                    check |= NOT_EMPTY;
            }
            // se o check nao foi alterado ou o bit changed foi ativo, e i1[] estiver vazio, liberta o bloco i1
            if((check & NOT_EMPTY) == 0){
                soFreeDataBlock(*ref);
                *ref = NullBlockReference;
                inode_pointer->blkcnt--;
            }
            //escreve o bloco
            soWriteDataBlock(*ref,&refi1); 
        }
        
        return check;
        
    }
//#endif

    /* ********************************************************* */

//#if false
    static uint32_t grpFreeDoubleIndirectInodeBlocks(int ih, uint32_t *iref, uint32_t idx)
    {
        soProbe(303, "%s(%d, %p, %u)\n", __FUNCTION__, ih, iref, idx);

        uint32_t check_total = 0;
        uint32_t refi2 [RPB];
        SOInode* inode_pointer = soGetInodePointer(ih);
        //Se i2 for diferente de Null
        if(*iref != NullBlockReference){
            //le o bloco
            soReadDataBlock(*iref,&refi2);
            //percorre as 256 posicoes de i2
            for(uint32_t i = 0; i < RPB; i++){
                uint32_t check = 0;
                //verifica cada posicao de i2 se esta null
                if(refi2[i] != NullBlockReference){
                    
                    // se i estiver na posicao idx de i2
                    if(i == idx / RPB){
                        // liberta as referencias de i1 a partir da posicao desejada
                        check = grpFreeIndirectInodeBlocks(ih,&refi2[i],idx%RPB);
                    }
                    //se nao liberta a referencia de i1 toda
                    else if(i > idx / RPB){
                        check = grpFreeIndirectInodeBlocks(ih,&refi2[i],0);
                    }
                    // verifica se antes de idx existem referencias vazias
                    if(refi2[i] != NullBlockReference)
                        check |= NOT_EMPTY;
                }
                // se nao estiver vazio
                if((check & NOT_EMPTY) != 0)
                    check_total |= NOT_EMPTY;

            }
            // liberta o a referencia i2 
            if((check_total & NOT_EMPTY) == 0){
                soFreeDataBlock(*iref);
                *iref = NullBlockReference;
                inode_pointer->blkcnt--;
            }
                
                

            //escreve para o bloco
            soWriteDataBlock(*iref,&refi2);
        }

        
        return check_total;

        /* replace this comment and following line with your code */
        //throw SOException(ENOSYS, __FUNCTION__); 
    }
//#endif

    /* ********************************************************* */
};

