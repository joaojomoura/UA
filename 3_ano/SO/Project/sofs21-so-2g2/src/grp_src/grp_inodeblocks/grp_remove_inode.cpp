/*
 *  \authur Artur Pereira - 2016-2021
 */

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <string.h>
#include <inttypes.h>

#include <fcntl.h>
#include "freeinodes.h"
#include <unistd.h>

#include <assert.h>

namespace sofs21
{
    void grpRemoveInode(uint16_t in)
    {
        soProbe(334, "%s(%d)\n", __FUNCTION__, in);

		if (in == 0)
			printf("Found 0\n");

        /* replace this comment and following line with your code */
        // BinRemoveInode(in);
    

		if (!soHideInode(in))
		{
			int in2 = soUnqueueHiddenInode();
			int ih2 = soOpenInode(in2);
			//soUnqueueHiddenInode();

			soFreeInodeBlocks(ih2, 0);
			soFreeInode(in2);
			soSaveInode(ih2);
			soCloseInode(ih2);
			uint16_t res = soHideInode(in);
			assert(res);
		}
			
		/*
		SOSuperblock* sop = soGetSuperblockPointer();
		sop->iqcount = sop->iqcount + 1;
		soSaveSuperblock();

		soSaveInode(ih);
		*/
		/*
		int ih = soOpenInode(in);
		soCloseInode(ih);
		*/
	}
};

