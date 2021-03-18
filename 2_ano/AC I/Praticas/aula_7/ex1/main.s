	.data
str:	.asciiz	"Arquitetura de Computadores I"
	.align 2
	
	.eqv	print_int,1
	.text
	.globl	main
main:	
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	la	$a0,str
	jal	strlen
	move	$a0,$v0
	li	$v0,print_int
	syscall
	li	$v0,0
	lw	$ra,0($sp)
	addiu	$sp,$sp,4
	jr	$ra