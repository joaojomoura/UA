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
        
        lw    $t1, TRISE($t0)     # READ
        andi  $t1, $t1, 0xFFF0    # Modify (RE0-3 = 0) output
        sw    $t1, TRISE($t0)     # Write

        lw    $t1, TRISB($t0)     # Read
        ori   $t1, $t1,0x000F     # Modify (RB0-3 = 1) input
        sw    $t1, TRISB($t0)     # Write

        while:
            lw    $t1,PORTB($t0)
            andi  $t1,$t1,0x000F  # Extract the last four digits
            xor   $t1,$t1,0x0009  # deny first and fourth
            lw    $t2,LATE($t0)   # read input ports
            andi  $t2,$t2,0xFFF0  #  Extract the last four digits 
            or    $t2, $t2, $t1   # Update value to read
            sw    $t2, LATE($t0)
            j     while
        jr    $ra
