/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 */

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include <stdio.h>
#include <errno.h>
#include <inttypes.h>
#include <time.h>
#include <unistd.h>
#include <sys/types.h>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    void grpFreeDataBlock(uint32_t bn)
    {
         soProbe(442, "%s(%u)\n", __FUNCTION__, bn);

        /* replace this comment and following line with your code */
        //binFreeDataBlock(bn);

        // superBlock pointer 
        SOSuperblock* sb = soGetSuperblockPointer();

        // check if bn is a valid data block
        /* Exceptions --> EINVAL if data block number is not valid. */
        if( (bn < 0) || (bn >= sb-> dbtotal) ) {
            throw SOException(EINVAL, __FUNCTION__);
        }

        //check if insertion cache is full
        if (sb->insertion_cache.idx >= REF_CACHE_SIZE)
        {
            soDeplete();
        }

        // The reference must be inserted at the first empty cell
        sb->insertion_cache.ref[sb-> insertion_cache.idx] = bn;
        /* some superblock's fields (dbfree, insertion_cache) must be updated properly. */
        sb->insertion_cache.idx++;  // insertion cache of references to free data blocks 
        sb->dbfree++;   //number of free data blocks


        //Save superblock to disk.
        soSaveSuperblock(); 
    }
};

