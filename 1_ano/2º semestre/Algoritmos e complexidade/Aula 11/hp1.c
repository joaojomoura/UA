#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "pqueue.h" /* Ficheiro de interface do TDA */

int main (void) {

	int  array [] = {1000,5,8,900,7,6};
	int a; 

	PtPQueue pqueue = PQueueCreate(6);
	for(int i = 0; i < 6; i++)
		PQueueInsert (pqueue, array[i]);
	for(int i = 5; i >= 0; i--) {
		PQueueDeleteMax(pqueue,&a);
		array[i] = a;
	}

	for(int i = 0; i < 6; i++)
		printf("%d ",array[i] );

	printf("\n");


}