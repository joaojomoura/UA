	.data
	.text
	.globl main
	
main:	
	ori 	$t0,$0,0x1234	# t0 = 0x1234
	ori 	$t1,$0,0xf0f0	# t1 = 0xF0F0
	and 	$t2,$t0,$t1	# t2 = t0 & t1
	or	$t3,$t0,$t1	# t3 = t0 | t1
	nor	$t4,$t0,$t1	# t4 = ~(t3)
	xor	$t5,$t0,$t1	# t5 = t0 ^ t1
	
	ori	$t0,$0,0x0f1e	# t0 = 0x0F1E
	nor	$t1,$t0,$0	# t1 = ~(t0)
	
	jr	$ra		#fim