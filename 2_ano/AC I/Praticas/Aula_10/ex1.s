	# le do utilizador um valor float x e um inteiro y e faz x^y
	.data
result:	.float	1.0
str1:	.asciiz	"Introduza um valor real: "
str2:	.asciiz	"Introduza um valor inteiro: "
str3:	.asciiz "Resultado: "
	.eqv	print_string,4
	.eqv	read_int,5
	.eqv	read_float,6
	.eqv	print_float,2
	.text
	.globl	main
main:	
	sw	$ra,0($sp)		#guarda ra
	
	la	$a0,str1
	li	$v0,print_string
	syscall				# print_string(str1)
	li	$v0,read_float		
	syscall				# read_float()
	mov.s	$f12,$f0		# f12 = read_float()
	
	la	$a0,str2
	li	$v0,print_string
	syscall				# print_string(str2)
	li	$v0,read_int		# read_int()
	syscall
	move	$a0,$v0			# a0 = read_int()
	jal	xtoy			# xtoy(f12,a0) = xtoy(x,y)
	mov.s	$f12,$f0
	
	
	la	$a0,str3
	li	$v0,print_string
	syscall
	li	$v0,print_float
	syscall
	lw	$ra,0($sp)
	jr	$ra

# Mapa de Registos
# s0 - i
# s1 - y
# f20 - x
# f22 - result

xtoy:
	addiu	$sp,$sp,-28		# reserva espaco na stack
	sw	$ra,0($sp)		# guarda o valor de ra
	sw	$s0,4($sp)		# guarda o valor de s0
	sw	$s1,8($sp)		# guarda o valor de s1
	s.s	$f20,12($sp)		# guarda o valor de f20
	s.s	$f22,20($sp)		# guarda o valor de f22
	
	li	$s0,0			# s0 = 0, i = 0
	la	$t0,result		# t0 = result
	l.s	$f22,0($t0)		# f22 = x = float(t0)
	move	$s1,$a0			# s1 = a0, y = a0
	mov.s 	$f20,$f12		# f20 = f12, x = f12
	
	jal	abs			# abs(int val)
	move	$t1,$v0			# t1 = abs(int val)
	
for:	bge	$s0,$t1,endfor		# while(i < abs(y))
if:	blez	$s1,else		# 	if(y>0)
	mul.s 	$f22,$f22,$f20		#		result = result * x
	j	endif
else:	div.s	$f22,$f22,$f20		#	else result = result / x
endif:	addi	$s0,$s0,1		#	i++
	j	for

endfor:	mov.s 	$f0,$f22		# return result
	
	
	lw $ra, 0($sp)			# repõe o valor de $ra
	lw $s0, 4($sp)			# repõe o valor de $s0
	lw $s1, 8($sp)			# repõe o valor de $s1
	l.s $f20, 12($sp)		# repõe o valor de $f20
	l.s $f22, 20($sp)		# repõe o valor de $f22
	addiu $sp, $sp, 28		# liberta o espaço na stack
	
	jr 	$ra				# termina a sub-rotina
	
abs:
	
	move	$v0,$a0
	bgez	$v0,endifs		# if(val < 0)
	mul	$v0,$v0,-1		# 	val = val * -1
endifs:	
	jr	$ra			# return val