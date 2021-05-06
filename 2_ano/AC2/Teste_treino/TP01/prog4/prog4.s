      .equ    ReadInt10, 5
      .equ    PrintStr, 8
      .equ    PrintInt10, 7
      .equ    PrintInt, 6

      .data
str:  .asciiz "\nIntroduza um numero (sinal e modulo): "
str1: .asciiz "\nValor lido, em base 2: "
str2: .asciiz "\nValor lido, em base 16: "
str3: .asciiz "\nValor lido, em base 10 (unsigned): "
str4: .asciiz "\nValor lido, em base 10 (signed): "
      .text
      .globl  main

main:
      la    $a0, str
      li    $v0, PrintStr
      syscall
      
      li    $v0, ReadInt10
      syscall
      move  $t0, $v0

      la    $a0, str1
      li    $v0, PrintStr
      syscall
      move  $a0, $t0
      li    $a1, 2
      li    $v0,PrintInt
      syscall

      la    $a0, str2
      li    $v0, PrintStr
      syscall
      move  $a0, $t0
      li    $a1, 16
      li    $v0,PrintInt
      syscall

      la    $a0, str3
      li    $v0, PrintStr
      syscall
      move  $a0, $t0
      li    $a1, 10
      li    $v0,PrintInt
      syscall

      la    $a0, str4
      li    $v0, PrintStr
      syscall
      move  $a0, $t0
      li    $v0,PrintInt10
      syscall
      
      j     main

      li    $v0, 0
      jr    $ra
