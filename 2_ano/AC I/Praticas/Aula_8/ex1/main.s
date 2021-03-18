	.data
str:	.asciiz	"2016 e 2020 sao anos bissextos\n"
	.align	2
	.text
	.globl	main
main:
	addiu	$sp,$sp,-4
	sw	$ra,0($sp)
	la	$a0,str
	li	$v0,4
	syscall
	jal	atoi
	move	$a0,$v0
	li	$v0,1
	syscall
	li	$v0,0
	lw	$ra,0($sp)
	jr	$ra
	