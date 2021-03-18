#include <stdio.h>
#include <stdlib.h>
#include "stack.h"
#include "queue.h"

int main (void) {
	unsigned int num;
	scanf("%u",&num);
	PtStack s = StackCreate(sizeof(unsigned int));
	PtQueue q = QueueCreate(sizeof(unsigned int));
	unsigned short dig;

	do {
		dig = num % 10;
		StackPush(s,&dig);
		QueueEnqueue(q,&dig);
		num = num / 10;
	} while (num != 0);

	unsigned short digit_q, digit_s;
	unsigned int error = 1;

	while(!QueueIsEmpty(q)) {
		
		QueueDequeue(q,&digit_q);
		StackPop(s,&digit_s);
		printf("%d   %d\n",digit_s, digit_q);
		if(digit_s != digit_q)
			error = 0;
	}

	if(error == 1)
		printf("%d", error);

	QueueDestroy(&q);
	StackDestroy(&s);
}