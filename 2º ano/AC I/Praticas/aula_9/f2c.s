	.data 
x:	.double	5.0
y:	.double 9.0
z:	.double	32.0
	.text
	.globl	f2c



f2c:
	la	$t0,x		# t0 = x
	l.d	$f2,0($t0)	# f2 = (double)t0
	
	la	$t1,y		# t1 = y
	l.d	$f4,0($t1)	# f4 = (double)t1
	
	la	$t2,z		# t2 = z
	l.d	$f6,0($t2)	# f6 = (double)t2
	
	sub.d	$f12,$f12,$f6	# double ft = f12, f12 = ft - 32.0
	div.d	$f2,$f2,$f4	# f2 = 5.0/9.0
	mul.d	$f0,$f2,$f12	# return f2*f12
	
	jr	$ra