# Mapa de registos
# 


		.data
		.eqv	print_string,4
		.eqv	print_int10,1
		.eqv	SIZE,30
		.eqv	SIZE_1,31
str:		.asciiz	"ITED - orievA ed edadisrevinU"
newl:		.asciiz	"\n"
str2:		.asciiz	"String too long: "
str3:		.asciiz	"2MASTER"
		.align 	2
toCopy:		.space	SIZE_1
		.text
		.globl main
		
########### int main(void) {###########

main:		sw	$ra,0($sp)
		la	$a0,str			# $a0 = str;
		jal	strlen			# strlen ($a0);
		move	$t5,$v0			# t5 = strlen($a0);
		bgt	$t5,SIZE,else		# if(strlen($a0) <= SIZE) {
		la	$a1,str			#	$a1 = str;
		la	$a0,toCopy		#	$a0 = toCopy;
		jal	strcpy			#	strcpy($a0,$a1);
		la	$a0,toCopy		#
		li	$v0,print_string	#	print_String(toCopy);
		syscall				#
		la	$a0,newl		#
		li	$v0,print_string	#
		syscall				#	print_string(newl);
		la	$a0,toCopy		#	$a0 = ToCopy
		jal	strrev			#	strrev(toCopy);
		move	$a0,$v0			#	$a0 = strrev(ToCopy);
		li	$v0,print_string	#
		syscall				#	print_String($a0);
		li	$t4,0			#
		j	end			# }
		
else:		la	$a0,str2		# else {
		li	$v0,print_string	#
		syscall				#	print_string(str2);
		jal	strlen			#
		move	$a0,$v0
		li	$v0,print_string
		syscall
		li	$t4,-1
end:		
		lw	$ra,0($sp)
		jr	$ra
		
		
		
	
########### char *strcpy( char *dst, char *src) {###########
strcpy:		li	$s4,0			# i = 0;
		move	$s1,$a0			# p1 = dst;
		move	$s2,$a1			# p2 = src;
do:						# do {	
		addu	$s6,$s1,$s4		# 	s6 = p1 + i;
		addu	$s7,$s2,$s4		# 	s7 = p2 + i;
		lb	$s3,0($s7)		# 	s3 = src[i];
		sb	$s3,0($s6)		# 	dst[i] = s3;
		addi	$s4,$s4,1		# 	i++;
		bne	$s3,'\0',do		# }while(src[i] != '\0');
		move	$v0,$s1			# return p1( = dst);
		jr	$ra			# }
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
########### int strlen(char *s)  {###########		
strlen:		li	$t0,0			# len = 0;
while3:		lb	$s3,0($a0)		# while(s++ != '\0')
		addiu	$a0,$a0,1		#
		beq	$s3,'\0',endw3		# {
		addi	$t0,$t0,1		# 	len++;
		j	while3			# }
endw3:		move	$v0,$t0			# return len;
		jr	$ra			#