# O argumento da função é passado em $a0
# O resultado é devolvido em $v0
# Sub-rotina terminal: não devem ser usados registos $sx
# Mapa de registos
 # s = $t0
 # len = $t1

	.eqv	s,$t0
	.eqv	len,$t1
	
strlen:
	li	len,0		# len = o
while:	lb	s,0($a0)	# 
	