	.data
	.text
	.globl	main
	
main:	ori	$v0,$0,5	#
	syscall 		# chamar a funçao read_int
	or	$t0,$0,$v0	# valor lido do teclado
				#
	or	$t0,$0,$v0	# t0 (gray number)
	or	$t1,$0,$t0	# t1 = t0 num = gray
	srl	$t3,$t1,4	# num >> 4
	xor	$t1,$t1,$t3	# num = num xor (num >> 4)
	srl	$t3,$t1,2	# num >> 2
	xor	$t1,$t1,$t3	# num = num xor (num >> 2)
	srl	$t3,$t1,1	# num >> 1
	xor	$t1,$t1,$t3	# num = num xor (num >> 1)
	or	$t2,$0,$t1	# bin(t2) = num
				#
				#impressao
	or	$a0,$0,$t0	# $a0 = $t0 (imprime o gray)
	ori	$v0,$0,35	#
	syscall			# chamada ao syscall "print_int2()"			
	addi 	$a0, $0, 0xA 	# ascii code for LF, if you have any trouble try 0xD for CR.
        addi 	$v0, $0, 11 	# syscall 11 prints the lower 8 bits of $a0 as an ascii character.
        syscall 		# 
        or	$a0,$0,$t2	# $a0 = $t2 (imprime o binario)
	ori	$v0,$0,35	#
	syscall			# chamada ao syscall "print_int2()" 
				#
	jr	$ra		#
	