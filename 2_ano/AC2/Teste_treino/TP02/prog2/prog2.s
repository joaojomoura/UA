      .equ    readCoreTimer,11
      .equ    resetCoreTimer, 12
      .equ    printInt, 6
      .equ    putChar, 3

      .data
      .text
      .globl  main

main:
      addiu $sp, $sp, -8
      sw    $ra, 0($sp)
      sw    $s0, 4($sp)
      li    $s0, 0    # counter = 0
      while:
          li    $a0,10000
          jal   delay
          addi  $s0, $s0, 1
          move  $a0, $s0
          li    $a1, 0x0004000A
          li    $v0,printInt
          syscall
          li    $a0,'\r'
          li    $v0,putChar
          syscall
          j     while
    li    $v0,0
    lw    $ra, 0($sp)
    lw    $s0, 4($sp)
    addiu $sp, $sp, 8
    jr    $ra




#Mapa de registos delay
# k = 20000
# a0 = ms

delay:
    for:
        blez  $a0,endf
        li    $v0,resetCoreTimer
        syscall
        whiled:
              li    $v0,readCoreTimer
              syscall
              blt   $v0,20000,whiled
        addi  $a0, $a0, -1
        j     for
  endf:
    jr    $ra
