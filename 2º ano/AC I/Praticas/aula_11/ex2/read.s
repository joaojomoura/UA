	.data
	.eqv	read_int,5
	.eqv	read_str,8
	.eqv	read_float,6
	.eqv	print_str,4
	.eqv	id_number,0
	.eqv	first_name,4
	.eqv	last_name,22
	.eqv	grade,40
str1:	.asciiz	"N. Mec: "
str2:	.asciiz	"Primeiro Nome: "
str3:	.asciiz	"Ultimo Nome: "
str4:	.asciiz	"Nota: "
	.text
	.globl	read
read:
	li	$t0,0			# i = 0
	move	$t1,$a1			# t1 = ns
	move	$t2,$a0			# t2 = st
for:	
	bge	$t0,$t1,endfor		# while(i < ns){
	la	$a0,str1
	li	$v0,print_str
	syscall				# 	print_str(str1)
	li	$v0,read_int
	syscall				#	read_int()
	mul	$t3,$t0,44
	addu	$t3,$t3,$t2
	sw	$v0,id_number($t3)	#	st[i].id_number = read_int();
	
	la	$a0,str2
	li	$v0,print_str
	syscall				#	print_str(str2)
	addiu	$a0,$t3,first_name	#	$a0 = st[i].first_name;
	li	$a1,18			#	a1 = 18
	li	$v0,read_str
	syscall				#	read_str()
	
	la	$a0,str3
	li	$v0,print_str
	syscall				#	print_str(str3)
	addiu	$a0,$t3,last_name	#	$a0 = st[i].last_name;
	li	$a1,15			#	a1 = 15
	li	$v0,read_str
	syscall				#	read_str()
	
	la	$a0,str4
	li	$v0,print_str
	syscall				#	print_str(str4)
	li	$v0,read_float		
	syscall				#	read_float()
	addiu	$t3,$t3,grade
	s.s	$f0,0($t3)
	
	addi	$t0,$t0,1
	j	for
endfor:
	jr	$ra
	
	
	