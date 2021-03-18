	.data
	.text
	.globl	abso
abso:
	move	$v0,$a0
	bgez	$v0,endif	# if(val < 0)
	mul	$v0,$v0,-1	# 	val = -val
endif:
	jr	$ra		# return val