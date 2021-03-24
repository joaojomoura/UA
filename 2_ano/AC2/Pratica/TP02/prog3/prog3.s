    .equ    resetCoreTimer, 12
    .equ    readCoreTimer, 11
    .equ    printInt, 6
    .equ    putChar, 3
    .equ    inkey, 1

    .data
    .text
    .globl  main
#Mapa de registos
# $s0 = cnt1
# $s1 = cnt5
# $s2 = cnt10
# $s3 = delay
# $t0 = helper
main:
    addiu       $sp,$sp, -20
    sw          $ra, 0($sp)
    sw          $s0, 4($sp)
    sw          $s1, 8($sp)
    sw          $s2, 12($sp)
    sw          $s3, 16($sp)

    li			$s0, 0				# cnt1 = 0
    li          $s1, 0              # cnt5 = 0
    li			$s2, 0				# cnt10 = 0
    li          $t0, 0              # helper = 0
    li          $s3,100             #   delay = 100 
    while:                          # while(1) {
        
        li      $v0,inkey           
        syscall                     # inkey()
        bne     $v0,'a',ifN         # if(inkey == 'A')
        li      $s3, 50             #   delay = 50
        j       start
        ifN:
        bne     $v0,'n',while       # if(inkey == 'n')
        
        
sustain:
        li      $v0,inkey           
        syscall                     # inkey()
        bne     $v0,'s',ifR
        j       sustain
        ifR:
        bne     $v0,'r',while
        
start:
        or      $a0, $s3, $0        #   $a0 = delay
        jal		delay				#   delay($a0)
        addi    $t0,$t0,1           #   helper++
       

        rem     $t1, $t0, 10         #   t1 = helper % 10
        rem     $t2, $t0, 2          #   t2 = helper % 2
        if10:
            bnez    $t1,if5         #   if(t1 == 0)
            addi    $s2, $s2, 1         #   cnt10++;
            
        if5:
            bnez    $t2,else         #   if(t2 == 0)
            addi    $s1, $s1, 1         #   cnt5++;
           
        else:
            addi    $s0, $s0, 1         #   cnt1++;
            
            
        li      $a0, '\r'
        li      $v0, putChar
        syscall                     #   putChar('\r')    
        move    $a0, $s2
        li      $a1, 0x0005000A
        li      $v0, printInt
        syscall                     #   printInt(++cnt10, 10 | 5 <<16)
        li      $a0, '\t'
        li      $v0, putChar
        syscall                     #   putChar('\t')
        move    $a0, $s1
        li      $a1, 0x0005000A
        li      $v0, printInt
        syscall                     #   printInt(++cnt5, 10 | 5 <<16)
        li      $a0, '\t'
        li      $v0, putChar
        syscall                     #   putChar('\t')
        move    $a0, $s0
        li      $a1, 0x0005000A
        li      $v0, printInt
        syscall                     #   printInt(++cnt1, 10 | 5 <<16)
        
        j       while				# }


    lw          $ra, 0($sp)
    lw          $s0, 4($sp)
    lw          $s1, 8($sp)
    lw          $s2, 12($sp)
    lw          $s3, 16($sp)
    addiu       $sp, $sp, 20 
    li          $v0, 0       
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
    jr           $ra






    start:
        li      $a0, 100
        jal		delay				#   delay($a0)
        addi    $s2, $s2, 1         #   cnt10++;

        li      $a0, 200
        jal     delay    
        addi    $s1, $s1, 1         #   cnt5++;
        
        li      $a0, 1000
        jal     delay
        addi    $s0, $s0, 1         #   cnt1++;