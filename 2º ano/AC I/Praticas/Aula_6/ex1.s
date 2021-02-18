# Mapa de registos
 # i = $t0
 # *array = $t1
 # temp = $t2
 
 	.data
str1:	.asciiz	"Array"
str2:	.asciiz	"de"
str3:	.asciiz	"ponteiros"
array:	.word	str1,str2,str3
	
	.eqv	SIZE,3
	.eqv	print_str,4
	.eqv	print_char,11
	.eqv	i,$t0
	.eqv	parray,$t1
	
	.text
	.globl	main
main:	
	li	i,0		# i = 0
	la	parray,array	# *array = array
for:
	bge	i,SIZE,endf	# while(i < SIZE) {
	sll	$t2,i,2		# 	temp = i * 4
	addu	$t2,$t2,parray	# 	temp = &array[i]
	lw	$a0,0($t2)	
	li	$v0,print_str
	syscall
	li	$a0,'\n'
	li	$v0,print_char
	syscall
	addi	i,i,1
	j	for
endf:	jr	$ra