/*
 *  \authur Artur Pereira - 2016-2021
 */

#include "inodeblocks.h"
#include "bin_inodeblocks.h"
#include "grp_inodeblocks.h"

#include "freedatablocks.h"
#include "daal.h"
#include "core.h"
#include "devtools.h"

#include <errno.h>

#include <iostream>

namespace sofs21
{

    uint32_t i1size = N_DIRECT * RPB;
    uint32_t i2size = N_DIRECT * (RPB * RPB);
//#if false
    static uint32_t grpAllocIndirectInodeBlock(int ih, uint32_t & i1, uint32_t idx);
    static uint32_t grpAllocDoubleIndirectInodeBlock(int ih, uint32_t & i2, uint32_t idx);
//#endif

    /* ********************************************************* */

    uint32_t grpAllocInodeBlock(int ih, uint32_t ibn)
    {
        soProbe(302, "%s(%d, %u)\n", __FUNCTION__, ih, ibn);

        /* replace the following two lines with your code */
        //return binAllocInodeBlock(ih, ibn);
        
        SOSuperblock *sp = soGetSuperblockPointer();

        if(ibn >= N_DIRECT + i1size + i2size or sp->itotal < ih or ih < 0){
            throw SOException(EINVAL, __FUNCTION__);
        }
        
        SOInode *ipointer = soGetInodePointer(ih);
        uint32_t dbn;
        
        if(ibn < N_DIRECT){
            if(ipointer->d[ibn] != NullBlockReference){
                throw SOException(ESTALE, __FUNCTION__);
            }
            dbn = soAllocDataBlock();
            ipointer->blkcnt++;
            ipointer->d[ibn] = dbn;
        }
        else if(N_DIRECT <= ibn and ibn < N_DIRECT + RPB){
            uint32_t idx = ibn - N_DIRECT;
            dbn = grpAllocIndirectInodeBlock(ih, ipointer->i1, idx);
        }
        
        else{
            uint32_t idx = ibn - N_DIRECT - RPB;
            dbn = grpAllocDoubleIndirectInodeBlock(ih, ipointer->i2, idx);
        }
        
        return dbn;
        
    }

    /* ********************************************************* */

//#if false
    /*
    */
    static uint32_t grpAllocIndirectInodeBlock(int ih, uint32_t & i1, uint32_t idx)
    {
        soProbe(302, "%s(%d, %u, %u)\n", __FUNCTION__, ih, i1, idx);

        /* replace the following two lines with your code */
        //throw SOException(ENOSYS, __FUNCTION__); 
        //return 0;
        SOInode *ipointer = soGetInodePointer(ih);
        uint32_t dbn;
        uint32_t blockref;
        uint32_t ref[RPB];
        if(i1 == NullBlockReference){
            blockref = soAllocDataBlock();
            ipointer->blkcnt++;
            i1 = blockref;
            for(unsigned long i = 0; i < RPB; i++){
                ref[i] = NullBlockReference;
            }
        }
        else{
            blockref = i1;
            soReadDataBlock(blockref, ref);
        }
        //if(ipointer->d[idx] == NullBlockReference){
            dbn = soAllocDataBlock();
            ipointer->blkcnt++;
            ref[idx] = dbn;
            soWriteDataBlock(blockref, ref);
            return dbn;
        //}
        //else{
            //throw SOException(ESTALE, __FUNCTION__);
        //}
    }
//#endif

    /* ********************************************************* */

//#if false
    /*
    */
    static uint32_t grpAllocDoubleIndirectInodeBlock(int ih, uint32_t & i2, uint32_t idx)
    {
        soProbe(302, "%s(%d, %u, %u)\n", __FUNCTION__, ih, i2, idx);

        /* replace the following two lines with your code */
        //throw SOException(ENOSYS, __FUNCTION__); 
        //return 0;

        SOInode *ipointer = soGetInodePointer(ih);
        uint32_t dbn;
        uint32_t blockrefi1;
        uint32_t refi1[RPB];
        if(i2 == NullBlockReference){
            blockrefi1 = soAllocDataBlock();
            ipointer->blkcnt++;
            i2 = blockrefi1;
            for(unsigned long i = 0; i < RPB; i++){
                refi1[i] = NullBlockReference;
            }
        }
        else{
            blockrefi1 = i2;
            soReadDataBlock(blockrefi1, refi1);
        }
        
        dbn = grpAllocIndirectInodeBlock(ih, ipointer->i1, idx - RPB);

        soWriteDataBlock(blockrefi1, refi1);

        return dbn;
    }
//#endif
};
