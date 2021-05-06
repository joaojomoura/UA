        .equ    inkey, 1
        .equ    putChar, 3

        .data
        .text
        .globl  main
main:
      do:
          li    $v0,inkey
          syscall
          mov   $t0,$v0
          beqz  $t0,do    # while((c = inkey()) == 0)
          
          beq   $t0,'\n',while
            mov   $a0,$t0
            li    $v0,putChar
            syscall 
      while:
          bne   $t0,'\n',do
      li    $v0,0
      jr    $ra

              
