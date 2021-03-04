	.data
	
	.eqv	id_number,0
	.eqv	first_name,4
	.eqv	last_name,22
	.eqv	grade,40
	.eqv	print_str,4
	.eqv	print_char,11
	.eqv	print_intu10,36
	.eqv	print_float,2
str1:	.asciiz "\nID: "
str2:	.asciiz "\nPrimeiro Nome: "
str3:	.asciiz "\nUltimo Nome: "
str4:	.asciiz "\nNota: "
	.text
	.globl	print
print:
	move	$t0,$a0
	
	la	$a0,str1
	li	$v0,print_str
	syscall
	lw	$a0,id_number($t0)
	li	$v0,print_intu10
	syscall
	
	la	$a0,str2
	li	$v0,print_str
	syscall
	addiu	$a0,$t0,first_name
	li	$v0,print_str
	syscall
	
	la	$a0,str3
	li	$v0,print_str
	syscall
	addiu	$a0,$t0,last_name
	li	$v0,print_str
	syscall
	
	la	$a0,str4
	li	$v0,print_str
	syscall
	l.s	$f12,grade($t0)
	li	$v0,print_float
	syscall
	
	jr	$ra