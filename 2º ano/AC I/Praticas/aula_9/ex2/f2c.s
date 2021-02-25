	.data
f1:	.double	5.0
f2:	.double	32.0
	.text
	.globl	f2c
f2c:
	li	$t1,9		# t0 = 9
	mtc1	$t1,$f4
	cvt.d.w	$f4,$f4		# f4 = 9.0
	l.d	$f6,f1		# f6 = 5.0
	l.d	$f8,f2		# f8 = 32.0
	sub.d	$f8,$f12,$f8	# f8 = ft - 32
	div.d	$f0,$f6,$f4	# f0 = 5.0/9.0
	mul.d	$f0,$f0,$f8	# f0 = f0 * f8
	jr	$ra
	
	