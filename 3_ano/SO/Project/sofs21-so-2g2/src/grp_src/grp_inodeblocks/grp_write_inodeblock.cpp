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

namespace sofs21
{
    void grpWriteInodeBlock(int ih, uint32_t fbn, void *buf)
    {
        soProbe(332, "%s(%d, %u, %p)\n", __FUNCTION__, ih, fbn, buf);

        /* replace this comment and following line with your code */
        // binWriteInodeBlock(ih, fbn, buf);
        SOSuperblock* pointer_sb = soGetSuperblockPointer();
        int16_t in = soGetInodeNumber(ih);
        if(in>=pointer_sb->itotal || in<0)
            throw SOException(EINVAL,__FUNCTION__);

        uint32_t b = soGetInodeBlock(ih,fbn);

        if(b == NullBlockReference || b == NullInodeReference)
        {
            b = soAllocInodeBlock(ih,fbn);
        }
        
        soWriteDataBlock(b,buf);
    }
};

