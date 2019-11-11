# Mapa de registos
# n: $a0 -> $s0
# b: $a1 -> $s1
# s: $a2 -> $s2
# p: $s3
# digit: $t0
# Sub-rotina intermédia

# str: $s0
# val: $s1
# O main é, neste caso, uma sub-rotina intermédia 
		.data
 		.eqv STR_MAX_SIZE,33
 		.eqv read_int,5
 		.eqv print_string,4
 str: 		.space STR_MAX_SIZE
 newl:		.asciiz	"\n"
 		.text
 		.globl main

main:		addiu	$sp,$sp,-8	# reserva espaço na stack
		sw	$ra,0($sp)	#
		sw	$s0,4($sp)	#
		sw	$s1,8($sp)	#
		la	$s0,str		# $s1 = str;
do1:					# do {
		li	$v0,read_int	#
		syscall			#
		move	$s1,$v0		# 	val = read_int();
		la	$a0,newl		#
		li	$v0,print_string	#
		syscall				#	print_string(newl);
		move	$a0,$s1
		li	$a1,2
		move	$a2,$s0
		jal	itoa
		move	$a0,$v0
		li	$v0,print_string
		syscall
		la	$a0,newl		#
		li	$v0,print_string	#
		syscall				#	print_string(newl);
		move	$a0,$s1
		li	$a1,8
		move	$a2,$s0
		jal	itoa
		li	$v0,print_string
		syscall
		la	$a0,newl		#
		li	$v0,print_string	#
		syscall				#	print_string(newl);
		move	$a0,$s1
		li	$a1,16
		move	$a2,$s0
		jal	itoa
		li	$v0,print_string
		syscall
		la	$a0,newl		#
		li	$v0,print_string	#
		syscall				#	print_string(newl);
		bne	$s1,0,do
		li	$v0,0
		lw	$ra,0($sp)		# repoe endereço de retorno
		lw	$s0,4($sp)		# repoe o valor dos registos
		lw	$s1,8($sp)		# $s0,$s1, $s2		#
		addiu	$sp,$sp,8		# liberta espaço da stack
		jr	$ra			# termina funçao




############## char *itoa(unsigned int n, unsigned int b, char *s) ##############
itoa:		addiu	$sp,$sp,-16		# reserva espaço na stack
		sw	$ra,0($sp) 		#
		sw	$s0,4($sp)		#
		sw	$s1,8($sp)		#
		sw	$s2,16($sp)		# guarda registos s0,s1,s2 e ra
		move	$s0,$a0			# n = $s0;
		move	$s1,$a1			# b = $s1;
		move	$s2,$a2			# s = $s2;
		move	$s3,$a2			# p = s;
do:						# do {
		rem	$t0,$s0,$s1		#	digit = n % b;
		div	$s0,$s0,$s2		#	n = n / b;
		move	$a0,$t0			# 	$a0 = digit;
		jal	toascii			#	toascii(digit);
		sw	$v0,0($s3)		#	*p = toascii(digit);
		addi	$s3,$s3,1		#	*p++;
		bgt	$s0,0,do		# }while(n > 0);
						#
		sb	$0,0($s3)		# *p = 0;
		move	$a0,$s2			# $a0 = s;
		jal	strrev			# strrev(s);
		lw	$ra,0($sp)		# repoe endereço de retorno
		lw	$s0,4($sp)		# repoe o valor dos registos
		lw	$s1,8($sp)		# $s0,$s1, $s2
		lw	$s2,12($sp)		#
		addiu	$sp,$sp,16		# liberta espaço da stack
		jr	$ra			# termina funçao
		
		
############### char toascii(char v) ############
toascii:	addi	$a0,$a0,0		# v = v + '0';
if:		ble	$a0,'9',endif		# if (v > '9')
		addi	$a0,$a0,7		# 	v = v + 7;
endif:		move	$v0,$a0			# return v;
		jr	$ra			#
		
########### char *strrev(char *str)  {###########
strrev:		addiu	$sp,$sp,-16		# reserva espaço na stack
		sw	$ra,0($sp)		# guarda endereço de retorno
		sw	$s0,4($sp)		# guarda valor dos registos
		sw	$s1,8($sp)		# $s0,$s1,$s2
		sw	$s2,12($sp)		#
		move	$s0,$a0			# registo callee-saved
		move	$s1,$a0			# p1 = str
		move	$s2,$a0			# p2 = str
		
while1:		lb	$s3,0($s2)		# s3 = *p2
		beq	$s3,'\0',endw		# while(*p != '\0') {
		addi	$s2,$s2,1		#	p2++;
		j	while1			# }
endw:		sub	$s2,$s2,1		# p--;
						#
while2:		bge	$s1,$s2,endw2		# while (p1 < p2) {
		move	$a0,$s1			#	$a0 = p1;
		move	$a1,$s2			#	$a1 = p2;
		jal	exchan			#	exchange(p1,p2);
		addi	$s1,$s1,1		#	p1++;
		sub	$s2,$s2,1		#	p2--;
		j	while2			# }
endw2:		move	$v0,$s0			# return str;
		lw	$ra,0($sp)		# repoe endereço de retorno
		lw	$s0,4($sp)		# repoe o valor dos registos
		lw	$s1,8($sp)		# $s0,$s1, $s2
		lw	$s2,12($sp)		#
		addiu	$sp,$sp,16		# liberta espaço da stack
		jr	$ra			# termina funçao
		
########### void exchange(char *c1, char *c2)  {###########		
exchan:		lb	$t0,0($a0)		# t0 = *p1;
		lb	$t1,0($a1)		# t1 = *p2;
		sb	$t0,0($a1)		# *p1 = *p2;
		sb	$t1,0($a0)		# *p2 = *p1;
		jr	$ra			# termina funçao