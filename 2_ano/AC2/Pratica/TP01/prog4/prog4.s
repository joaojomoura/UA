    .equ    printInt,6
    .equ    printStr,8
    .equ    printInt10,7
    .equ    readInt10,5

    .data

str0:   .asciiz "\nIntroduza um numero (sinal e módulo):"
str1:   .asciiz "\nValor lido, em base 2: "
str2:   .asciiz "\nValor lido, em base 16: "
str3:   .asciiz "\nValor lido, em base 10 (unsigned):"
str4:   .asciiz "\nValor lido, em base 10 (signed):"

    .text
    .globl  main
main:
    la			$a0, str0			# a0 = str0
    li          $v0, printStr
    syscall                         # printStr(str0)

    li			$v0, readInt10		# readInt10()
    syscall
    move        $t0,$v0             # t0 = readInt10()

    la			$a0, str1			# a0 = str1
    li          $v0, printStr
    syscall 
    move        $a0,$t0
    li          $a1,2
    li          $v0,printInt
    syscall


    la			$a0, str2			# a0 = str1
    li          $v0, printStr
    syscall
    move        $a0,$t0
    li          $a1,16
    li          $v0,printInt
    syscall 



    la			$a0, str3			# a0 = str1
    li          $v0, printStr
    syscall
    move        $a0,$t0
    li          $a1,10
    li          $v0,printInt
    syscall 


    la			$a0, str4			# a0 = str1
    li          $v0, printStr
    syscall
    move        $a0,$t0
    li          $v0,printInt10
    syscall

    j			main

    li          $v0,0
    jr          $ra 

    
    
    