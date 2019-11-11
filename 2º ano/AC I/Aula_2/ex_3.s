	.data
str1:	.asciiz	"Uma string qualquer"
str2:	.asciiz	"Ac1 - P"
	.eqv print_str,4
	
	.text
	.globl main

main:	la	$a0,str2		# instrução virtual, decomposta pelo
 					# assembler em 2 instruções nativas 	
	ori	$v0,$0,print_str	# $v0 = 4
	syscall				# print_string (str2)
	jr	$ra			# fim