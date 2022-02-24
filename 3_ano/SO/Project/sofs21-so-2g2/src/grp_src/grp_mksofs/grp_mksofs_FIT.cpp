#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <string.h>
#include <time.h>
#include <unistd.h>
#include <sys/stat.h>
#include <inttypes.h>

namespace sofs21
{
    void grpFillInInodeTable(uint16_t itsize, bool date)
    {
        soProbe(604, "%s(%u)\n", __FUNCTION__, itsize);

        /* replace this comment and following line with your code */
        //binFillInInodeTable(itsize, date);
    
          //Create IPB (number of inodes per block) inodes 
        SOInode inodes[IPB];

        memset(inodes,0,sizeof(inodes));    // inicializar tudo a 0

        /* Percorre os blocos da tabela de inodes*/
        for (unsigned long blockID = 1; blockID <= itsize; blockID++)
        {
            /* Percorre os inodes da tabela de inodes */
            for (unsigned long inodeID = 0; inodeID < IPB; inodeID++){


                 /* Fill in inode number 0 */
                if (blockID == 1 && inodeID == 0)
                {
                    inodes[inodeID].mode = S_IFDIR | 0775;
                    inodes[inodeID].lnkcnt = 2;     //  2 directory entries 
                    inodes[inodeID].owner = getuid();
                    inodes[inodeID].group = getgid();
                    inodes[inodeID].size = BlockSize;
                    inodes[inodeID].blkcnt = 1;
                            
                    if(date){

                        inodes[inodeID].atime = time(NULL);        // time(NULL) -- data atual 
                        inodes[inodeID].mtime = time(NULL);
                        inodes[inodeID].ctime = time(NULL);

                    } 
                    
                }

                /* inode number 0 must be filled knowing it is the root directory */
                if(blockID == 1 && inodeID == 0)
                {
                    inodes[inodeID].d[0] = 0;   // reference to root dir
                }  

                // all reference fields at NullBlockReference

                    for(int i = 0; i < N_DIRECT; i++)
                {
                    inodes[inodeID].d[i] = NullBlockReference;
                }

                inodes[inodeID].i1 = NullBlockReference;
                inodes[inodeID].i2 = NullBlockReference;
 
            }
            /** Write a block of data from the storage device. 
            * firstArg:  physical number of the disck block to be write
            * secondArg: pointer to the buffer containing the data to be written from
            */
            soWriteRawBlock(blockID, &inodes);  
        }
     }
};

