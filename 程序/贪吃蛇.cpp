#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>

#define LMIN 4
#define LMAX 20
#define ROW 20
#define COL 20

int i, j;

char changedir(char, int);
int changehead(char (*)[], char **, char);
void display(char (*)[]);

int main(void)
{

	char stage[ROW][COL];
	char *body[LMAX];
	char *food = &(stage[ROW - 4][3]);
	int level = 1;
	int lnow;
	char direct;
	char *temphead;

	srand(time(NULL));
		
	start:
	{
		direct = 'a';
		lnow = LMIN;
	
		for (i = 0; i < ROW; ++i)	
		{
			for (j = 0; j < COL; ++j)
			{
				stage[i][j] = ' ';
			}
		}
		for (i = 0; i <= lnow - 1; ++i)           
		{
			body[i] = &(stage[3][COL - lnow - 1 + i]);
			*(body[i]) = '*';
		}
		*(body[0]) = 'o';
		*food = '@';
	
		system("cls");
		display(stage);
		printf("this is %d level\npress SPACE to start, w s a d for direction\n", level);
	
		while (getch() != ' ')
			;
		
		while (1) 
		{
			for (i = 0; i < ROW; ++i)
			{
				for (j = 0; j < COL; ++j)
				{
					stage[i][j] = ' ';
				}
			}
			temphead = body[0];
			direct = changedir(direct, level);		
			
			for (i = lnow - 1; i >= 2; --i)	
			{
				body[i] = body[i - 1];	
				*(body[i]) = '*';
			}
			if(!changehead(stage, &(body[0]), direct))
			{
				printf("you have died!press ENTER to quit\n");
				fflush(stdin); 
				getchar();
				return 0;
			}	
			body[1] = temphead;
	
			for (i = 3; i <= lnow - 1; ++i)
			{
				if (body[0] == body[i])
				{
					printf("\nyou have died!press ENTER to quit\n");
					fflush(stdin); 
					getchar();
					return 0;
				}
			}		
			if (body[0] == food)
			{
				++lnow;	
				food = &(stage[rand() % (ROW - 2) + 1][rand() % (COL - 2) + 1]);
			}
			for (i = 0; i <= lnow - 1; ++i)
			{
				if (food == body[i])
				{	
					food = &(stage[rand() % (ROW - 2) + 1][rand() % (COL - 2) + 1]);
					i =	-1;
				}
			}
			if (lnow == LMAX)
			{
				++level;
				printf("wow! awesome! you have succeeded! \nnow, press ENTER to go %d level!\n", level);
				fflush(stdin); 
				getchar();
				goto start;
			}
				
			*(body[1]) = '*';
			*(body[0]) = 'o';
			*food = '@';
			
			system("cls");
			display(stage);
		} 
	}	
} 

char changedir(char direct, int level)
{
	char temp;

	if (direct == 'w' || direct == 's')	
	{
		for (i = 0; i < 4000 / level; ++i)
		{
			if (_kbhit())
			{
				if ((temp = getch()) == 'a')
				{
					direct = 'a';
					break;
				}
				else if (temp == 'd')
				{
					direct = 'd';
					break;
				}
			}
		}
	}
	if (direct == 'a' || direct == 'd')	
	{
		for (i = 0; i < 4000 / level; ++i)
		{
			if (_kbhit())
			{
				if ((temp = getch()) == 'w')
				{
					direct = 'w';
					break;
				}
				else if (temp == 's')
				{
					direct = 's';
					break;
				}
			}
		}
	}
	return direct;
}

int changehead(char (*stage)[COL], char **headptr, char direct)
{
		int life = 1;

		switch (direct)	
		{
			case 'w' : *(headptr) = *(headptr) - COL;
					   for (i = 0; i <= COL - 1; ++i)
					   {
						   if (*(headptr) == &(stage[0][i]))
						   {
							   life = 0;
							  
							   return life;
						   }
					   }
					   break;
			case 's' : *(headptr) = *(headptr) + COL; 
					   for (i = 0; i <= COL - 1; ++i)
					   {
						   if (*(headptr) == &(stage[ROW - 1][i]))
						   {
								life = 0;
							
							    return life;
						   }
					   }
					   break;
			case 'a' : *(headptr) = *(headptr) - 1;
					   for (i = 0; i <= COL - 1; ++i)
					   {
						   if (*(headptr) == &(stage[i][0]))
						   {
							   life = 0;
							 
							   return life;
						   }
					   }
					   break;
			case 'd' : *(headptr) = *(headptr) + 1;
					   for (i = 0; i <= COL - 1; ++i)
					   {
						   if (*(headptr) == &(stage[i][COL - 1]))
						   {
							   life = 0;
							 
							   return life;
						   }
					   }
				       break;
		}
}

void display(char (*stage)[COL])
{
	for (i = 0; i < COL; ++i)
	{
		putchar('_');
		putchar(' ');
	}
	putchar('\n');
	for (i = 1; i <= ROW - 2; ++i)	
	{
		putchar('|');
		for (j = 1; j <= COL - 2; ++j)
		{
			putchar(' ');
			putchar(stage[i][j]);
		}
		putchar(' ');
		putchar('|');
		putchar('\n');
	}
	for (i = 0; i < COL; ++i)
	{
		putchar('-');
		putchar(' ');
	}
	putchar('\n');
}