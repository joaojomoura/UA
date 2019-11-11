	.data
	
	.text
	.globl	main

main:	ori	$v0,$0,5	#
	syscall			# chamada ao syscall "read_int()"
	or	$t0,$0,$v0	# valor lido do teclado
				#
	ori	$t2,$0,8	# $t2 = 8
	add	$t1,$t0,$t0	# $t1 = $t0 + $t0 = 3 + 3 = 6 (x + x = 2 * x)
	sub	$t1,$t1,$t2	# $t1 = $t1 + $t2 = 6 - 8 = -2 (2 * x - 8)
				#
	or	$a0,$0,$t1	# $a0 = $t1
	ori	$v0,$0,1	#
	syscall			# chamada ao syscall "print_int10()"
				#
	or	$a0,$0,$t1	# $a0 = $t1
	ori	$v0,$0,34	#
	syscall			# chamada ao syscall "print_int16()"
				#
	or	$a0,$0,$t1	# $a0 = $t1
	ori	$v0,$0,36	#
	syscall			# chamada ao syscall "print_intu10()"
				#
	jr	$ra		# fim do programa