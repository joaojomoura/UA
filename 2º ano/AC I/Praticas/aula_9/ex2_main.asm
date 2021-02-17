	#double f2c(double ft);
#
#int main(void) {
#    	double f, c;
#
#    	print_string("Indicar temperatura em Fahrenheit: ");
#    	f = read_double();
#    	c = f2c(f);
#    	print_string("\nTemperatura em Celsius: ");
#	print_double(c);
#    	return 0;
#}

	.data
	.eqv print_string, 4
	.eqv read_double, 7
	.eqv print_double, 3
	
str1:	.asciiz "Indicar temperatura em Fahrenheit: "
str2:	.asciiz "Temperatura em Celcius: "

	.text
	.globl main
	
main:
	sw	$ra,0($sp)		# guarda o valor de ra
	
	la	$a0, str1
	li	$v0,print_string	
	syscall				# print_string(str1)
	
	li	$v0,read_double		
	syscall				# v0 = read_double
	
	mov.d	$f12,$f0		# f12 = f0(read_double)
	jal	f2c			# chamada a funcao f2c, retorna valor em f0
	
	
	la	$a0,str2
	li	$v0,print_string
	syscall				# print_string(str2)
	
	mov.d	$f12,$f0		# f12 = f0 = f2c(f12)
	li	$v0,print_double	
	syscall				# print_double(f12)
	li $v0, 0			# return 0;
	lw	$ra,0($sp)
	jr	$ra
	