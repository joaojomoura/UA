  # Mapa de registos:
     #  $t0 – soma
     #  $t1 – value
     #  $t2 - i
     
	.data
str1:	.asciiz	"Introduza um numero: "
str2:	.asciiz	"Valor ignorado\n"
str3:	.asciiz	"\nA soma dos positivos e': "

	.eqv	read_int,5
	.eqv	print_string,4
	.eqv	print_int10,1
	
	.eqv	soma,$t0
	.eqv	value,$t1
	.eqv	i,$t2
	
	.text
	.globl	main
	
main:
	li	soma,0			# soma = 0
	li	i,0			# i = 0
for:	beq	i,5,endfor		# while(i < 5){
	la	$a0,str1	
	li	$v0,print_string	
	syscall				#	print_string(str1)
	li	$v0,read_int
	syscall				#	read_int()
	move	value,$v0		#	value = read_int()
if:	blez	value,else		#	if(value > 0)
	add	soma,soma,value		#		soma = soma + value
	j	endif			
else:	la	$a0,str2		#	else
	li	$v0,print_string
	syscall				#		print_string(str2)
endif:	addi	i,i,1			#	i++
	j	for
endfor:					# }
	la	$a0,str3
	li	$v0,print_string
	syscall				# print_string(str3)
	move	$a0,soma
	li	$v0,print_int10
	syscall
	jr	$ra