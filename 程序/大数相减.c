#include<stdio.h>
#include<string.h>
char * jian(char c[],int k,char d[],int l)
{
		int n,m,x;
	int e[13]={0},z=0;
	int f;
for(f=0;k>=0;k--,l--,f++)
		{
			if(l>=0)
				n=d[l]-'0';
			else
				n=0;
		
			m=c[k]-'0';
			e[f]=e[f]+m-n;
			if(e[f]<0)
			{
				e[f]=e[f]+10;
				e[f+1]--;
			}
		}
		for(x=0,f--;f>=0;x++,f--)
		c[x]=e[f]+'0';
		c[x]='\0';
		while(c[z]=='0')
			z++;
		c=c+z;
		return c;
	}

char * fun(char a[],int r,char b[],int t)
{
int w;
	if(r>t)
	{
	a=jian(a,r,b,t);
	}
	
	
	
	if(r<t)
	{
		printf("-");
		a=jian(b,t,a,r);
	}
	
	
	
	if(r==t)
	{
		w=strcmp(a,b);
		if(w==0)
		a="0";


		else if(w>0)
		{
			a=jian(a,r,b,t);
		}


		else
		{
			printf("-");
			a=jian(b,t,a,r);
		}
	}
	return a;
}
main()
{
	char p[11],q[12],*s;
	int i,j;
	gets(p);
	gets(q);
	i=strlen(p)-1;
	j=strlen(q)-1;
	s=fun(p,i,q,j);
	puts(s);
}