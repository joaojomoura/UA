# Mapa de Registos
# p : $t0
# temp : $t1
# j : $t2
# lista + SIZE : $t3
# houve_troca : $t4
# i : $t5
# lista : $t6
# lista + i : $t7

 	.data
 	.eqv	FALSE,0
 	.eqv	TRUE,1
 	.eqv	SIZE,10
 	.eqv	print_int10,1
 	.eqv 	print_string,4
 	.eqv	read_int,5
 	
 str1:	.asciiz "\nIntroduza um numero: "
 str2:	.asciiz	"\nConteudo do array:\n"
 str3:	.asciiz "; "
 	

 lista:	.word	0:SIZE
 
 	.text
 	.globl	main
 
 main:	la	$t0,lista		# p = lista;
	li	$t3,SIZE		#
	sll	$t3,$t3,2		#
	addu	$t3,$t3,$t0		# $t3 = lista + SIZE;
	
	
read:	bgeu	$t0,$t3,do		# while(p < lista + SIZE) {
 	la	$a0,str1		#
	li	$v0,print_string	#
	syscall				# 	print_string(str1);
	li	$v0,read_int		#	
	syscall				#	$v0 = read_int();
	sw	$v0,0($t0)		#	*p = read_int();
 	addiu	$t0,$t0,4		#	p++;
 	j	read			# }
 	
	
	
do:	li	$t4,FALSE
	li	$t5,0
	la	$t6,lista
	li	$t1,9
	
		

while:	bgeu	$t5,$t1,endw
if:	sll	$t7,$t5,2
	addu	$t7,$t7,$t6
	lw	$t8,0($t7)
	lw	$t9,4($t7)
	ble	$t8,$t9,endif
	sw	$t8,4($t7)
	sw	$t9,0($t7)
	li	$t4,TRUE
endif:	addi	$t5,$t5,1
	
	j	while
endw:	beq	$t4,TRUE,do	
 	
 	
 	
 	
 	
 	
 	
 	
 	la	$t6,lista
 	la	$a0,str2		#
	li	$v0,print_string	#
	syscall				# print_string(str2);
 	li	$t2,0			# j = 0;
 print:	bge	$t2,SIZE,endp		# while(j < SIZE) {	
 	lw	$a0,0($t6) 		#
 	li	$v0,print_int10		#
 	syscall				#	print_int10(*p);
 	la	$a0,str3		#
 	li	$v0,print_string	#	
 	syscall				#	print_string("; ");
 	addiu	$t2,$t2,1		#	j++;
 	addiu	$t6,$t6,4
 	j	print			# }
 	
 	
 	
 	
 	
endp:	jr	$ra