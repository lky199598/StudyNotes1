#include<stdio.h>
#include<stdlib.h>
#include <string.h>

typedef struct node
{
	char *data;
	char **s;
}node;


void main()
{
	node p;
	int i;

	char s1[10]="123456\n";
	char s2[3][10]={"123", "456", "789"};

	p.data=(char *)malloc( 10*sizeof(char) );//data[10]

	strcpy(p.data, s1);	
	printf("%s\n\n", p.data);

	p.s=(char **)malloc( 3*sizeof(char*) );//*s[3]
	for(i=0; i<3; i++)
	{
		p.s[i]=(char *)malloc( 10*sizeof(char) );//s[3][10]
		strcpy(p.s[i], s2[i]);
		printf("%s\n", p.s[i]);
	}


}




