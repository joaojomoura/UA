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

#include <iostream>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    uint16_t grpUnqueueHiddenInode()
    {
        soProbe(404, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        // return binUnqueueHiddenInode();
    
		SOSuperblock *sb = soGetSuperblockPointer();

		// if empty return NullInodeReference
		if (sb->iqcount == 0)
			return NullInodeReference;

		// remove oldest inode and return reference
		// fill removed with NullInodeReference
		// update iqhead iqcount
		
		sb->iqcount--;
		uint16_t res = sb->iqueue[sb->iqhead];
		sb->iqueue[sb->iqhead++] = NullInodeReference;
		//sb->iidx = res + 2;

		soSaveSuperblock();
		return res;
	}
};

