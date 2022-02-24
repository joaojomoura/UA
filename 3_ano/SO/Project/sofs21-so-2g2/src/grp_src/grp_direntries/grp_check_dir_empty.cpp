#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <sys/stat.h>

namespace sofs21
{
    bool grpCheckDirEmpty(int ih)
    {
        soProbe(205, "%s(%d)\n", __FUNCTION__, ih);

        /* replace the following line with your code */
        // return binCheckDirEmpty(ih);
        SOInode* pih = soGetInodePointer(ih);   // inode handler pointer

        for (uint32_t i = 0; i <= pih->size/BlockSize; i++)
        {
            SODirectorySlot dir[DPB];
            soReadInodeBlock(ih, i, dir);
            for (uint32_t j = 2; j < DPB; j++)
            {
                if (strcmp(dir[j].nameBuffer, "\0") != 0) // verify if empty
                {
                    return false;
                } 
            }
        }
        
        return true;
    }
};

