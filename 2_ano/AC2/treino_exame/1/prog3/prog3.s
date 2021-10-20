    .equ INKEY,1
    .equ PUT_CHAR,3

    .data
    .text
    .globl main

main:
      
do:

while:

    li  $v0,INKEY
    syscall
    move $t0,$v0
    beqz $t0,while
if:
    beq  $t0, '\n',endif
    move $a0, $t0
    li   $t0,PUT_CHAR
    syscall

endif:
    bne  $t0, '\n',do
    li  $v0,0
    jr  $ra

