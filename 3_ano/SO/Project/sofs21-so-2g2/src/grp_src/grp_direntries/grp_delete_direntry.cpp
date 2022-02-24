#include "direntries.h"

#include "core.h"
#include "devtools.h"
#include "daal.h"
#include "inodeblocks.h"
#include "bin_direntries.h"

#include <errno.h>
#include <string.h>
#include <sys/stat.h>

namespace sofs21
{
    uint16_t grpDeleteDirentry(int pih, const char *name)
    {
        soProbe(203, "%s(%d, %s)\n", __FUNCTION__, pih, name);

        /* replace this comment and following line with your code */
        //return binDeleteDirentry(pih, name);

        SOInode* inode_pointer = soGetInodePointer(pih);

        //Number of blocks used by the inode
        uint32_t iBlocks = inode_pointer ->size/BlockSize;
    
        SODirectorySlot lastBlock[DPB]; // store the direntries of last block with direntries
        
        uint16_t child = 0; //Child inode number (will be returned)
        uint32_t lastDir = 0;    //last direntry

        //Check if last block was updated or not
        int check = 0;
        int entryFound = 0;


        //ReadFileBlock value of last block
        soReadInodeBlock(pih, iBlocks, lastBlock);
        
        //Finding the last direntry
        for(uint32_t i=0; i < DPB; i++){
            if(strcmp(lastBlock[i].nameBuffer, "") == 0){
                i == 0 ? lastDir = DPB-1 : lastDir = i-1;
                break;
            }
        }
        if(lastDir == DPB-1){
            iBlocks--;
            soReadInodeBlock(pih, iBlocks, lastBlock);
        }


        for(uint32_t i = 0; i <= iBlocks; i++){
           
            SODirectorySlot dirs[DPB];   // store direntries of a block
            soReadInodeBlock(pih, i, dirs);

            for(uint32_t j = 0; j < DPB; j++){
                //Direntry 'name' found
                if(strcmp(dirs[j].nameBuffer, name) == 0){
                    entryFound = 1;
                    child = dirs[j].in;

                    //If position was the last of the last block
                    if(strcmp(dirs[j].nameBuffer, lastBlock[lastDir].nameBuffer) == 0){
                        strcpy(dirs[j].nameBuffer, "");
                        dirs[j].in = 0;
                        
                        //If block became empty
                        if(j==0){
                            soWriteInodeBlock(pih, i, dirs);
                            check = 1;
                            soFreeInodeBlocks(pih, i);
                            break;
                        }
                    }
                    //If position was not the last of them all
                    else{
                        strcpy(dirs[j].nameBuffer, lastBlock[lastDir].nameBuffer);
                        dirs[j].in = lastBlock[lastDir].in;

                        //If position was in the last block an update must be done on the lastBlock buffer
                        if(i == iBlocks){
                            strcpy(lastBlock[j].nameBuffer, dirs[j].nameBuffer);
                            lastBlock[j].in = dirs[j].in;
                        }
                    }
                    soWriteInodeBlock(pih,i,dirs);

                    break;
                }
            }
        }

        //Update the last block if necessary (using lastBlock buffer)
        if(check == 0 && entryFound == 1){
            lastBlock[lastDir].in = 0;
            strcpy(lastBlock[lastDir].nameBuffer , "");
            soWriteInodeBlock(pih, iBlocks, lastBlock);
            
            if(lastDir == 0)
                soFreeInodeBlocks(pih, iBlocks);
            check = 1;
        }

        //Size of inode is only updated if an entry was found
        if(entryFound == 1)
            inode_pointer -> size -= sizeof(SODirectorySlot);


        soSaveInode(pih);        
        return child; 
    }
};

