    .equ    readCoreTimer,11
    .equ    resetCoreTimer, 12
    .equ    printInt, 6
    .equ    putChar, 3

    .data
    .text
    .globl  main
#Mapa de registos
# $t0 = counter
main:
    li			$t0, 0				# counter = 0 
    while:                          # while(1) {
        li      $v0, readCoreTimer  #   $v0 = readCoreTimer()
        syscall
        bge     $v0, 200000, while  #   while(readCoreTimer() < 200000); 100 Hz
#       bge     $v0, 2000000, while #   10Hz
#       bge     $v0, 4000000, while #   5Hz
#       bge     $v0, 20000000, while#   1Hz
        li      $v0, resetCoreTimer
        syscall                     #   resetCoreTimer();
        addi    $t0, $t0, 1         #   counter++;
        move    $a0, $t0
        li      $a1, 0x0004000A
        li      $v0, printInt
        syscall                     #   printInt(++counter, 10 | 4 <<16)
        li      $a0, '\r'
        li      $v0, putChar
        syscall                     #   putChar('\r')
        j       while				# }
    jr      $ra 
        