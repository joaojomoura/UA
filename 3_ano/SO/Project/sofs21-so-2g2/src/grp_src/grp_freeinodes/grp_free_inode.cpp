/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2021
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

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    void grpFreeInode(uint16_t in)
    {
        soProbe(402, "%s(%u)\n", __FUNCTION__, in);

		// printf("%d", in);

        /* replace this comment and following line with your code */
        //binFreeInode(in);
    	
		SOSuperblock *sb = soGetSuperblockPointer();
		
		// todo: in NEEDS VALIDATION 0 < in < MAX_INODES
		if (in < 0 || in > sb->itotal)
			throw EINVAL;
		
		// set ibitmap location to 1
		sb->ibitmap[in/32] |= (1 << in%32);

		// inode's mode, owner and group fields are put at 0
		int ih = soOpenInode(in);
		SOInode *i = soGetInodePointer(ih);

		i->mode = 0;
		i->owner = 0;
		i->group = 0;

		// the other inode meta data fields in the superblock (iidx, ifree) must be updated.
		//sb->iidx = in;
		sb->ifree++;

		soSaveInode(ih);
		soCloseInode(ih);
		soSaveSuperblock();
	}
};

