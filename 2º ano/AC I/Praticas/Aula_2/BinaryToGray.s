	.data
	.text

	.globl main
main:	
	li	$t0,2	# bin (t0) = 2;
	srl	$t2,$t0,1	# tmp = bin >> 1;
	xor	$t1,$t0,$t2	# gray = bin ^ tmp;
	
	or	$t0,$0,$t1	# num = gray;
	srl	$t1,$t0,4	# tmp = num >> 4;
	xor	$t0,$t0,$t1	# num = num ^ (tmp);
	srl	$t1,$t0,2	# tmp = num >> 2;
	xor	$t0,$t0,$t1	# num = num ^ (tmp);
	srl	$t1,$t0,1	# tmp = num >> 1;
	xor	$t0,$t0,$t1	# num = num ^ (tmp);
	or	$t2,$0,$t0	# bin = num;
	jr	$ra