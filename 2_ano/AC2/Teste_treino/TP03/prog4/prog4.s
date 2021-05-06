    .equ    SFR_BASE_HI, 0XBF88
    .equ    TRISE, 0x6100
    .equ    PORTE, 0x6110
    .equ    LATE,0x6120

    .equ    TRISB, 0x6040
    .equ    PORTB, 0x6050
    .equ    LATB,0x6060
    
    .equ    readCoreTimer, 11
    .equ    resetCoreTimer, 12   

    .data
    .text
    .globl  main

# Mapa de registos:
# s0 = v
# s1  
# s2 
main:
    addiu       $sp, $sp, -16
    sw          $ra, 0($sp)
    sw          $s0, 4($sp)
    sw          $s1, 8($sp)
    sw          $s2, 12($sp)
    
    li    $s2, 0
    lui   $s0, SFR_BASE_HI
    lw    $s1, TRISE($s0)   #READ
    andi  $s1, $s1, 0xFFFE  #Modify
    sw    $s1, TRISE($s0)   #Write

    while:
        lw    $s1,LATE($s0)
        andi  $s1,$s1,0xFFFE
        or    $s1, $s2, $s1
        sw    $s1, LATE($s0)
        li    $a0,500
        jal   delay
        xor   $s2, $s2, 1
        j     while



    lw          $ra,0($sp)
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
            ble  $v0, 20000, whiled#    while(readCoreTimer() < k);
        addi     $a0, $a0, -1      #    ms--;
        j		 for				# }
endf:
    jr    $ra
