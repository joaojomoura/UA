/************** Implementa��o Din�mica Gen�rica - stack.c **************/
/****** Implementation File of a Generic Dynamic Stack - stack.c *******/

#include <stdlib.h>
#include <string.h>
#include "stack.h"	/* ficheiro de interface da pilha */

/*************** Defini��o do Estrutura de Dados da Pilha **************/
/**************** Definition of the Stack Data Structure ***************/

typedef struct node *PtNode;

struct node	/* defini��o de um n� da lista - node definition */
{
	void *PtElem;	/* ponteiro para o elemento gen�rico - pointer to a generic element */
	PtNode PtPrev;	/* ponteiro para o n� anterior - pointer to next node */
};
 
struct stack	/* defini��o da pilha - stack definition */
{
	unsigned int Size;	/* tamanho em n�mero de bytes de cada elemento - size of the element */
	PtNode Top;	/* topo da pilha - stack top */
};

/********************** Defini��o dos Subprogramas *********************/
/******************* Implementation of the Operations ******************/

PtStack StackCreate (unsigned int psize)
{
	PtStack Stack;

	if (psize == 0) return NULL;
	if ((Stack = (PtStack) malloc (sizeof (struct stack))) == NULL)
		return NULL;	/* alocar mem�ria para a pilha - memory alocation for the stack */
	Stack->Size = psize;	/* armazenar o tamanho dos elementos - store the element's size */
	Stack->Top = NULL;	/* inicializar o topo da pilha - stack top inicialization*/
	return Stack;	/* devolver a refer�ncia da pilha acabada de criar - returning the new stack */
}

int StackDestroy (PtStack *pstack)
{
	PtStack TmpStack = *pstack; PtNode TmpNode;

	if (TmpStack == NULL) return NO_STACK;
	while (TmpStack->Top != NULL)
	{				/* libertar a mem�ria ocupada pelos elementos da pilha - free the list elements */
		TmpNode = TmpStack->Top;
		TmpStack->Top = TmpStack->Top->PtPrev;
		free (TmpNode->PtElem);
		free (TmpNode);
	}
	free (TmpStack);	/* libertar a mem�ria ocupada pela pilha - free the stack */
	*pstack = NULL;	/* colocar a refer�ncia da pilha a NULL - stack pointing to null*/
	return OK;
}

int StackPush (PtStack pstack, void *pelem)
{
	PtNode TmpNode;

	if (pstack == NULL) return NO_STACK;
	if ((TmpNode = (PtNode) malloc (sizeof (struct node))) == NULL)
		return NO_MEM;
	if ((TmpNode->PtElem = malloc (pstack->Size)) == NULL)
	{ free (TmpNode); return NO_MEM; }
	TmpNode->PtPrev = pstack->Top;
	pstack->Top = TmpNode;
	memcpy (pstack->Top->PtElem, pelem, pstack->Size);	/* colocar - storing */
	return OK;
}

int StackPop (PtStack pstack, void *pelem)
{
	PtNode TmpNode;

	if (pstack == NULL) return NO_STACK;
	if (pstack->Top == NULL) return STACK_EMPTY;
	if (pelem == NULL) return NULL_PTR;
	memcpy (pelem, pstack->Top->PtElem, pstack->Size);	/* retirar - removing */
	TmpNode = pstack->Top;
	pstack->Top = pstack->Top->PtPrev;
	free (TmpNode->PtElem);
	free (TmpNode);
	return OK;
}

int StackIsEmpty (PtStack pstack)
{
	if (pstack == NULL) return NO_STACK;
	if (pstack->Top == NULL) return STACK_EMPTY;
	return OK;
}

int StackTop (PtStack pstack, void *pelem)
{
	if (pstack == NULL) return NO_STACK;
	if (pstack->Top == NULL) return STACK_EMPTY;
	if (pelem == NULL) return NULL_PTR;
	memcpy (pelem, pstack->Top->PtElem, pstack->Size);	/* copiar - copying */
	return OK;
}
