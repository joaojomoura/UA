#Mapa de registos
# i - $s0
# y - $s1
# result - $f20
# x - $f22
	

	.data
	.eqv	i,$s0
	.eqv	y,$s1
	.eqv	result,$f20
	.eqv	x,$f22
	.text
	.globl	xtoy
xtoy:
	addiu	$sp,$sp,-28
	sw	$ra,0($sp)
	sw	$s0,4($sp)
	sw	$s1,8($sp)
	s.d	$f20,12($sp)
	s.d	$f22,20($sp)
	
	li	i,0		# i = 0
	li	$t0,1
	mtc1	$t0,$f20
	cvt.s.w $f20,$f20	# result = 1.0
	
	move	y,$a0		# y = a0
	mov.s 	x,$f12		# x = f12
	
	move	$a0,y
	jal	abso
	move	$t0,$v0		# t0 = abs(y)
for:
	bge	i,$t0,endfor	# while(i < t0){
	blez	y,else		#	if(y > 0)
	mul.s	result,result,x	#		result *= x
	j	endif
else:				#	else
	div.s	result,result,x	#		result /= x
endif:
	addi	i,i,1		#	i++
	j	for
endfor:				#}
	mov.s	$f0,result	# return result
	
	lw	$ra,0($sp)
	lw	$s0,4($sp)
	lw	$s1,8($sp)
	l.d	$f20,12($sp)
	l.d	$f22,20($sp)
	addiu	$sp,$sp,28
	jr	$ra
	
	