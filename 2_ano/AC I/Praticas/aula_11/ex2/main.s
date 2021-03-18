	.data
	
	.eqv	id_number,0
	.eqv	first_name,4
	.eqv	last_name,22
	.eqv	grade,40
	.eqv	MAX,4
	.eqv	print_str,4
	.eqv	print_float,2
	.align	2
st:	.space	176
str:	.asciiz	"\nMedia: "
str2:	.asciiz	"\n"
media:	.space	4
	.text
	.globl 	main
main:
	addiu	$sp,$sp,-8
	sw	$ra,0($sp)
	sw	$s0,4($sp)

	la	$a0,st
	li	$a1,MAX
	jal	read		# read_data(st,MAX)
	
	la	$a0,st
	li	$a1,MAX
	la	$a2,media
	jal	max		# max(st,MAX,&media)
	move	$s0,$v0		# pmax = max()
	
	la	$a0,str
	li	$v0,print_str
	syscall			# print_str(str)
	la	$t0,media
	l.s	$f12,0($t0)	# f12 = media
	li	$v0,print_float
	syscall			# print_float(f12=media)
	la	$a0, str2		#	$a0 = "\n"
	li	$v0, print_str		#
	syscall				#	print_str("\n");
	
	
	move	$a0,$s0
	jal	print		# print_student( pmax );
	li	$v0,0
	
	lw	$ra,0($sp)
	lw	$s0,4($sp)
	addiu	$sp,$sp,8
	
	jr	$ra