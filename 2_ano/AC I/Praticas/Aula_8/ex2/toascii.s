	.data
	.text
	.globl	toascii
toascii:
	addi	$a0,$a0,'0'		# v += '0';
if:	
	ble	$a0,'9',endif		# if( v > '9' )
	addi	$a0,$a0,'7'		#	v+=7; //'A'-'9'-1
endif:
	move	$v0,$a0			# return v;
	jr	$ra			