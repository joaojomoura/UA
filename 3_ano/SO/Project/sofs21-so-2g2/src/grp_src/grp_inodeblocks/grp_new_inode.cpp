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

namespace sofs21
{
    uint16_t grpNewInode(uint16_t type, uint16_t perm)
    {
        soProbe(333, "%s(%04x, %9o)\n", __FUNCTION__, type, perm);

        /* replace this comment and following line with your code */
        // return binNewInode(type, perm);

		if(type != S_IFREG and type != S_IFDIR and type != S_IFLNK)
			throw EINVAL;
		int ih;
		SOInode *ip;

		if (perm < 0 || 
			(perm % 10) > 7 ||
			((perm / 10) % 10) > 7 ||
			((perm / 100) % 10) > 7
		)
			throw EINVAL;

		uint16_t inode_n = soAllocInode();
		if (inode_n == NullInodeReference)
		{
			inode_n = soUnqueueHiddenInode();
			if (inode_n == NullInodeReference)
				throw ENOSPC;
			
			ih = soOpenInode(inode_n);
			ip = soGetInodePointer(ih);
			
			soFreeInodeBlocks(ih, inode_n);
		
			soSaveInode(ih);		
			soCloseInode(ih);
		}
			
		ih = soOpenInode(inode_n);
		ip = soGetInodePointer(ih);

		ip->mode = type | perm;
		ip->lnkcnt = 0;
		ip->owner = getuid();
		ip->group = getgid();
		ip->size = 0;
		ip->blkcnt = 0;
		ip->atime = 0;
		ip->mtime = 0;
		ip->ctime = 0;
		ip->i1 = NullBlockReference;
		ip->i2 = NullBlockReference;

		for (int i = 0; i < N_DIRECT; i++)
			ip->d[i] = NullBlockReference;

		soSaveInode(ih);
		soCloseInode(ih);
		
		return inode_n;
	}
};

