    .equ get_char,2
    .equ put_char,3

    .data
    .text
    .globl main
main:

      do:
          li    $v0,get_char
          syscall
          move  $t0,$v0

          if:
              beq   $t0,'\n', endif
              move  $a0, $t0
              li    $v0,put_char
              syscall
          endif:
          bne   $t0, '\n', do
          li    $v0, 0
      jr  $ra

