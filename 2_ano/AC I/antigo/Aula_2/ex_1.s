	.data
	.text
	.globl	main
	
main:	ori	$t0,$0,0xe543	# t0 = valor de val_1
	ori	$t1,$0,0xa3e4	# t1 = valor de val_2
	and	$t2,$t0,$t1	# t2 = t0 && t1
	or	$t3,$t0,$t1	# t3 = t0 || t1
	nor	$t4,$t0,$t1	# t4 = t0 nor t1
	xor	$t5,$t0,$t1	# t5 = t0 xor t1
	nor	$t1,$t0,$t0	# t1 = not t0
	jr	$ra		#fim programa