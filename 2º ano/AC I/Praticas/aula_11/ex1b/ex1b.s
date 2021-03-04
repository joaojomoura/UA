	.data
	
	.eqv	id_number,0
	.eqv	first_name,4
	.eqv	last_name,22
	.eqv	grade,40
	.eqv	print_str,4
	.eqv	print_char,11
	.eqv	print_intu10,36
	.eqv	print_float,2
	.eqv	read_int,5
	.eqv	read_str,8

stg:
	.space	22
	.asciiz	"Bonaparte"
	.space	6
	.float	5.1
	
str:	.asciiz	"\nN. Mec: "
str1:	.asciiz	"\nNome: "
str2:	.asciiz	"\nNota: "
str3:	.asciiz	"\nPrimeiro Nome: "
	
	.text
	.globl	main
main:
	la	$t0,stg			# t0 = stg
	
	la	$a0,str
	li	$v0,print_str
	syscall
	li	$v0,read_int
	syscall
	sw	$v0,id_number($t0)
	
	la	$a0,str3
	li	$v0,print_str
	syscall
	addiu	$t1,$t0,first_name
	move	$a0,$t1
	li	$a1,18
	li	$v0,read_str
	syscall
	
	
	
	la	$a0,str
	li	$v0,print_str
	syscall				# print_string(str)
	lw	$a0,id_number($t0)	# a0 = ao endereco da estrutura de dados onde se encontra idnumber
	li	$v0,print_intu10
	syscall
	
	la	$a0,str1
	li	$v0,print_str
	syscall				# print_string(str1)
	addiu	$a0,$t0,first_name	# a0 = stg.firstname
	li	$v0,print_str
	syscall				# print_str(firstname)
	li	$a0,','
	li	$v0,print_char
	syscall				# print_char(',')
	addiu	$a0,$t0,last_name	# a0 = stg.lastname
	li	$v0,print_str
	syscall				# print_str(lastname)
	
	la	$a0,str2
	li	$v0,print_str
	syscall				# print_str(str2)
	l.s	$f12,grade($t0)		# a0 = stg.grade
	li	$v0,print_float
	syscall
	
	li	$v0,0
	jr	$ra