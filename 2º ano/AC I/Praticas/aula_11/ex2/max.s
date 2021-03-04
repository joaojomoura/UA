	.data
	.eqv	max_grade,$f4
	.eqv	sum,$f6
	.eqv	p,$t0
	.eqv	pmax,$t1
	.eqv	media,$f10
	.eqv	id_number,0
	.eqv	first_name,4
	.eqv	last_name,22
	.eqv	grade,40
f:	.float	-20.0
f1:	.float	0.0
	.text
	.globl	max
max:
	la	$t0,f
	l.s	max_grade,0($t0)		# float max_grade = -20.0;
	la	$t0,f1
	l.s	sum,0($t0)			#  float sum = 0.0;
	
	move	$t2,$a2
	move	p,$a0
	move	$t3,$a1				# t3 = ns
	mul	$a1,$a1,44			# ns = ns * 44
	addu	$t4,p,$a1			# t4 = st + ns
	
for:
	bge	p,$t4,endfor			# for(p = st; p < (st + ns); p++){
	l.s	$f6,grade(p)			#	f6 = p->grade
	add.s	sum,sum,$f6			#	sum += p->grade;
if:	c.le.s	$f6,max_grade			#
	bc1t	endif				#	if(p->grade > max_grade)
	mov.s	max_grade,$f6			#		max_grade = p->grade;
	move	pmax,p				#		pmax = p
endif:
	addi	p,p,44				#	p++
	j	for				# }
endfor:
	mtc1	$t3,$f8
	cvt.s.w	$f8,$f8
	div.s	media,sum,$f8
	s.s	media,0($t2)
	move	$v0,pmax
	jr	$ra