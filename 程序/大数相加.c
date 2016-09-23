#include<stdio.h>
#include<string.h>
char *jia(char a[], int n, char b[], int m)
{
	int s[20]={0}, w=0;
	int i, l1, l2;
	for(i=0; n>=0; n--, m--, i++)
	{
		l1 = a[n]-'0';
	if( m>=0 )
	l2=b[m]-'0';
	else
		l2=0;
	s[i]=s[i]+l1+l2;
	   if(s[i]>9)
	   {
		 s[i] = s[i]-10;
		 s[i+1]=s[i+1]+1;
	   }
	}
		for(n=0; i>=0; i--, n++)
		{
	     a[n]=s[i]+'0';
		}
		a[n] = '\0';
		while(a[w] == '0')
			w++;
		a=a+w;
		return a;
}
char *compare(char a[], int n, char b[], int m)
{
	if(a[0]=='0' && b[0] == '0')
		return "0";
	else
	if(n>=m)
		a=jia(a, n, b, m);
	else
		a=jia(b, m, a, n);
	return a;
}
main()
{
	char a[20], b[20], *s;
	int n, m;	
	printf("Please input the first number: ");
	gets(a);
	n = strlen(a)-1;

	printf("Please input the second number: ");
	gets(b);
	m = strlen(b)-1;
	s = compare(a, n, b, m);
	puts(s);
}