# Mapa de registos:
# $f0 -> res
# $f4 -> val
	
	.data
	.eqv	read_int,5
	.eqv	print_float,2
x1:	.float	0.0
x:	.float	2.59375
	.text
	.globl	main
	
main:	
do:	li	$v0,read_int
	syscall
	mtc1	$v0,$f4		# f4 = val
	cvt.s.w	$f4,$f4		#conversao -> f4 = (float) f4 
	l.s	$f2,x		# tmp = 2.59375
	mul.s	$f0,$f2,$f4	# res = (float)val * 2.59375;
	li	$v0,print_float
	mov.s	$f12,$f0	# move (single) -> mover o resultado para o registo $f12
	syscall
	l.s	$f6,x1
	c.eq.s 	$f6,$f0
	bc1f 	do
	
	jr	$ra