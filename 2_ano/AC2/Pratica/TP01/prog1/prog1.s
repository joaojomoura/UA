        .equ    PRINT_STR,8

        .data

msg:    .asciiz "ac2"
        .text
        .globl main
main:
        la      $a0,msg
        li      $v0,PRINT_STR
        syscall                 # printStr("AC2 – DETPIC32\n");
        li      $v0,0           # return 0;
        jr      $ra