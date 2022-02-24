/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2009-2020
 */

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include <stdio.h>
#include <errno.h>
#include <inttypes.h>
#include <time.h>
#include <unistd.h>
#include <sys/types.h>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    uint32_t grpAllocDataBlock()
    {
        soProbe(441, "%s()\n", __FUNCTION__);

        /* replace this comment and following line with your code */
        //return binAllocDataBlock();


        // A reference to a free data block is retrieved from the retrieval cache.
        // superBlock pointer 
        SOSuperblock* sb = soGetSuperblockPointer();

        // if the retrieval cache is empty
        if (sb-> retrieval_cache.idx == REF_CACHE_SIZE)
        {
            // 1º chamar  soReplenishFromBitmap 
            soReplenishFromBitmap();
            // depois verificar se continua vazio 
            if (sb-> retrieval_cache.idx == REF_CACHE_SIZE)
            {
                 // se sim chamar o  soReplenishFromCache
                 soReplenishFromCache();
            }
        }

        // The first reference must be retrieved from retrieval cache and returned 
        uint32_t block;
        /* O block representa o datablock que está na primeira posição ocupada
        do array de elementos que estão na retrieval_cache (ref[idx])
        */
        block = sb -> retrieval_cache.ref[sb -> retrieval_cache.idx];
        /** A posição onde estava o datablock passa a ter o valor null **/
        sb -> retrieval_cache.ref[sb -> retrieval_cache.idx] = NullBlockReference;

        /* some superblock's fields (dbfree, insertion_cache) must be updated properly. */
        sb -> retrieval_cache.idx += 1; // aumenta o indice (idx) do próximo bloco a ser alocado
        sb -> dbfree -= 1; // decrementa o nº de free datablocks, pois um foi alocado
        

        // ERROR: ENOSPC if there are no free data blocks
        if (sb -> dbfree == 0)
        {
            throw SOException(ENOSPC, __FUNCTION__);
        }


        soSaveSuperblock(); //Save superblock to disk.

        return block;
    }
};

