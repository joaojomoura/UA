    .equ    putchar, 3
    .equ    inkey, 1

    .data
    .text
    .globl  main
main:
    
do:    
    
while:
   
    li		    $v0, inkey		    # $v0 =inkey 
    syscall
    move        $t0, $v0
    beq		    $t0, $0, while	    # if $t0 != $0,  then while   

if:    
    beq		    $t0, '\n', endif	# if $t0 == '\n' then endif
    move        $a0, $t0
    li		    $v0, putchar		# $v0 =putchar 
    syscall
    
endif:
    bne			$t0, '\n', do	# if $t0 != '\n' then do
    li		    $v0, 0		    #   $v0 =0 
    jr			$ra			    # jump to $ra
    