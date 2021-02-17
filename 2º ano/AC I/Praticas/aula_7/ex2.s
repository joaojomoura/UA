# Mapa de registos:
# str: $a0 -> $s0 (argumento é passado em $a0)
# p1:  $s1  (registo callee-saved)
# p2:  $s2  (registo callee-saved)
#
	.data
	.eqv	print_string,4
str:	.asciiz	"ITED - orievA ed edadisrevinU\n"
	.text
	.globl	main
main:
	la	$a0,str
	li	$v0,print_string
	syscall			#print_string(str)
	sw	$ra,0($sp)
	jal	sttrev
	lw	$ra,0($sp)
	move	$a0,$v0		# $a0 = sttrev(str)
	li	$v0,print_string
	syscall			#print_string($a0)
	jr	$ra

sttrev:	addiu	$sp,$sp,-16	# reserva espaco na stack
	sw	$ra,0($sp)	# guarda o endereco de retorno
	sw	$s0,4($sp)	# guarda o valor de $s0
	sw	$s1,8($sp)	# guarda o valor de $s1
	sw	$s2,12($sp)	# guarda o valor de $s2
	move 	$s0,$a0 	# registo "callee-saved"
	move 	$s1,$a0 	# p1 = str
	move 	$s2,$a0		# p2 = str
while1:
	lb	$s3,0($s2)	# s3 = *p2
	beq	$s3,'\0',endw1	# while(*p2 != '\0'){
	addi	$s2,$s2,1	# 	p2++
	j	while1		# }
endw1:	sub	$s2,$s2,1	# p--;
while2:
	bge	$s1,$s2,endw2	# while(p1 < p2){
	move	$a0,$s1		# 	$a0 = p1
	move	$a1,$s2		# 	$a1 = p2
	jal	exchange	# 	exchange($a0,$a1) = exchange (p1,p2)
	addi	$s1,$s1,1	# 	p1++
	addi	$s2,$s2,-1	# 	p2--
	j	while2		# }
endw2:	move	$v0,$s0		# return str
	lw	$ra,0($sp)	# devolve o endereco de retorno
	lw	$s0,4($sp)	# devolve o valor de $s0
	lw	$s1,8($sp)	# devolve o valor de $s1
	lw	$s2,12($sp)	# devolve o valor de $s2
	addiu	$sp,$sp,16	# liberta o espaco da stack
	jr	$ra		# termina

exchange:
	lb	$t0,0($a0)	# t0 = *p1
	lb	$t1,0($a1)	# t1 = *p2
	sb	$t0,0($a1)	# *p2 = *p1
	sb	$t1,0($a0)	# *p1 = *p2
	jr	$ra



	