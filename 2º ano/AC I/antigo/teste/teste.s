	.data
	.text 
	.globl main
main:	ori	$t0,$0,5	#$t0 = valor inicial
	ori	$t2,$0,8	#$t2 = 8
	add	$t1,$t0,$t0 	#$t1 = $t0 + $t0 = x + x
	add	$t1,$t1,$t2 	#$t1 = $t1 + $t2 
	
	jr	$ra		#fim do programa