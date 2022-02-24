/*
 *  \authur Artur Pereira - 2016-2021
 */

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <errno.h>

namespace sofs21
{
    /* ********************************************************* */

//#if false
    /* Considering bn is the number of a data block containing references to
     * data blocks, return the value of its idx position
     */
    static uint32_t grpGetIndirectInodeBlock(uint32_t bn, uint32_t idx);

    /* Considering bn is the number of a data block containing references
     * to data blocks containing references to data blocks (double indirection),
     * return the value of its idx position
     */
    static uint32_t grpGetDoubleIndirectInodeBlock(uint32_t bn, uint32_t idx);
//#endif

    /* ********************************************************* */

    uint32_t grpGetInodeBlock(int ih, uint32_t fbn)
    {
        soProbe(301, "%s(%d, %u)\n", __FUNCTION__, ih, fbn);

        /* replace this comment and following line with your code */
        //return binGetInodeBlock(ih, fbn);

        //check if fbn is A valid inode block number 
        if(N_DIRECT + RPB + RPB*RPB < fbn) throw SOException(EINVAL, __FUNCTION__);

        SOInode* inode_pointer = soGetInodePointer(ih);
        uint32_t dataBlockNumber;
        uint32_t d_Start = 0;
        uint32_t i1_Start = -1;
        uint32_t i2_Start = -1;

        if(fbn < N_DIRECT)
        {
            d_Start = fbn;
            i1_Start = 0;
            i2_Start = 0;
            dataBlockNumber = inode_pointer -> d[d_Start];
        }
        else if (fbn < N_DIRECT + RPB){
            d_Start = N_DIRECT;
            i1_Start = (fbn - N_DIRECT);
            i2_Start = 0;
            dataBlockNumber = grpGetIndirectInodeBlock(fbn-N_DIRECT, i1_Start);
        }
        else if (fbn < N_DIRECT + RPB + RPB*RPB){
            d_Start = N_DIRECT;
            i1_Start = RPB + N_DIRECT;
            i2_Start = (fbn - N_DIRECT - RPB)/(RPB*RPB);
            dataBlockNumber = grpGetDoubleIndirectInodeBlock(fbn - N_DIRECT- RPB, i2_Start);
        }

        return dataBlockNumber;
    }

    /* ********************************************************* */

//#if false
    static uint32_t grpGetIndirectInodeBlock(uint32_t bn, uint32_t idx)
    {
        soProbe(301, "%s(%d, %d)\n", __FUNCTION__, bn, idx);

        /* replace the following two lines with your code */
        //throw SOException(ENOSYS, __FUNCTION__); 
        
        uint32_t refBlock[RPB];

        for(uint32_t i = 0; i < RPB; i++) {
            if(i == idx && refBlock[bn/i] == NullBlockReference){
                return NullBlockReference;
            }    
        }

        soReadDataBlock(refBlock[bn/RPB], &refBlock);

        return refBlock[bn % RPB];
    }
//#endif

    /* ********************************************************* */

//#if false
    static uint32_t grpGetDoubleIndirectInodeBlock(uint32_t bn, uint32_t idx)
    {
        soProbe(301, "%s(%d, %d)\n", __FUNCTION__, bn, idx);

        /* replace the following two lines with your code */
        //throw SOException(ENOSYS, __FUNCTION__); 
        
        uint32_t refBlock2[RPB];


        for(uint32_t i = 0; i < RPB; i++) {
            if(i == idx && refBlock2[bn/(i*i)] == NullBlockReference){
                return NullBlockReference;
            }    
        }

        soReadDataBlock(refBlock2[bn/RPB*RPB], &refBlock2);


        uint32_t refBlock1[RPB];
        for(uint32_t i = 0; i < RPB; i++) {
            if(i == idx && refBlock2[bn] == NullBlockReference){
                return NullBlockReference;
            }    
        }

        soReadDataBlock(refBlock1[bn/RPB%RPB], &refBlock1);

        return refBlock1[bn % RPB % RPB];
    }
//#endif
};

