#include<stdio.h>
#include<stdlib.h>

typedef struct stack
{
	char ch;
	struct stack *next;
}stack;


void instack(stack *top, char ch);
int outstack(stack *top, char *data);
void input(stack *top);
void output(stack *top);


stack* init()
{
	stack *top;
	top=(stack *)malloc( sizeof(stack) );
	top->next=NULL;
	return top;
}


void instack(stack *top, char ch)
{
	stack *p=(stack *)malloc( sizeof(stack) );

	p->ch=ch;
	p->next = top->next;
	top->next=p;
}

int outstack(stack *top, char *data)
{
	stack *p;

	if(top->next == NULL)
	{
		printf("\nÕ»¿Õ\n");
		return 0;
	}

	p=top->next;
	top->next=p->next;
	*data=p->ch;
	free(p);
	return 1;
}

void input(stack *top)
{
	char ch;
	printf("ÊäÈë\n");
	ch=getchar();

	while(ch != '#')
	{
		instack(top, ch);
		ch=getchar();
	}

}

void output(stack *top)
{
	char ch;
	
	printf("\nÊä³ö\n");
	printf("\n\n");

	while( top->next )
	{
		outstack(top, &ch);
		printf("%c", ch);
	}
	printf("\n\n");
}


void main()
{
	stack *top;
	top=init();

	input(top);
	output(top);
}





