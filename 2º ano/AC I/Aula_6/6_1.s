# O argumento da função é passado em $a0
# O resultado é devolvido em $v0
# Sub-rotina terminal: não devem ser usados registos $sx 

	.data
	.eqv	print_int10,1
	.eqv	print_string,4
str:	.asciiz	"Arquitetura de Computadores I555555555555555555555555555"	

	.text
	.globl	main
	
	
main:	la	$a0,str
	sw	$ra,0($sp)
	jal	strlen
	lw	$ra,0($sp)
	move	$a0,$v0
	li	$v0,print_int10
	syscall
	jr	$ra

strlen:	li	$t1,0		# len = 0;
while:	lb	$t0,0($a0)	# while(s++ != '\0')
	addiu	$a0,$a0,1	#
	beq	$t0,'\0',endw	# {
	addi	$t1,$t1,1	# 	len++;
	j	while		# }
endw:	move	$v0,$t1		# return len;
	jr	$ra		#
