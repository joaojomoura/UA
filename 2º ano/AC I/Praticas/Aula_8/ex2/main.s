# Mapa de registos
# str: $s0
# val: $s1
# O main é, neste caso, uma sub-rotina intermédia

	.data

string:	.space	33
line:	.asciiz	"\n"
	.eqv	STR_MAX_SIZE,33
	.eqv	read_int,5
	.eqv	print_string,4
	.eqv	str,$s0
	.eqv	val,$s1
	.text
	.globl	main
main:
	addiu	$sp,$sp,-12
	sw	$ra,0($sp)
	sw	str,4($sp)
	sw	val,8($sp)
do:				# do{
	li	$v0,read_int
	syscall			#	read_int()
	move	val,$v0		#	val = read_int()
	
	
	move	$a0,val
	li	$a1,2
	la	$a2,string
	jal	itoa
	move	$a0,$v0
	li	$v0,print_string
	syscall
	la	$a0,line
	syscall
	
	move	$a0,val
	li	$a1,8
	la	$a2,string
	jal	itoa
	move	$a0,$v0
	li	$v0,print_string
	syscall
	la	$a0,line
	syscall
	
	move	$a0,val
	li	$a1,16
	la	$a2,string
	jal	itoa
	move	$a0,$v0
	li	$v0,print_string
	syscall
	la	$a0,line
	syscall
while:
	bne	val,0,do
	
	li	$v0,0
	
	lw $ra, 0($sp)			# repõe registo $ra
	lw $s0, 4($sp)			# repoe registos $sx
	lw $s1, 8($sp)
	addiu $sp, $sp, 12		# liberta espaço na stack
	
	li $v0, 0			# return 0;
	
	jr $ra				# termina programa
	