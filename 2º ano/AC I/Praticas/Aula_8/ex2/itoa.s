# Mapa de registos
# n = $s0
# b = $s1
# s = $s2
# p = $s3
# digit = $t0
# Sub-rotina intermédia

	.data
	.eqv	n,$s0
	.eqv	bb,$s1
	.eqv	s,$s2
	.eqv	p,$s3
	.eqv	digit,$t0
	.text
	.globl	itoa
itoa:
	addiu	$sp,$sp,-20
	sw	$ra,0($sp)
	sw	$s0,4($sp)
	sw	$s1,8($sp)
	sw	$s2,12($sp)
	sw	$s3,16($sp)
	
	move	n,$a0
	move	bb,$a1
	move	s,$a2
	
	move	p,$a2		# p = s
do:				# do{
	rem	digit,n,bb	#	digit = n % b;
	div	n,n,bb		#	n = n / b;
	move	$a0,digit
	jal	toascii		#	toascii(digit)
	sb	$v0,0(p)	#	*p = toascii(digit)
	addiu	p,p,1		#	p++
while:	bgt	n,0,do		# } while( n > 0 );

	sb	$0,0(p)	# *p = '\0'
	move	$a0,s
	jal	strrev
	move	$v0,s		
	
	lw $ra, 0($sp)		# repõe registos $sx e $ra
	lw $s0, 4($sp)
	lw $s1, 8($sp)
	lw $s2, 12($sp)
	lw $s3, 16($sp)
				# (...)
	addiu $sp, $sp, 20	# liberta espaço na stack
	jr $ra 			# termina o programa