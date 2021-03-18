	.data
	.eqv	read_double,7
	.eqv	print_string,4
	.eqv	print_double,3
str:	.asciiz	"\nTemperatura em Fahreneit: "
str2:	.asciiz "\n Temperatura em Celsius: "
	.text
	.globl	main
main:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	
	la	$a0,str
	li	$v0,print_string
	syscall
	li	$v0,read_double
	syscall
	mov.d	$f12,$f0
	jal	f2c
	la	$a0,str2
	li	$v0,print_string
	syscall
	mov.d	$f12,$f0
	li	$v0,print_double
	syscall
	
	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	jr	$ra