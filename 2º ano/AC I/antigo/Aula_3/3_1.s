# Mapa de registos:
# $t0 = soma
# $t1 = value
# $t2 = i
	
	.data
str1:	.asciiz	"Introduza um numero: "
str2:	.asciiz	"Valor ignorado\n"
str3:	.asciiz	"A soma dos positivos e: "
	.eqv 	print_string,4
	.eqv	read_int,5
	.eqv 	print_int10,1
	.eqv	println,11
	.text
	.globl main

main:	li	$t0,0			# soma = 0
	li	$t2,0			# i = 0
					#
for:	bge 	$t2,5,endfor		# while (i < 5) {
	la	$a0,str1		# 
	ori	$v0,$0,print_string	#
	syscall				# 	print_string(str1);
	ori	$v0,$0,read_int		#
	syscall				#
	or	$t1,$v0,$0		# 	value = read_int();
	ble	$t1,$0,else		#	if (value > 0)
	add	$t0,$t1,$t0		#		soma = soma + value;
	j	endif			#
					#
else:	la	$a0,str2		#	else
	ori	$v0,$0,print_string	#		print_string (str2);
	syscall				#
					#
endif:	addi	$t2,$t2,1		#	i++;
	j	for			# }
					#
endfor:	la	$a0,str3		#
	ori	$v0,$0,print_string	#
	syscall				# print_string (str3);
	or	$a0,$0,$t0		#
	ori	$v0,$0,print_int10	# print_int10 (soma);
	syscall				#
	jr	$ra			#