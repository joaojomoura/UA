    .equ    getchar,2
    .equ    putchar,3

    .data
    .text
    .globl  main
main:
do:
    li	        $v0,getchar   				# $v0 = getchar 
    syscall
    move        $t0,$v0                  # t0 = getchar
if:
    beq			$t0, '\n', endif	# if $t0 ! = '\n' endif
    move        $a0, $t0
    li		    $v0, putchar		# $v0 =putchar 
    syscall
endif:
    bne			$t0, '\n', do	# if $t0 != '\n' then do
    li		    $v0, 0		    #   $v0 =0 
    jr			$ra			    # jump to $ra