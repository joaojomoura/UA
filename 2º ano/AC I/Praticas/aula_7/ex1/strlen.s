# O argumento da função é passado em $a0
# O resultado é devolvido em $v0
# Sub-rotina terminal: não devem ser usados registos $sx
# Mapa de registos
 # s = $t0
 # len = $t1
	.data
	.eqv	s,$t0
	.eqv	len,$t1
	.text
	.globl	strlen
strlen:
	li	len,0		# len = o
while:				# while(*s++ != '\0'){
	lb	s,0($a0)	# 	s = char[0]
	addiu	$a0,$a0,1	# 	*s++
	beq	s,'\0',endw
	addi	len,len,1	#	len++
	j	while		# }
endw:
	move	$v0,len		# return len
	jr	$ra
	