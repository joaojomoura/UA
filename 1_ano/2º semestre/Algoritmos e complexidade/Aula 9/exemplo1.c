#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main (void) {
	char string[20];
	printf("string:\n ");
	fgets(string,20,stdin);
	PtStack s =StackCreate(sizeof(char));

	char *p = string;
	while(*p != '\0') {
		StackPush(s,p);
		p++;
	}

	printf("reverse string: \n");

	while(!StackIsEmpty(s)) {
		char a;  
		StackPop(s,&a);
		if(a != '\0') {
			printf("%c",a);
		}
	}
}