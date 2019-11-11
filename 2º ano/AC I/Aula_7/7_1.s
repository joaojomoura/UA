# Mapa de registos
# res: $v0
# s: $a0
# *s: $t0
# digit: $t1
# Sub-rotina terminal: não devem ser usados registos $sx 

		.data
		.eqv	print_int10,1
str:		.asciiz	"101101"
		.text
		.globl	main
		
main:		la	$a0,str			# $a0 = str;
		sw	$ra,0($sp)		#
		jal	atoi			#
		lw	$ra,0($sp)		#
		move	$a0,$v0
		li	$v0,print_int10		#
		syscall
		jr	$ra


############ unsigned int atoi(char *s) ############
atoi:		li	$v0,0			# res = 0;
while:		lb	$t0,0($a0)		# $t0 = *s;
		blt	$t0,'0',endw		# while(*s >= '0' &&
		bgt	$t0,'1',endw		# *s <= '9') {
		sub	$t1,$t0,'0'		# 	digit = *s - '0';
		addiu	$a0,$a0,1		#	s++;
		mul	$v0,$v0,2		#	res = 10 * res;
		add	$v0,$v0,$t1		#	res = res + digit;
		j	while			# }
endw:		jr	$ra			#