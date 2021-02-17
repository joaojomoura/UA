# Mapa de registos 
# p: $t0
# pultimo:$t1
# *p $t2
# soma: $t3
	.data
	.eqv	print_int10,1
	.eqv	SIZE,4			# define SIZE 4
	.eqv	p,$t0
	.eqv	pultimo,$t1
	.eqv	pp,$t2
	.eqv	soma,$t3
	
array:	.word	7692,23,5,234		# int array[4] = {7692, 23, 5, 234};
	.text
	.globl	main
main:
	li	soma,0			# soma = 0
	li	$t4,SIZE		#
	sub	$t4,$t4,1		# t4 = size - 1 = 3
	sll	$t4,$t4,2		# t4 << 2
	la	p,array			# p = array
	addu	pultimo,p,$t4		# pultimo = array + size -1
while:					# while(p <= pultimo) {
	bgtu	p,pultimo,endw
	lw	pp,0(p)			# 
	add	soma,soma,pp		# 	soma = soma + (*p);
	addiu	p,p,4			#	p++
	j	while			# }
endw:
	move	$a0,soma
	li	$v0,print_int10
	syscall
	jr	$ra