# Mapa de registos:
# str: $a0 -> $s0 (argumento é passado em $a0)
# p1:  $s1  (registo callee-saved)
# p2:  $s2  (registo callee-saved)
#
	.data
	.eqv	str,$s0
	.eqv	p1,$s1
	.eqv	p2,$s2
	.text
	.globl	strrev
strrev:
	addiu	$sp,$sp,-16		# reserva espaço na stack
	sw	$ra,0($sp)		# guarda endereço de retorno
	sw	str,4($sp)		# guarda valor dos registos
	sw	p1,8($sp)		# $s0, $s1 e $s2
	sw	p2,12($sp)		#
	move	str,$a0			# registo "callee-saved"
	move	p1,$a0			# p1 = str
	move	p2,$a0			# p2 = str
while1:					# 
	lb	$s3,0(p2)		# s3 = *p2 = conteudo do endereco da str
	beq	$s3,'\0',endw1		# while( *p2 != '\0' ) {
	addiu	p2,p2,1			#	p2++
	j	while1			# }
endw1:
	addiu	p2,p2,-1		# p--
while2:
	bgeu	p1,p2,endw2		# while(p1 < p2) {
	move	$a0,p1			#
	move	$a1,p2			#
	jal	exchange		#	exchange(p1, p2);
	addiu	p1,p1,1			#	p1++
	addiu	p2,p2,-1		#	p2--
	j	while2			# }
endw2:
	move $v0,str
	lw $ra,0($sp)
	lw $s0,4($sp)
	lw $s1,8($sp)
	lw $s2,12($sp)
	addiu $sp,$sp,16 
	jr $ra
	
	
exchange:
	lb	$t0,0($a0)
	lb	$t1,0($a1)
	sb	$t0,0($a1)
	sb	$t1,0($a0)
	jr	$ra
	
	