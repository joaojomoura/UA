
	.data
	.text
	.globl main
main:
	li	$t0,4		# t0 = valor
	srl 	$t1,$t0,1 	# t1 = t0 >> 1
	xor	$t2,$t0,$t1	# t0 = t0 ^ t1
	jr $ra