      .equ    readCoreTimer,11
      .equ    resetCoreTimer, 12
      .equ    printInt, 6
      .equ    putChar, 3
      .equ    inKey, 1

      .data
      .text
      .globl  main
#Mapa de registos
# s0 = cnt1
# s1 = cnt5
# s2 = cnt10
# s3 = helper

main:
      addiu $sp, $sp, -20
      sw    $ra, 0($sp)
      sw    $s0, 4($sp)
      sw    $s1, 8($sp)
      sw    $s2, 12($sp)
      sw    $s3, 16($sp)
      
      li    $s0,0
      li    $s1,0
      li    $s2,0
      li    $s3,0
      li    $t3,100


start:
      move  $a0, $t3     
      jal   delay

      li    $v0, inKey
      syscall

      ifA:
          bne   $v0, 'a', ifN
          li    $t3, 50
      ifN:
          bne   $v0, 'n',ifR 
          li    $t3,100
      ifR:
          beq   $v0,'r',continue
      ifS:
          bne   $v0, 's', continue
          j     start

  continue:    
      addi  $s3, $s3, 1
      rem   $t1, $s3, 10
      rem   $t2, $s3, 2

      if10:
          bnez  $t1,if5
          addi  $s0, $s0, 1
      if5:
          bnez  $t2,else
          addi  $s1, $s1, 1
      else:
          addi  $s2, $s2, 1

      li  $a0, '\r'
      li  $v0,putChar
      syscall

     move    $a0, $s2
     li      $a1, 0x0005000A
     li      $v0, printInt
    syscall                     #   printInt(++cnt10, 10 | 5 <<16)
    li      $a0, '\t'
    li      $v0, putChar
    syscall                     #   putChar('\t')
    move    $a0, $s1
    li      $a1, 0x0005000A
    li      $v0, printInt
    syscall                     #   printInt(++cnt5, 10 | 5 <<16)
    li      $a0, '\t'
    li      $v0, putChar
    syscall                     #   putChar('\t')
    move    $a0, $s0
    li      $a1, 0x0005000A
    li      $v0, printInt
    syscall                     #   printInt(++cnt1, 10 | 5 <<16)
        
    j       start				# } 



      lw    $ra, 0($sp)
      lw    $s0, 4($sp)
      lw    $s1, 8($sp)
      lw    $s2, 12($sp)
      lw    $s3, 16($sp)
      addiu $sp, $sp, 20
      li    $v0, 0
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
