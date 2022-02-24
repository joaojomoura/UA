#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <errno.h>
//#include <string.h>
#include <string>
#include <cstring>
#include <sys/stat.h>

namespace sofs21
{
    uint16_t grpGetDirentry(int pih, const char *name)
    {
        soProbe(201, "%s(%d, %s)\n", __FUNCTION__, pih, name);

        /* replace this comment and following line with your code */
        // return binGetDirentry(pih, name);
	
		// name does not contain /
		SOInode *ip = soGetInodePointer(pih);
		
		// user can read the directory
		if (!soCheckInodeAccess(pih, R_OK))
			return NullInodeReference;
		
		// Read every bock on the inode
		for (uint32_t i = 0; i < ip->size/BlockSize; i++)
		{
			SODirectorySlot dirs[DPB];
			soReadInodeBlock(pih, i, dirs);	
		
			// read every dirEntry on the block
			for (uint32_t j = 0; j < DPB; j++)
			{
				//if (name == "\0")
				//	continue;

				std::string finalName;

				if (dirs[j].in == NullInodeReference && dirs[j].nameBuffer[0] != '\0')
					finalName = std::string(dirs[j].nameBuffer) + std::string(dirs[j+1].nameBuffer);
				else
					finalName = std::string(dirs[j].nameBuffer);

				// name exists in the directory
				if (finalName == std::string(name))
					return dirs[j].in;
			}
		}

		// soSaveInode(pih);
		soCloseInode(pih);
		return NullInodeReference;
	}
};

