
# Mapa de registos 
# p: $t0 
# *p: $t1 
# lista+Size: $t2

	.data
str1:	.asciiz	"; "
str2:	.asciiz	"\nConteudo do array:\n"
lista:	.word	8, -4, 3, 5, 124, -15, 87, 9, 27, 15	# static int lista[]={8, -4, 3, 5, 124, -15, 87, 9, 27, 15};

	.eqv	print_int10,1
	.eqv	print_string,4
	.eqv	SIZE,10					# define SIZE 10
	.eqv	p,$t0
	.eqv	pp,$t1
	.eqv	listaS,$t2
	
	.text
	.globl	main
	
main:
	la	$a0,str2
	li	$v0,print_string
	syscall				# print_string(str2)
	la	p,lista			# p = lista
	li	listaS,SIZE		#
	sll	listaS,listaS,2		#
	addu	listaS,p,listaS		# listaS = lista + Size
while:
	bgtu	p,listaS,endw		# while(p < lista+SIZE) {
	lw	pp,0(p)			# 	conteudo da posicao do array
	move	$a0,pp
	li	$v0,print_int10
	syscall				#	print_int10(*p)
	la	$a0,str1
	li	$v0,print_string
	syscall
	addiu	p,p,4			#	p++
	j	while
endw:	jr	$ra