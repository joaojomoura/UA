 # Mapa de registos:
     #  $t0 – value
     #  $t1 – bit
     #  $t2 - i
     
	.data
str1:	.asciiz	"Introduza um numero: "
str2:	.asciiz	"\nO valor em binário e': "
	.eqv	print_string,4
	.eqv	read_int,5
	.eqv	print_char,11
	
	.eqv	value,$t0
	.eqv	bit,$t1
	.eqv	i,$t2
	
	.text
	.globl	main
main:
	la	$a0,str1
	li	$v0,print_string
	syscall				# print_string(str1)
	li	$v0,read_int
	syscall				# read_int()
	move	value,$v0		# value = read_int()
	la	$a0,str2
	li	$v0,print_string
	syscall				# print_string(str2)
	
	li	i,0			# i = 0
for:
	bge	i,32,endfor		# while(i < 32) {
	
	rem	$t3,i,4			#	t3 = i % 4
	bnez	$t3,after		#	if(t3 == 0)
	li	$a0,' '
	li	$v0,print_char
	syscall
			
after:	andi	bit,value,0x80000000	# 	bit = value & 0x80000000; // isola bit 31
if:
	beqz	bit,else		#	if(bit != 0)
	ori	$a0,$0,'1'
	li	$v0,print_char
	syscall				#		print_char('1')
	j	endif
else:					#	else
	ori	$a0,$0,'0'
	li	$v0,print_char
	syscall				#		print_char('0')	
endif:
	sll	value,value,1		#	value = value << 1; // shift left de 1 bit
	addi	i,i,1			#	i++
	j	for
endfor:					# }
	jr	$ra