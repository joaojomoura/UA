# Mapa de registos
 # i = $t0
 # argc = $t1
 # argv = $t2
 
	.data
str1:	.asciiz	"Nr. de parametros: "
str2:	.asciiz	"\nP"
str3:	.asciiz	": "
	.align	2

	.eqv	print_int,1
	.eqv	print_str,4
	.eqv	i,$t0
	.eqv	argc,$t1
	.eqv	argv,$t2
	
	.text
	.globl	main
main:
	li	i,0		# i = 0
	move	argc,$a0	
	move	argv,$a1
	la	$a0,str1
	li	$v0,print_str
	syscall			# print_str(str1)
	move	$a0,argc
	li	$v0,print_int
	syscall			# print_int(argc)
for:
	bge	i,argc,endf	# while(i < argc){
	la	$a0,str2
	li	$v0,print_str
	syscall			#	print_str(str2)
	move	$a0,i
	li	$v0,print_int
	syscall			#	print_int(i)
	la	$a0,str3
	li	$v0,print_str
	syscall			#	print_str(str3)
	
	sll	$t3,i,2		#	t3 = i*4
	addu	$t4,argv,$t3	#	t4 = &(argv[i*4])= ao endereco i do array
	lw	$t4,0($t4)	#	t4 = argv[i] = guarda em t4 o conteudo do endereco i do array
	
	move	$a0,$t4
	li	$v0,print_str
	syscall			#	print_str(argv[i])
	
	addi	i,i,1		#	i++
	j	for		# }
endf:
	li	$v0,0
	jr	$ra