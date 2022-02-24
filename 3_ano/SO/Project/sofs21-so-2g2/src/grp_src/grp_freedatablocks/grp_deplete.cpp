/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 */

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"

#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <iostream>
using namespace std;

namespace sofs21
{
    /* only fill the current block to its end */
    void grpDeplete(void)
    {
        soProbe(444, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        // binDeplete();

        //Pointer to the Superblock
        SOSuperblock* sp = soGetSuperblockPointer();

        //If cache is not full nothing happens
        if(sp->insertion_cache.idx < REF_CACHE_SIZE)
            return;

        
        uint32_t bitmap_index = sp->rbm_idx;
        uint32_t block_Number = bitmap_index / (BlockSize * 8);


        //Get a pointer to a reference block of the bitmap table.
        uint32_t* rp = soGetBitmapBlockPointer(block_Number);

        //Variable to count the number of new references inserted in the bitmap table
        uint32_t cnt = 0;
        uint32_t j = 0;

        //Copy references from insertion cache to bitmap table
        for(uint32_t i = block_Number; i < RPB; i++){
            //All references (insertion_cache) where copied
            if(sp->insertion_cache.ref[0] == NullBlockReference) 
                break;
            else{
                //Copy the reference on position 0
                rp[i] = sp->insertion_cache.ref[0];
                cnt++;

                //Move all insertion cache references one position back
                j = 0;
                while(j != sp->insertion_cache.idx) {
                    sp->insertion_cache.ref[j] = sp->insertion_cache.ref[j+1];
                    j++;
                }

                //Update the insertion cache info
                sp->insertion_cache.ref[sp->insertion_cache.idx-1] = NullBlockReference;
                sp->insertion_cache.idx--;
            }
        }     
        
        //Update the number of not null references in the bitmap table
        sp->rbm_size += cnt;

        //Write new content in the bitmap table
        soSaveBitmapBlock();

        //Save SuperBlockMetaInfo
        soSaveSuperblock(); 
    }
};

