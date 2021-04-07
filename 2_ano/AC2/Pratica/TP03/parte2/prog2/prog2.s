#159 page all lat tris port adress
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
main:

    addiu       $sp, $sp, -16
    sw          $ra, 0($sp)
    sw          $s0, 4($sp)
    sw          $s1, 8($sp)
    sw          $s2, 12($sp)

    lui         $s0, SFR_BASE_HI
    #porto saida
    lw			$s1, TRISE($t1)			# READ (Mem_adr = 0xBF880000 + 0x6100)
    andi        $s1, $s1, 0xFFF0        # Modify bit 0 a 3 = 0
    sw			$s1, TRISE($s0)			# Write Trise(0) = 0
    
    #porto entrada
    lw			$s1, TRISB($s0)			# READ (Mem_adr = 0xBF880000 + 0x6040)
    andi        $s1, $s1, 0x000F        # Modify bit 0 a 3 = 1
    sw			$s1, TRISB($s0)			# Write Trisb(0) = 1

    li          $s2, 0                  # cont = 0
    loop:
        lw          $s1, LATE($s0)          # ler valores presentes no porto saida 
        andi        $s1, $s1, 0xFFF0        # extrair bit 0-3
        or          $s1, $s1, $s2           # colocar o valor de cont nos bits 0-3
        sw          $s1, LATE($s0)          # escrever valor saida
        addi        $s2, $s2, -1             # cont--
        li          $a0, 250               
        jal         delay                   #delay(250) 4Hz
        j			loop
    
    lw          $ra,0($sp)
    lw          $s0, 4($sp)
    lw          $s1, 8($sp)
    lw          $s2, 12($sp)
    addiu       $sp, $sp, 16
    jr			$ra					# jump to $ra



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
    jr           $ra