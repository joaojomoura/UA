# Mapa de registos:
# $t0 = value
# $t1 = bit
# $t2 = i
# $t3 = resto

	.data
str1:	.asciiz "Introduza um numero: "
str2:	.asciiz "\nO valor binario e: "
	.eqv	print_string,4
	.eqv	read_int,5
	.eqv	print_char,11
	.text
	.globl main

main:	la	$a0,str1		#
	li	$v0,print_string	#
	syscall				# print_string (str1);
	ori	$v0,$0,read_int		#
	syscall				#
	or	$t0,$v0,$0		# value = read_int($v0);
	la	$a0,str2		#
	li	$v0,print_string	# print_string(str2);
	li	$t2,0			# i = 0;
					#
for:	bge	$t2,32,endfor		# while(i < 32) {
	rem	$t3,$t2,4		#	t3 = i % 4;
	bnez	$t3,endif		#	if (t3 == 0)
					#
if:	ori	$a0,$0,' '		#		print_char (' ');
	ori	$v0,$0,print_char	#	
	syscall				#
	j	endif			#
					#
endif:	andi	$t1,$t0,0x80000000	#	bit = value & 0x80000000; // isola bit 31
	beqz	$t1,else		#	if(bit != 0)
	addi	$a0,$0,'1'		#
	addi	$v0,$0,print_char	#
	syscall				#		print_char('1');
					#
else:	addi	$a0,$0,'0'		#	
	addi	$v0,$0,print_char	#	else
	syscall				#		print_char('0');
	sll	$t0,$t0,1		#	value = value << 1;
	addi	$t2,$t2,1		#	i++;
	j	for			# }
					#
endfor:	jr	$ra			#