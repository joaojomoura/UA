# O argumento da função é passado em $a0
# O resultado é devolvido em $v0
# Sub-rotina terminal: não devem ser usados registos $sx

	.data 
	.eqv	print_int10,1
	.eqv	print_string,4
str:	.asciiz "Arquitetura de Computadores I\n"
	.text
	.globl 	main
main:
	la	$a0,str
	li	$v0,print_string
	syscall			#print_string (str)
	sw	$ra,0($sp)	# guarda o endereco retorno da main
	jal	strlen		# chama a funcao
	lw	$ra,0($sp)	# restora o endereco da main
	move	$a0,$v0		# $a0 = strlen(str)
	li	$v0,print_int10
	syscall			# print_int10($a0)
	jr	$ra
	
	

strlen:	
	li	$t1,0		# len = 0
while:	lb	$t0,0($a0)	# $t0 = *s
	addiu	$a0,$a0,1	# *s++
	beq	$t0,'\0'endw	# while(*s++ != '\0'){
	addi	$t1,$t1,1	#	len++
	j	while		# }
endw:	move	$v0,$t1		# return len;
	jr	$ra