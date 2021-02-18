# Mapa de registos
 # p = $t0
 # pultimo = $t1
 
 	.data
str1:	.asciiz	"Array"
str2:	.asciiz	"de"
str3:	.asciiz	"ponteiros"
array:	.word	str1,str2,str3
	
	.eqv	SIZE,3
	.eqv	print_str,4
	.eqv	print_char,11
	.eqv	p,$t0
	.eqv	pultimo,$t1
	
	.text
	.globl	main
main:
	la	p,array		# p = array
	addiu	pultimo,p,12	# pultimo = array + SIZE
for:
	bgeu	p,pultimo,endf	# while(p < pultimo) {
	lw	$a0,0(p)	# a0 = *p
	li	$v0,print_str
	syscall
	li	$a0,'\n'
	li	$v0,print_char
	syscall
	addiu	p,p,4
	j	for
endf:	jr	$ra