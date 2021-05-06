      .equ    readCoreTimer,11
      .equ    resetCoreTimer, 12
      .equ    printInt, 6
      .equ    putChar, 3

      .data
      .text
      .globl  main

main:
      li    $t0, 0    # counter = 0
    while:
          li    $v0,readCoreTimer
          syscall                   #readCoreTimer()
          bge   $v0,200000,while    # while(readCoreTimer() < 200000);
          li    $v0,resetCoreTimer
          syscall                   # resetCoreTimer()
          add   $t0, $t0, 1
          mov   $a0,$t0
          mov   $a1, 0x0004000A
          li    $v0,printInt
          syscall
          li    $a0,'\r'
          li    $v0,putChar
          syscall
          j     while
    li    $v0,0
    jr    $ra

