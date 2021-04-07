#159 page all lat tris port adress
    .equ    SFR_BASE_HI, 0XBF88
    .equ    TRISE, 0x6100
    .equ    PORTE, 0x6110
    .equ    LATE,0x6120

    .equ    TRISB, 0x6040
    .equ    PORTB, 0x6050
    .equ    LATB,0x6060

    .data
    .text
    .globl  main
main:

    lui         $t1, SFR_BASE_HI
    lw			$t2, TRISE($t1)			# READ (Mem_adr = 0xBF880000 + 0x6100)
    andi        $t2, $t2, 0xFFF0        # bit 0 a 3 = 0
    sw			$t2, TRISE($t1)			# Trise(0) = 0
    
    lw			$t2, TRISB($t1)			# READ (Mem_adr = 0xBF880000 + 0x6040)
    ori         $t2, $t2, 0x000F        # bit 0 a 3 = 1
    sw			$t2, TRISB($t1)			# Trisb(0) = 1

    loop:
        lw          $t0, PORTB($t1)
        andi        $t0, $t0, 0x000F    # extrair bits 0 a 3
        xor         $t0, $t0, 0x0009    # RE(0-3) xor RB(0 - 3)
        lw          $t3, LATE($t1)
        andi        $t3, $t3, 0xFFF0    # modificar os bits 0 a 3 
        or          $t0, $t0, $t3       # atualizar o valor para saida
        sw          $t0, LATE($t1)      # saida
        j			loop
    
    jr			$ra					# jump to $ra