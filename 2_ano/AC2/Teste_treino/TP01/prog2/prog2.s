          .equ      getChar, 2
          .equ      putChar, 3
          
          .data
          .text
          .globl    main
main:

  do:
          li    $v0, getChar
          syscall
          move  $t0, $v0  #c = getChar

          beq   $t0,'\n',while  #if(c != '\n')
            add   $t0,$t0,1
            move  $a0,$t0       
            li    $v0,putChar
            syscall             #   putChar(c)
  while:
          bne   $t0,'\n',do
  li    $v0,0
  jr    $ra

