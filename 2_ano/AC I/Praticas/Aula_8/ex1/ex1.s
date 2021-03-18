# Mapa de registos 
# res: $v0
# s: $a0
# *s: $t0
# digit: $t1
# Sub-rotina terminal: não devem ser usados registos $sx

	.data 
	.eqv	res,$v0
	.eqv	s,$a0
	.eqv	ss,$t0
	.eqv	digit,$t1
	.text
	.globl	atoi
atoi:
	li	res,0		# res = 0
while:
	lb	ss,0(s)		# *s
	blt	ss,'0',endw
	bgt	ss,'9',endw	# while( (*s >= '0') && (*s <= '9') ){
	sub	digit,ss,'0'	#	digit = *s - '0'
	addiu	s,s,1		#	s++
	mul	res,res,10	#	res=10*res;
	add	res,res,digit	#	res=10*res+digit;
	j	while		# }
endw:
	jr	$ra		# termina sub-rotina