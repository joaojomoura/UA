.equ printStr, 8
.equ readStr, 9
.equ printInt, 6
.equ printInt10, 7
.equ STR_MAX_SIZE, 20
	
	.data
st0:	.asciiz "\nIntroduza 1 string: "
st1:	.asciiz "\nResultados:"
st2:	.asciiz "\nTamanho da String: "
st3:	.asciiz "\nConcatenação: "
st4:	.asciiz "\nComparação: "
str1:	.space 21
str2:	.space 21
str3:	.space 41
	.text
	.globl main
	
main:	
    addiu $sp, $sp, -4			#Reservar espaço na Stack
	sw  $ra, 0($sp)				#Salvaguardar os valores do registo
	
	la  $a0, st0				#
	li  $v0, printStr			#printStr(st0);
	syscall					#
	
	la  $a0, str1				#
	li  $a1, STR_MAX_SIZE			#
	li  $v0, readStr			#readStr(str1, STR_MAX_SIZE);
	syscall					#

	la  $a0, st0				#
	li  $v0, printStr			#printStr(st0);
	syscall					#
	
	la  $a0, str2				#
	li  $a1, STR_MAX_SIZE			#
	li  $v0, readStr			#readStr(str2, STR_MAX_SIZE);
	syscall					#
	
	la  $a0, st1				#
	li  $v0, printStr			#printStr(st1);
	syscall					#
	
	la  $a0, st2				#
	li  $v0, printStr			#
	syscall					#
	
	la  $a0, str1				#
	jal strlen				#strlen(str1);
	move $a0, $v0				#
	li  $a1, 10				#
	li  $v0, printInt			#printInt(strlen(str1), 10);
	syscall					#
	
	la  $a0, st2				#
	li  $v0, printStr			#printStr(st2);
	syscall					#
	
	la  $a0, str2				#
	jal strlen				#strlen(str2);
	move $a0, $v0				#
	li  $a1, 10				#
	li  $v0, printInt			#printInt(strlen(str2), 10);
	syscall					#
	
	la  $a0, st3				#
	li  $v0, printStr			#printStr(st3);
	syscall					#
	
	la  $a0, str3				#
	la  $a1, str1				#
	jal strcpy				#strcpy(str3, str1);

	la  $a0, str3				#
	la  $a1, str2				#
	jal strcat				#strcat(str3, str2);
	move $a0, $v0				#
	li  $v0, printStr			#printStr(strcat(str3, str2);
	syscall					#

	la  $a0, st4				#
	li  $v0, printStr			#printStr(st4);
	syscall					#
	
	la  $a0, str1				#
	la  $a1, str2				#
	jal strcmp				#strcmp(str1, str2);
	move $a0, $v0				#
	li  $v0, printInt10			#printInt10(strcmp(str1, str2));
	syscall					#
		 			 		
	lw  $ra, 0($sp)				#Devolver os valores aos registos
	addiu $sp, $sp, 4			#Libertar espaço na Stack
	
	li  $v0, 0				#return 0;
	jr  $ra					#



#Mapa de registos strlen:
# $t0 = len
# $t1 = s

strlen:
    li			$t0, 0			# $t0 = 0
    while:
        lb			$t1, 0($a0)			# *s
        beq         $t1, 0, endw     # while(*s != '\0')
        addi        $t0, $t0, 1         # len++
        addiu       $a0, $a0, 1         # s++
        j			while				# jump to while
    endw:
    move        $v0, $t0
    jr          $ra             # return len


#Mapa de registos strcopy:
# $a0 = dst
# $a1 = src
# p = $t0

strcopy:
    do:
        lb      $t0,0($a1)      # p = *dst
        sb      $t0,0($a0)      # *dst = *src
        addi    $a1, $a1, 1     # scr++
        addi    $a0, $a0, 1     # dst++
        bne     $t0, 0, do      #} while(*src != '\0')
        move    $v0,$t0
        jr      $ra             # return p

# Mapa de registos strcat:
# $s0 = p
# $s1 = dst
# $s2 = *dst

strcat:
    addiu   $sp, $sp, -16
    sw      $ra, 0($sp)
    sw		$s0, 4($sp)			 
    sw      $s1, 8($sp)
    sw		$s2, 12($sp)			 
    
    move    $s0, $a0     # p = dst
    move    $s1, $a0     # dst

    while1:
        lb      $s2, 0($s1)     # *dst
        beq     $s2, 0, endw1   # while(*dst != '\0')
        addi    $s1, $s1, 1     #   dst++
        j       while1
    endw1:
    move    $a0, $s1
    jal     strcopy
    move    $v0,$s0

    lw      $ra, 0($sp)
    lw		$s0, 4($sp)			 
    lw      $s1, 8($sp)
    lw		$s2, 12($sp)    
    addiu   $sp, $sp, 16
    jr      $ra

# Mapa de registos strcmp:
# *s1 = $t0
# *s2 = $t1

strcmp:
    for1:
        lb      $t0, 0($a0)     # t0 = *s1
        lb      $t1, 0($a1)     # t1 = *s2
        bne     $t0, $t1, endf1 # while(*s1 == *s2
        beq     $t0, 0, endf1   # && *s1 != '\0')
        addiu   $a0, $a0, 1     # s1++
        addiu   $a1, $a1, 1     # s2++
        j		for1
    endf1:
    sub     $v0, $t0, $t1
    jr      $ra             # return( *s1 - *s2 );
        