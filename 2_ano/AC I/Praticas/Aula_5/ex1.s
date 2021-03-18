
# i: $t0 
# lista: $t1 
# lista + i: $t2

	.data
	.eqv	SIZE,5
	.eqv	read_int,5
	.eqv	print_string,4
	.eqv	i,$t0
	.eqv	lista,$t1
	.eqv	listai,$t2
	
str:	.asciiz	"\nIntroduza um numero: "
	.align	2
lista1:	.space	20	# SIZE * 4
	.text
	.globl	main
	
main:
	li	i,0			# i= 0
while:
	bge	i,SIZE,endw		# while (i < SIZE){
	la	$a0,str
	li	$v0,print_string
	syscall				#	print_string(str)
	li	$v0,read_int
	syscall				# 	v0 = read_int
	la	lista,lista1		#	$t1 = lista (ou &lista[0])
	sll	listai,i,2		# 	listai = i * 4
	addu	listai,listai,lista	#	listai = lista + i
	sw	$v0,0(listai)		#	lista[i] = read_int();
	addi	i,i,1			#	i++
	j	while			# }
endw:
	jr	$ra