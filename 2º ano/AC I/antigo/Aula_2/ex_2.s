	.data
 	.text
 	.globl main
main: 	li $t0,0x862a5c1b 	# instrução virtual (decomposta
 				# em duas instruções nativas)
 	sll $t2,$t0,4		#
 	srl $t3,$t0,4 		#
 	sra $t4,$t0,4 		#
 	jr $ra 			# fim do programa