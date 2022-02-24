/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 */

#include "freeinodes.h"
#include "bin_freeinodes.h"
#include "grp_freeinodes.h"

#include <stdio.h>
#include <errno.h>
#include <inttypes.h>
#include <time.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <string.h>
#include <math.h>
#include <iostream>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    uint16_t grpAllocInode()
    {
        soProbe(401, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        //return binAllocInode();
        SOSuperblock *sb = soGetSuperblockPointer();
        
        if(sb->ifree == 0){
            return NullInodeReference;
        }
        uint16_t index = sb->iidx;
        
        while(true){
            uint16_t pos = (uint16_t)floor(index / 32);
            uint32_t bit = 0x00000001 << (index % 32);
            long putzero = 0xFFFFFFFE << (index % 32);
            if((sb->ibitmap[pos] & bit) != 0x00000000){
                sb->ibitmap[pos] &= putzero;
                sb->iidx = index;
                sb->ifree--;
                break;
            }
            else{
                index++;
            }
        }
        soSaveSuperblock();
        return index;
    }
}