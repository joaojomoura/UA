# Mapa de registos 
# num: $t0
#p: $t1
# *p: $t2

	.data
	.eqv	SIZE,20
	.eqv	read_string,8
	.eqv	print_int10,1
	.eqv	num,$t0
	.eqv	p,$t1
	
	
str:	.space	SIZE		# static char str[SIZE];
	.text
	.globl	main
main:
	la	$a0,str		# $a0=&str[0] (endereço da posição
				#   0 do array, i.e., endereço
				#   inicial do array)
	li	$a1,SIZE	# a1 = SIZE
	li	$v0,read_string	
	syscall			# read_string(str,SIZE)
	
	li	num,0		# num = 0
	la	p,str		# Inicializa o ponteiro "p" com o endereço inicial da string (equivalente a fazer p = &(str[0])) p = str
while:				# while(*p != '\0'){
	lb	$t2,0(p)		
	beq	$t2,0,endw	#
if:	
	blt	$t2,'0',endif	#	if(str[i] >= '0' &&
	bgt	$t2,'9',endif	#		str[i] <= '9')
	addi	num,num,1	#		num++
endif:
	addiu	p,p,1		#	p++ 
	j	while		# }
endw:
	move	$a0,num
	li	$v0,print_int10
	syscall
	jr	$ra