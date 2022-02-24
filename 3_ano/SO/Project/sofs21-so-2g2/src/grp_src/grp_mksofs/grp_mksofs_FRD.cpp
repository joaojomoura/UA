#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <string.h>
#include <inttypes.h>

namespace sofs21
{
    /*
       filling in the contents of the root directory:
       the first 2 entries are filled in with "." and ".." references
       the remainding of the block is filled with zeros.
       */
    void grpFillInRootDir(uint32_t ntotal, uint16_t itsize, uint32_t dbtotal)
    {
        soProbe(606, "%s(%u, %u, %u)\n", __FUNCTION__, ntotal, itsize, dbtotal);

        /* replace this comment and following line with your code */
        //binFillInRootDir(ntotal, itsize, dbtotal);

        SODirectorySlot dirSlot[DPB];

        dirSlot[0].in = 0;
        strcpy(dirSlot[0].nameBuffer, ".");
        dirSlot[1].in = 0;
        strcpy(dirSlot[1].nameBuffer, "..");

        for (unsigned int i = 2; i < DPB; i++) {
            dirSlot[i].in = 0x0;
            strcpy(dirSlot[i].nameBuffer,"\0"); 
            //strncpy(dirSlot[i].nameBuffer,"\0",SOFS21_FILENAME_LEN);
        }
        
        soWriteRawBlock(ntotal/IPB + 1, dirSlot);
    }
};

