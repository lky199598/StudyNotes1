#include<stdio.h>
#include<string.h>
char *jian(char a[], int n, char b[], int m)
{
	int s[20] = {0}, z=0;
	for( ; n>=0; n--, m--)
	{
		if(m>=0)
			s[n] = s[n] + a[n] - b[m];
		else
			s[n] = s[n] + a[n]-'0';
		if(s[n] < 0)
		{
			s[n] = s[n] +10;
			s[n-1]--;
		}
		a[n] = s[n]+'0';
	}
	while(a[z] == '0')
			z++;
		a = a+z;
		return a;
}
char *change(char a[], int n, char b[], int m)
{
	if(n>m)
		a = jian(a, n, b, m);
	if(n<m)
	{
		printf("-");
		a = jian(b, m, a, n);
	}
	if(n==m)
	{
		if(strcmp(a, b) >0)
			a = jian(a, n, b, m);
		else
			if(strcmp(a, b) <0)
		{
			printf("-");
		a = jian(b, m, a, n);
		}
			else
				return "0";
	}
	return a;
}
void main()
{
	char a[20], b[20], *s;
	int n, m;
	printf("Please input the first number: ");
	gets(a);
	printf("Please input the second number: ");
	gets(b);
	n = strlen(a)-1;
	m = strlen(b)-1;
	s = change(a, n, b, m);
	puts(s);
}