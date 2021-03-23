    .equ    resetCoreTimer, 12
    .equ    readCoreTimer, 11
    .equ    printInt, 6
    .equ    putChar, 3

    .data
    .text
    .globl  main
#Mapa de registos
# $s0 = counter
main:
    addiu        $sp,$sp, -8
    sw          $ra, 0($sp)
    sw          $s0, 4($sp)

    li			$s0, 0				# counter = 0 
    while:                          # while(1) {
        li      $a0, 100            #   $a0 = 10Hz
        jal		delay				#   delay($a0)
        addi    $s0, $s0, 1         #   counter++;
        move    $a0, $s0
        li      $a1, 0x0004000A
        li      $v0, printInt
        syscall                     #   printInt(++counter, 10 | 4 <<16)
        li      $a0, '\r'
        li      $v0, putChar
        syscall                     #   putChar('\r')
        j       while				# }
    lw          $ra,0($sp)
    lw          $s0,4($sp)
    addiu       $sp, $sp, 8        
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
