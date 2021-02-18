	.data
str:	.asciiz	"ITED - orievA ed edadisrevinU\n"
	.eqv	print_string,4
	.text
	.globl	main
main:	
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	la	$a0,str
	li	$v0,print_string
	syscall
	jal	strrev
	move	$a0,$v0
	li	$v0,print_string
	syscall
	li	$v0,0
	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	jr	$ra
	