/*
 *  \author António Rui Borges - 2012-2015
 *  \authur Artur Pereira - 2016-2020
 *  \completed Joao Moura 43889
 */

#include "freedatablocks.h"
#include "bin_freedatablocks.h"
#include "grp_freedatablocks.h"

#include <string.h>
#include <errno.h>
#include <iostream>

#include "core.h"
#include "devtools.h"
#include "daal.h"

namespace sofs21
{
    void grpReplenishFromCache(void)
    {
        soProbe(443, "%s()\n", __FUNCTION__);


        
        
        /* replace this comment and following line with your code */
        //binReplenishFromCache();
        SOSuperblock *sb = soGetSuperblockPointer();
        
        // Verifica se ou a retrieval esta vazia ou a insertion tem algo
        if (sb->retrieval_cache.idx != REF_CACHE_SIZE || sb->insertion_cache.idx == 0)
            return; 
        
        // ate a lista da insertion acabar copia os elementos para a retrieval e mete os da insertion a (nil)
        while(sb->insertion_cache.idx > 0)
        {
            sb->retrieval_cache.ref[sb->retrieval_cache.idx-1] = sb->insertion_cache.ref[sb->insertion_cache.idx-1]; // [*-1] pois indice de array
            sb->insertion_cache.ref[sb->insertion_cache.idx-1] = NullBlockReference; 
            sb->retrieval_cache.idx--;
            sb->insertion_cache.idx--;
        } 
        
        // grava para o superblock
        soSaveSuperblock();
    }
};

