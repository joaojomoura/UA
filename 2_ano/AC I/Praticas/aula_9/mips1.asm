	.data
	.eqv	read_int,5
	.eqv	print_float,2
	.eqv	tmp,$f4
	.eqv	val,$t0
	.eqv	res,$f6
f:	.float	2.59375
	.text
	.globl	main
main:
	mtc1	$0,$f8
	cvt.s.w	$f8,$f8		# f8 = 0.0
	l.s	tmp,f		# tmp = f
do:				# do{
	li	$v0,read_int
	syscall			
	move	val,$v0		#	val = read_int
	mtc1	val,res		#	res = (float) val
	cvt.s.w	res,res		#
	mul.s	res,res,tmp	#	res = val * f
	mov.s	$f12,res
	li	$v0,print_float
	syscall			#	print_float(res)
	c.eq.s	res,$f8
	bc1f	do	
	li	$v0,0
	jr	$ra