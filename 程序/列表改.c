#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct student
{
	char name[20];
	char address[20];
	char phone[20];
	struct student *next;
};
struct student *creat()
{
	struct student *head;
	head = malloc(sizeof(struct student));
	printf("Name: ");
	getchar();
	gets(head->name);
	printf("Address: ");
	gets(head->address);
	printf("Phone: ");
	gets(head->phone);
	printf("\n");
	head->next=NULL;
	return head;
}
struct student *insert(struct student *head, struct student * wei)
{
	struct student *p;
	wei = malloc(sizeof(struct student));
	printf("Name: ");
	gets(wei->name);
	printf("Address: ");
	gets(wei->address);
	printf("Phone: ");
	gets(wei->phone);
	wei->next=NULL;
	printf("\n");
	p = head;
	while(p->next)
	{
		p = p->next;
	}
	p->next = wei;
	return head;
}
struct student *find(struct student *head, char *s)
{
	struct student *p;
	if( !head )
	{
		printf("The list is empty\n");
		return NULL;
	}
	p = head;
	while(strcmp(p->name, s) && p->next)
	{
		p = p->next;
	}
	if(!strcmp(p->name, s))
		printf("The information is: \nName: %s\nAddress: %s\nPhone: %s\n", p->name, p->address, p->phone);
	else
		printf("Can not find the name!\n");
	return head;
}
void output(struct student *head)
{
	while(head)
	{
		printf("Name: %s\nAddress: %s\nPhone: %s\n\n", head->name, head->address, head->phone);
		head = head->next;
	}
}
main()
{
	int n, i;
	char s[20];
	struct student *head, *wei;
	printf("please input student information numbers: ");
	scanf("%d", &n); 
	wei = malloc( (n-1)*sizeof(struct student) );
	printf("\n\n                                          input\n");
	head = creat();
	for(i=0; i<n-1; i++)
		head = insert(head, wei+i);
	printf("\n\n                                      All the information\n");
	output(head);
	printf("Plase input a name to search: ");
	gets(s);
	head = find(head, s);
}


	




	




	











