#include<stdio.h>
#include<stdlib.h>
#define c
typedef struct bitnode
{
	char data;
	struct bitnode * lchild, *rchild;
}bitnode, *bitree;


bitree creatbitree()
{
	char ch;
	bitree t;
	ch=getchar();
	if(ch=='.')
		t=NULL;
	else
	{
		t=(bitree)malloc( sizeof(bitnode) );
		t->data=ch;
		t->lchild=creatbitree();
		t->rchild=creatbitree();
	}
	return t;
}

int output(bitree t, int h)
{
	int i;
	if(t==NULL)
		return 0;

	output(t->rchild, h+1);

	for(i=0; i<3*h; i++)
		printf(" ");

	printf("%c\n", t->data);

	output(t->lchild, h+1);

	return 1;
}


void preorder(bitree t)
{
	if(t)
	{
		printf("%c", t->data);
		preorder(t->lchild);
		preorder(t->rchild);
	}

}

void inorder(bitree t)
{
	if(t)
	{
		inorder(t->lchild);
		printf("%c", t->data);
		inorder(t->rchild);
	}
}

void postorder(bitree t)
{
	if(t)
	{
		postorder(t->lchild);
		postorder(t->rchild);
		printf("%c", t->data);
	}
}



void main()
{
	bitree t;
	int h=0;
	printf("\n建立二叉树\n");
	t=creatbitree();
	output(t, h);

	printf("\n先序\n");
	preorder(t);

	printf("\n\n中序\n");
	inorder(t);

	printf("\n\n后序\n");
	postorder(t);
	printf("\n\n");
}


