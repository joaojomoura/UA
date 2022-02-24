#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <string.h>
#include <inttypes.h>

namespace sofs21
{
    void grpZeroFreeDataBlocks(uint32_t ntotal, uint16_t itsize, uint32_t dbtotal)
    {
        soProbe(607, "%s(%u, %u, %u)\n", __FUNCTION__, ntotal, itsize, dbtotal);

        /* replace this comment and following line with your code */
        //binZeroFreeDataBlocks(ntotal, itsize, dbtotal);
        uint32_t numberInodes = itsize/IPB;
        uint32_t array[BlockSize];
        for(uint32_t i = 0; i < BlockSize; i++){
            array[i] = 0x0;
        }
        for(uint32_t i = numberInodes + 2; i < numberInodes + 1 + dbtotal; i++)
            soWriteRawBlock(i, array);
    }
};

