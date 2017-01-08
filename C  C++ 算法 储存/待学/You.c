#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

#define framex 4
#define framey 4
#define high 22
#define width 40

int i, j;
void locate(HANDLE hOut, int x, int y)
{
	COORD pos;
	pos.X=x;
	pos.Y=y;
	SetConsoleCursorPosition(hOut, pos);
}

main()
{  
	HANDLE hOut = GetStdHandle(STD_OUTPUT_HANDLE);

	locate(hOut, framex, framey);
	 printf("¨X"); 

	 locate(hOut, framex+width,framey);
	 printf("¨[");  

	 locate(hOut, framex, framey+high); 
	 printf("¨^"); 

	 locate(hOut, framex+width, framey+high); 
	 printf("¨a");

	 for(i=2; i<=width-2; i+=2)
	 {
		 locate(hOut, framex+i, framey);
		 printf("¨T");
	 }

	 for(i=2; i<=width-2; i+=2)
	 {
		 locate(hOut, framex+i, framey+high);
		 printf("¨T");
	 }

	 for(i=1; i<high; i++)
	 {
		 locate(hOut, framex, framey+i); 
		 printf("¨U"); 
	 } 
	 
	 for(i=1; i<high; i++)
	 {
		 locate(hOut, framex+width, framey+i); 
		 printf("¨U"); 
	 }
}
	 




