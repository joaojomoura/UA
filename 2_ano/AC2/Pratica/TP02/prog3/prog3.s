    .equ    resetCoreTimer, 12
    .equ    readCoreTimer, 11
    .equ    printInt, 6
    .equ    putChar, 3

    .data
    .text
    .globl  main
#Mapa de registos
# $s0 = cnt1
# $s1 = cnt5
# $s2 = cnt10
main:
    addiu       $sp,$sp, -16
    sw          $ra, 0($sp)
    sw          $s0, 4($sp)
    sw          $s1, 8($sp)
    sw          $s2, 12($sp)

    li			$s0, 0				# cnt1 = 0
    li          $s1, 0              # cnt5 = 0
    li			$s2, 0				# cnt10 = 0 
    while:                          # while(1) {
        
        li      $a0, 1000           #   $a0 = 1Hz
        jal		delay				#   delay($a0)
        li      $a0, '\r'
        li      $v0, putChar
        syscall                     #   putChar('\r')
        addi    $s0, $s0, 1         #   cnt1++;
        move    $a0, $s0
        li      $a1, 0x0005000A
        li      $v0, printInt
        syscall                     #   printInt(++cnt1, 10 | 5 <<16)

        li      $a0, 200            #   $a0 = 5Hz
        jal		delay				#   delay($a0)
        li      $a0, '\r'
        li      $v0, putChar
        syscall                     #   putChar('\r')
        addi    $s1, $s1, 1         #   cnt5++;
        move    $a0, $s1
        li      $a1, 0x0005000A
        li      $v0, printInt
        syscall                     #   printInt(++cnt5, 10 | 5 <<16)


        li      $a0, 100            #   $a0 = 10Hz
        jal		delay				#   delay($a0)
        li      $a0, '\r'
        li      $v0, putChar
        syscall                     #   putChar('\r')
        addi    $s2, $s2, 1         #   cnt10++;
        move    $a0, $s2
        li      $a1, 0x0005000A
        li      $v0, printInt
        syscall                     #   printInt(++cnt10, 10 | 5 <<16)

        j       while				# }
    lw          $ra, 0($sp)
    lw          $s0, 4($sp)
    lw          $s1, 8($sp)
    lw          $s2, 12($sp)
    addiu       $sp, $sp, 16        
    jr          $ra 








# Mapa de Registos delay - k = 20000
# a0 = ms
delay:
    for:
        blez     $a0, endf          # while(ms > 0){
        li       $v0, resetCoreTimer#   resetCoreTimer();
        syscall
        whiled:
            li   $v0,readCoreTimer #
            syscall                #    v0 = readCoreTimer()
            bge  $v0, 20000, whiled#    while(readCoreTimer() < k);
        addi     $a0, $a0, -1      #    ms--;
        j		 for				# }
endf:
    jr           $ra