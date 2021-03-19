# Mapa de registos:
# s0 = s
# s1 = cnt
# s2 = c

    .equ    putchar, 3
    .equ    printInt, 6
    .equ    inkey, 1
    .equ    s,$s0
    .equ    cnt, $s1
    .equ    c, $s2

    .data
    .text
    .globl  main
main:
    addiu       $sp,$sp,-16
    sw			$ra, 0($sp)
    sw			s, 4($sp)
    sw          cnt,8($sp)
    sw			c, 12($sp)

    li          s, 0                    # s = 0
    li          cnt, 0                  # cnt = 0

do:
    li          $a0,'\r'
    li          $v0,putchar
    syscall                             #putchar('\r')

    move        $a0, cnt
    li          $a1, 0x0003000A
    li          $v0, printInt
    syscall                             #printInt( cnt, 10 | 3 << 16 );

    li          $a0,'\t'
    li          $v0,putchar
    syscall                             #putchar('\t')

    move        $a0, cnt
    li          $a1, 0x00080002
    li          $v0, printInt
    syscall                             #printInt( cnt, 2 | 8 << 16 );

    li          $a0, 5
    jal			wait    				# jump to wait and save position to $ra// wait(5)

    li          $v0,inkey
    syscall
    move        c, $v0                  # c = inkey();

ifr:
    bne		    c, 'r', ifs             # if(c == r)
    li          cnt, 0                  #   cnt = 0

ifs:
    bne		    c, 's', ifp	
    j			do			            # jump to do (cnt = cnt)
    



ifp:    
    bne		    c, '+', ifm             # if c != '+' then  ifm
    li          s, 0                    # s = 0

ifm:
    bne		    c, '-', if0             # if c != '-' then  if0
    li          s, 1                    # s = 1

if0:
    bne		    s, $0, else	            # if  s != 0 then else
    addi        cnt, cnt, 1             #   
    andi        cnt, cnt, 0xFF          #   cnt = (cnt + 1) & 0xFF;

else:                                   # else
    addi        cnt, cnt, -1            
    andi        cnt, cnt, 0xFF          #       cnt = (cnt - 1) & 0xFF;
    bne         c, 'q', do              # } while( c != 'q' );

enddo:
    lw			$ra, 0($sp)			# 
    lw			$s0, 4($sp)			#
    lw			$s1, 8($sp)			#
    lw			$s2, 12($sp)	    #
    addiu       $sp, $sp, 16

    li          $v0, 0
    jr          $ra




#Mapa de registos - wai(int ts)
# a0 = ts
# t0 = i
wait:
    li      $t0,0           # i = 0
for:
    mul     $a0,$a0,515000  # a0 = ts * 515000
    bge     $t0,$a0,endfor  # i < a0
    addi    $t0,$t0,1       # i++

endfor:
    jr      $ra
    