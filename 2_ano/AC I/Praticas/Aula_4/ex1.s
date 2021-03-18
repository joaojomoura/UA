
# Mapa de registos 
# num: $t0
# i: $t1
# str: $t2
# str+i: $t3 
# str[i]: $t4
	
	.data
	.eqv	SIZE,20
	.eqv	read_string,8
	.eqv	print_int10,1
	.eqv	num,$t0
	.eqv	i,$t1
	
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
	li	i,0		# i = 0
while:				# while(str[i] != '\0'){
	la	$t2,str		# 	str = &string[0]
	addu	$t3,$t2,i	#	t3 = str + i ou &str[i]
	lb	$t4,0($t3)	#	t4 = str[i]
	beq	$t4,'\0',endw
if:	
	blt	$t4,'0',endif	#	if(str[i] >= '0' &&
	bgt	$t4,'9',endif	#		str[i] <= '9')
	addi	num,num,1	#		num++
endif:	
	addi	i,i,1		#	i++
	j	while		# }
endw:
	move	$a0,num
	li	$v0,print_int10
	syscall			# print_int(num)
	jr	$ra