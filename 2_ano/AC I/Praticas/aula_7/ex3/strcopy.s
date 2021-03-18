# Mapa de Registos
 # dst = $t0
 # src = $t1
 # i = $t3
 
	.data
	.eqv	dst,$t0
	.eqv	src,$t1
	.eqv	i,$t3
	
	.text
	.globl	strcopy
strcopy:
	li	i,0		# i = 0
	move	dst,$a0
	move	src,$a1
do:				# do{
	addu	$t4,dst,i	#	t4 = dst + i
	addu	$t5,src,i	#	t5 = src + i
	
	lb	$t6,0($t5)	#	t6 = src[i]
	sb	$t6,0($t4)	#	dst[i] = t6
	
	addi	i,i,1		#	i++
	bne	$t6,'\0',do	# } while(src[i++] != '\0');
	
	move	$v0,dst
	jr	$ra