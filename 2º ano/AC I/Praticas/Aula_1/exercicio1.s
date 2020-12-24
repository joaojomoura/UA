	.data
				#nada a colocar aqui, de momento
	.text
	.globl 	main
	
main:	
	ori	$v0,$0,5	#
	syscall			# chamada ao syscall de 'read_int()'
	or	$t0,$0,$v0	# $t0 = readInt();
				# 
	ori 	$t2,$0,8 	# $t2 = 8
	add 	$t1,$t0,$t0 	# $t1 = $t0 + $t0 = x + x = 2 * x
	add 	$t1,$t1,$t2 	# $t1 = $t1 + $t2 = y = 2 * x + 8
	add	$t0,$t0,$t0	# $t0 = $t0 + $t0
	sub	$t3,$t0,$t2	# $t3 = $t0 - $t2
	or	$a0,$0,$t3	# $a0 = $t3 = y
	ori	$v0,$0,1	#
	syscall			# print_int(y);
	jr 	$ra		# fim o programa
