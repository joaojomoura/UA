/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2021
 *  \completed by Joao Moura 43889
 */

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include <string.h>
#include <errno.h>
#include <iostream>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    void grpReplenishFromBitmap(void)
    {
        soProbe(445, "%s()\n", __FUNCTION__);

        SOSuperblock *sb = soGetSuperblockPointer();


        // check if cache is not empty
        if (sb->retrieval_cache.idx != REF_CACHE_SIZE)
            return;
        
        uint32_t bitmap_index = sb->rbm_idx;
        
        

        uint32_t block_Number = bitmap_index / (BlockSize * 8);
        uint32_t verify = block_Number;
        uint32_t *bitmap = soGetBitmapBlockPointer(block_Number);

        uint32_t counter_For_Retrieval = 0;
        uint32_t counter_for_second_lap = 0;
        
        
        
        


        while(counter_For_Retrieval < REF_CACHE_SIZE){

            // se chegar ao fim do bitmap volta a 0 e recomeca
            if (bitmap_index == sb->dbtotal){
                bitmap_index = 0;
                counter_for_second_lap++;
            }

            // se deu mais que uma volta ao bitmap e nao tem free bits para o loop
            if(counter_for_second_lap > 1)
                break;
                
            
            uint32_t res = bitmap_index % (BlockSize * 8);
            uint32_t word_Index = res / 32;  
            uint32_t bit_From_Word_index = res % 32;
            uint32_t bit = (bitmap[word_Index] >> bit_From_Word_index) & 1;
             

            // transferir para o retrieval
            if(bit == 1){
                //bitmap index para cada posicao do retrieval ate 60
                sb->retrieval_cache.ref[counter_For_Retrieval] = bitmap_index;

                //mudar cada bit da word para 0 no bitmap
                uint32_t mask = 1 << bit_From_Word_index;
                bitmap[word_Index] = (bitmap[word_Index] & ~mask) | (0 << bit_From_Word_index);
                // avanca
                bitmap_index++;
                counter_For_Retrieval++;
                counter_for_second_lap = 0;
                sb->retrieval_cache.idx--;
            }
            else
                bitmap_index++;

            // ve se vai para novo bloco do bitmap
            if(verify != bitmap_index / (BlockSize * 8)){
                block_Number = bitmap_index / (BlockSize * 8);
                bitmap = soGetBitmapBlockPointer(block_Number);
                verify = block_Number;
            }

            
            
        }
        soSaveBitmapBlock();
        //se nao tiver nenhum bit free
        if(counter_for_second_lap > 1)
            sb->rbm_idx = NullBlockReference;
        else
            sb->rbm_idx = bitmap_index;
        
        soSaveSuperblock();
        

        
        
        


        /* replace this comment and following line with your code */
        //binReplenishFromBitmap();

        

        

       
    }
};

