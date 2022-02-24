#include "grp_mksofs.h"

#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <inttypes.h>
#include <iostream>
#include <math.h>

namespace sofs21
{
    uint32_t roundUp(int value, int mult){
        if(mult == 0)
            return value;
        int r = value % mult;
        if(r == 0)
            return value;
        return value + mult - r;
    }
    void grpComputeDiskStructure(uint32_t ntotal, uint16_t itotal, uint16_t & itsize, uint32_t & dbtotal)
    {
        soProbe(601, "%s(%u, %u, ...)\n", __FUNCTION__, ntotal, itotal);

        /* replace this comment and following line with your code */
        //binComputeDiskStructure(ntotal, itotal, itsize, dbtotal);
        
        if(itotal == 0){
            itotal = ntotal/20;
        }
        int roundntotal = roundUp(ntotal, (ntotal/8));
        if(itotal > roundntotal){
            itotal = ntotal/8;
        }
        if(itotal > MAX_INODES){
            itotal = MAX_INODES;
        }
        if(itotal < IPB){
            itotal = IPB;
        }
        if(itotal % IPB != 0){
            itotal = roundUp(itotal, IPB);
        }
        itsize = itotal/IPB;
        dbtotal = ntotal - 2 - itsize;
        if(ntotal > 8220){
            dbtotal -= (round((ntotal - 2 - itsize)/(RPB * 32)));
        }
        
    }
};

