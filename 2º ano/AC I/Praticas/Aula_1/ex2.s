	.data
	
	.text
	.globl main
	
main:	ori	$v0,$0,5	#
	syscall			# chamada ao syscall "read_int()" 
	or 	$t0,$0,$v0 	# $t0 = x (dado por user)
 				# 
 	ori 	$t2,$0,-8 	# $t2 = 8
 	add 	$t1,$t0,$t0 	# $t1 = $t0 + $t0 = x + x = 2 * x
 	add 	$t1,$t1,$t2 	# $t1 = $t1 + $t2 = y = 2 * x + 8
 	
 	or	$a0,$0,$t1	# $a0 = $t1
 	ori	$v0,$0,1	# print int(10)
 	
 	jr 	$ra 		# fim do programa 