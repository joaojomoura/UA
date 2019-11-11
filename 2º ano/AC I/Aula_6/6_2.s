# Mapa de registos:
# str: $a0 -> $s0 (argumento é passado em $a0)
# p1: $s1 (registo callee-saved)
# p2: $s2 (registo callee-saved)
#

########Inversao de frase###########

	.data
	.eqv	print_int10,1
	.eqv	print_string,4
	
str:	.asciiz	"ITED - orievA ed edadisrevinU"
newl:	.asciiz	"\n"

	.text
	.globl	main

main:	la	$a0,str			# $a0 = str;
	li	$v0,print_string	#
	syscall				# print_string(str);
	la	$a0,newl		# $a0 = newl;
	li	$v0,print_string	# 
	syscall				# print_String(newl);
	la	$a0,str			# $a0 = str;
	sw	$ra,0($sp)		# 
	jal	strrev			# 
	lw	$ra,0($sp)		#
	move	$a0,$v0			# $a0 = strrev (str);
	li	$v0,print_string	#
	syscall				# print_string($a0);
	jr	$ra			# terminate program


strrev:	addiu	$sp,$sp,-16		# reserva espaço na stack
	sw	$ra,0($sp)		# guarda endereço de retorno
	sw	$s0,4($sp)		# guarda valor dos registos
	sw	$s1,8($sp)		# $s0,$s1,$s2
	sw	$s2,12($sp)		#
	move	$s0,$a0			# registo callee-saved
	move	$s1,$a0			# p1 = str
	move	$s2,$a0			# p2 = str
	
while1:	lb	$s3,0($s2)		# s3 = *p2
	beq	$s3,'\0',endw		# while(*p != '\0') {
	addi	$s2,$s2,1		#	p2++;
	j	while1			# }
endw:	sub	$s2,$s2,1		# p--;
					#
while2:	bge	$s1,$s2,endw2		# while (p1 < p2) {
	move	$a0,$s1			#	$a0 = p1;
	move	$a1,$s2			#	$a1 = p2;
	jal	exchan			#	exchange(p1,p2);
	addi	$s1,$s1,1		#	p1++;
	sub	$s2,$s2,1		#	p2--;
	j	while2			# }
endw2:	move	$v0,$s0			# return str;
	lw	$ra,0($sp)		# repoe endereço de retorno
	lw	$s0,4($sp)		# repoe o valor dos registos
	lw	$s1,8($sp)		# $s0,$s1, $s2
	lw	$s2,12($sp)		#
	addiu	$sp,$sp,16		# liberta espaço da stack
	jr	$ra			# termina funçao
	
exchan:	lb	$t0,0($a0)		# t0 = *p1;
	lb	$t1,0($a1)		# t1 = *p2;
	sb	$t0,0($a1)		# *p1 = *p2;
	sb	$t1,0($a0)		# *p2 = *p1;
	jr	$ra			# termina funçao