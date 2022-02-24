// file:///home/me/Documents/uni/Ano3-Sem1/SO/pr%C3%A1ticas/guiao2/sofs21-grp/doc/html/structsofs21_1_1_s_o_superblock.html#aae1fbdbca3aa685833d73e1da3d2b83e
// file:///home/me/Documents/uni/Ano3-Sem1/SO/pr%C3%A1ticas/guiao2/sofs21-grp/doc/html/group__superblock.html#gaffb1ffbd24de6be88bd8ac877aae1688
// file:///home/me/Documents/uni/Ano3-Sem1/SO/pr%C3%A1ticas/guiao2/sofs21-grp/doc/html/group__mksofs.html#gaa3dfb8e88cfb9361ab23fe0ca4244cc5
#include "grp_mksofs.h"

#include "rawdisk.h"
#include "core.h"
#include "devtools.h"
#include "bin_mksofs.h"

#include <string.h>
#include <inttypes.h>

#include <superblock.h>

namespace sofs21
{
	void grpFillInSuperblock(const char *name, uint32_t ntotal, uint16_t itsize, uint32_t dbtotal)
	{
		soProbe(602, "%s(%s, %u, %u, %u)\n", __FUNCTION__, name, ntotal, itsize, dbtotal);

		/* replace this comment and following line with your code */
//		binFillInSuperblock(name, ntotal, itsize, dbtotal);

		SOSuperblock sb;
		//SOInode intable[IPB]; //Block size bytes
//		assert(sizeof(intable) == BlockSize);

		sb.magic = 0xFFFF; // MAGIC_NUMBER;
		sb.version = VERSION_NUMBER;
		sb.mntstat = 0;
		strncpy(sb.name, name, PARTITION_NAME_LEN + 1);
		sb.ntotal = ntotal;
		
		sb.itotal = itsize * IPB;
		sb.ifree = sb.itotal - 1;

		sb.iidx = 1;

		int i;
		if (sb.itotal == 16)
			sb.ibitmap[0] = 0x0000FFFE;
		else
			sb.ibitmap[0] = 0xFFFFFFFE;

		for (i = 1; i < sb.itotal/32; i++) 
			sb.ibitmap[i] = 0xFFFFFFFF;
		
		if (sb.itotal != 16 && sb.itotal % 32 != 0)
			sb.ibitmap[i++] = 0x0000FFFF;

		for (; i < MAX_INODES/32; i++)
			sb.ibitmap[i] = 0;
		for (i = 0; i<DELETED_QUEUE_SIZE; i++)
			sb.iqueue[i] = NullBlockReference;

		sb.iqhead = 0;
		sb.iqcount = 0;

//                    sb   inode table    first
		sb.dbp_start = 1 + sb.itotal/IPB + 1;
		sb.dbtotal = dbtotal;
		sb.dbfree = dbtotal - 1;

		sb.rbm_start = itsize + 1; // #blocks on inode tab + SB
		//sb.rbm_size = (ntotal/32)/IPB; // 1 bit per block
		sb.rbm_size = ntotal - dbtotal - itsize - 1; // 1 bit per block
		sb.rbm_idx = 0;

		sb.retrieval_cache.idx = REF_CACHE_SIZE;
		for (int i=0; i<REF_CACHE_SIZE; i++)
			sb.retrieval_cache.ref[i] = NullBlockReference;

		sb.insertion_cache.idx = 0;
		for (int i=0; i<REF_CACHE_SIZE; i++)
			sb.insertion_cache.ref[i] = NullBlockReference;

		soWriteRawBlock(0, &sb);
	}
};

