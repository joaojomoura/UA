/**
 * @file grp_mksofs_FBT.cpp
 * @author Joao Moura 43889
 * @brief 
 * @version 0.1
 * @date 2021-11-29
 * 
 * @copyright Copyright (c) 2021
 * 
 */
#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <inttypes.h>
#include <string.h>

namespace sofs21
{
    void grpFillInBitmapTable(uint32_t ntotal, uint16_t itsize, uint32_t dbtotal)
    {
        soProbe(605, "%s(%u, %u, %u)\n", __FUNCTION__, ntotal, itsize, dbtotal);



        /* replace this comment and following line with your code */
        //binFillInBitmapTable(ntotal, itsize, dbtotal);
  

        uint32_t bitMap_Block = ntotal - 1 - itsize - dbtotal; // tamanho do bitmap
        uint32_t bmb[BlockSize/4]; // array com 256 words de 32 bits
        uint32_t last_Used_Data_Block = dbtotal / 32; // indice da word com bits nao usados do data block
        uint32_t bits_From_Last_Data_Block_Used = dbtotal % 32; // os bits que estao nao usados da word do ultimo data block

        
        // percorre o bitmap block
        for (uint32_t i = 0; i < bitMap_Block; i++){
            uint32_t tmp = last_Used_Data_Block - (BlockSize/4)*i; // saber a posiçao caso haja mais que um bloco
            // percorre cada word
            for (uint32_t j = 0; j < BlockSize/4; j++){
                
                
                // se j for = ao ultimo bloco de dados
                if (j == tmp)
                        bmb[j] = 0xFFFFFFFF >> (32 - bits_From_Last_Data_Block_Used); // bits dos blocos usados da ultima palavra
                // se for menor todos os blocos estao livres logo estao a 1
                else if (j < tmp){
                    bmb[j] |= 0xFFFFFFFF;
                    
                }
                // se for maior fica a 0 como nao usados
                else if(j > tmp)
                    bmb[j] &= 0x00000000;

                // LSB da word 0 a 0 e resto a um
                if (j == 0 && i == 0) 
                    bmb[j] &= 0xFFFFFFFE;
            }
            soWriteRawBlock(i + itsize + 1, &bmb); // escreve no bitmap (superblock + InodeTable + posicao)
        }    
        





        



         
    }
};

