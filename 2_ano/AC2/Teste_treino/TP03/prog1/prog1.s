        .equ    SFR_BASE_HI, 0xBF88   # 16 MSbits of SFR area
        
        .equ    TRISE, 0x6100
        .equ    PORTE, 0x6110
        .equ    LATE, 0x6120
        
        .equ    TRISB, 0x6040
        .equ    PORTB, 0x6050
        .equ    LATB, 0x6060

        .data
        .text
        .globl  main

  main:
        lui   $t0, SFR_BASE_HI    #
        lw    $t1, TRISE($t0)     # READ (mem-addr = 0xBF880000 + 0x6100)
        andi  $t1, $t1, 0xFFFE    # MODIFY (RE0 = 0 == 0xFFFE(1110))
        sw    $t1, TRISE($t0)     # Write 

        lw    $t1,TRISB($t0)      # READ
        ori   $t1, $t1, 0x0001    # MODIFY
        sw    $t1, TRISB($t0)     # Write

    while:
          lw    $t1, PORTB($t0)   # READ porto de entrada
          andi  $t1, $t1, 0x0001  # Extract bit 0
          nor   $t1, $t1, 0       # EX 2, negate RB0
          lw    $t2, LATE($t0)    # READ porto de saida
          andi  $t2, $t2, 0xFFFE  # change bit0

          or    $t2, $t2, $t1
          sw    $t2, LATE($t0)    # store RE0 = RB0
          j     while
    jr    $ra


