#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "direntries.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <libgen.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/stat.h>

namespace sofs21
{
    uint16_t grpTraversePath(char *path)
    {
        soProbe(221, "%s(%s)\n", __FUNCTION__, path);

        /* replace this comment and following line with your code */
        //return binTraversePath(path);
        char *parent = dirname(strdupa(path));
        char *base = basename(strdupa(path));

        if(strcmp(base, parent) == 0)
            return 0;
        uint16_t parent_inode = grpTraversePath(parent);
        int pih = soOpenInode(parent_inode);
        if(soCheckInodeAccess(pih,1)){
            uint16_t directory = soGetDirentry(pih, base);
            soCloseInode(pih);
            if(directory != NullInodeReference){
                return directory;
            }
            throw SOException(ENOTDIR, __FUNCTION__);
        }
        throw SOException(EACCES, __FUNCTION__);
    }
};

