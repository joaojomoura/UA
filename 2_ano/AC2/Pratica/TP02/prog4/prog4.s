    .equ    resetCoreTimer, 12
    .equ    readCoreTimer, 11  

# Mapa de registos timeDone():
# $t0 = curcount
# $t1 = retValue

timeDone:
    li      $t1, 0          # retValue = 0
    ift:
        blez        $a1, elset      # if(reset > 0)
        li          $v0, resetCoreTimer
        j           return

    elset:
        li          $v0, readCoreTimer
        syscall
        move        $t0, $v0
        mult        $t3, $a0, 20000 
        ifcur:
            ble         $t0, $t3, return
            div         $t1, $t0, 20000
    return:
    move        $v0, $t1
    jr          $ra