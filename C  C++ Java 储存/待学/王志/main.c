 #include <stdio.h>
#include <stdlib.h>
#include <string.h>


typedef struct
{
	int weight;
	int parent, Lchild, Rchild;
}HTree;


//保存字符及其权重
typedef struct
{
	char character;
	int weight;
}bit;

typedef struct
{
	bit ascii[256];//一个字节256种组合，不解释，从0开始用
	int num;
}ASCII;


//保存压缩文件信息
typedef struct
{
	unsigned char free;
	int size;
}INFO;


void cht();//create huffman tree
void chc();//create huffman code
void thc();//translate huffman code
void complie();
void select();
void weight();
void readfile();
void savefile();
void savebin();
void readbin();
void chartobin();
void bintochar();


int main()
{
	int i;
	int n;//n = charlist.num;
	int w[256] = {0};//权重，初始化为0
	char str[1000];//读入的字符
	char str2[1000];//输出时的字符
	char zip[1000];//保存编码要压缩的编码

	char zip2[1000];//保存从压缩文件读出的编码

	unsigned char bin[200] = {0};//用于保存压缩后的二进制文件

	unsigned char bin2[200] = {0};//保存从二进制文件读出的编码
	char **hc;//char **hc; 配合hc = (char **)malloc(sizeof(char*)*(n+1));等同于char *hc[n+1];
	HTree ht[512];
	ASCII charlist;
	INFO info, info2;//一个是读入，一个是读出


	zip[0] = '\0';//一定要初始化，不说了，全是泪……
	charlist.num = 0;//初始化，字符数置零
	//初始化，权重置零
	for(i=0; i<=255; i++)
		charlist.ascii[i].weight = 0;
	

	printf("打开文件\n");
	
	readfile(str);

	printf("读入的字符是:\n%s\n", str);

	weight(&charlist, str);//求权重
	
	n = charlist.num;//后面的函数都用的是n，偷懒不改了，

	hc = (char **)malloc(sizeof(char*)*(n+1));//这就是typedef char *HCode[n+1];一个由n+1个char指针构成的数组

	//为了代码让代码的改动小一点，把权重复制出来
	for(i=0; i<=charlist.num; i++)
		w[i] = charlist.ascii[i].weight;


	cht(ht, w, n);
	printf("\n####建立哈夫曼树####\n");

	chc(ht, hc ,n);
	printf("\n####创建哈夫曼编码####\n");

	complie(hc, &str, &zip, &charlist);
	printf("\n####对字符进行编码####\n");

//	printf("zip长度: %d\n", strlen(zip));

	chartobin(zip, bin, &info);
	printf("\n####转换为压缩文件####\n");

	savebin(bin, &info);
	printf("\n####保存压缩文件####\n");

	readbin(bin2, &info2);
	printf("\n####读取压缩文件####\n");

	bintochar(bin2, zip2, &info2);
	printf("\n####还原压缩文件####\n");
	
	thc(ht, str2, &zip2, n, &charlist);
	printf("\n####译码完成####\n");

	printf("还原的字符是:\n%s\n", str2);

	savefile(str2);
	printf("\n####保存文件####\n");

//	printf("%s\n", zip);

/*	for(i=0; i<n; i++)
	{
		printf("字符:%c 权重:%d 编码:%s\n", charlist.ascii[i].character, charlist.ascii[i].weight, hc[i+1]);
	}*/

//	printf("%d",hc[1]);
	return 0;
}


//求权重，
//char *str,输入的字符串
void weight(ASCII *p, char *str)
{
	int i, j;
	int sign;
	for(i=0; str[i] != '\0'; i++)//扫描字符串，效率低
	{
		for(j=0; j <= p->num; j++)
		{
			if(p->ascii[j].character != str[i])//遇到新的标记一下
				sign = 0;
			else//有重复的就跳出
			{
				sign = 1;
				break;
			}
		}

		if(sign == 0)
		{
			p->ascii[p->num].character = str[i];//新添字符
			sign = 0;
			p->ascii[p->num].weight++;//权重++
			p->num++;//字符组长度++
		}
		else
		{
			p->ascii[j].weight++;//权重++
			sign = 0;
		}
	}
}


/*
//min1为最小，min2为次小，输出顺序与书上略有不同，
//书上的select按顺序来的，可能出现min2为次小，min1为次小的情况
//这个函数有重大bug，明天继续！！！！
void select(HTree *ht, int p, int* min1, int* min2)
{
	int max = 2147483647;//这货是int的最大值
	int i;
	i = 1;
	*min1=1;
	*min2=1;

	//两次循环，从大往小找
	//找最小
	for(i=1; i<=p; i++)
	{
		//if(ht[i].parent == 0 && ht[i].weight <= max)//注意<=与<的区别
		if(ht[i].parent == 0 && ht[i].weight < max)
		{
			max = ht[i].weight;//找到最小值
			*min1 = i;//下标也要改
		}
	}
	printf("序号：%d 权重：%d\n", *min1, ht[*min1].weight);


	//找次小
	max = 2147483647;//这货是int的最大值
	for(i=1; i<=p; i++)
	{
	//	if(ht[i].parent == 0 && ht[i].weight <= max && ht[i].weight != ht[*min1].weight)
	//	if(ht[i].parent == 0 && ht[i].weight < max && ht[i].weight != ht[*min1].weight)
	//	if(i == *min1 && ht[i].weight != ht[*min1].weight)
		if(i == *min1)
			i++;
		if(ht[i].parent == 0 && ht[i].weight < max)
		{
			max = ht[i].weight;//找到最小值
			*min2 = i;//下标也要改
		}
	}
	printf("序号：%d 权重：%d\n\n", *min2, ht[*min2].weight);
}*/


void select(HTree *ht, int p, int* min1, int* min2)
{
	int max = 2147483647;//这货是int的最大值
	int m1, m2;
	int i;

	m1 = max;
	m2 = max;
	
	i = 1;
	*min1=1;//这两个是要返回的下标
	*min2=1;

	//一遍扫描即可找出最小次小值
	for(i=1; i<=p; i++)
	{
		if(ht[i].parent == 0 && ht[i].weight < m1)
		{
			*min2 = *min1;
			m2 = m1;
			*min1 = i;
			m1 = ht[i].weight;
		}
		else if(ht[i].weight < m2 && ht[i].parent == 0)
		{
			*min2 = i;
			m2 = ht[i].weight;
		}
	}

//	printf("序号：%d 权重：%d\n", *min1, ht[*min1].weight);
//	printf("序号：%d 权重：%d\n\n", *min2, ht[*min2].weight);
}



void cht(HTree *ht, int *w, int n)
{
	int i, m;
	int s1, s2;
	m = 2*n-1;

	//初始化
	for(i=1; i<=n; i++)
	{
		ht[i].weight = w[i-1];//权重是从0下标开始的
		ht[i].parent = 0;
		ht[i].Lchild = 0;
		ht[i].Rchild = 0;
	}
	for(i=n+1; i<=m; i++)
	{
		ht[i].weight = w[i-1];
		ht[i].parent = 0;
		ht[i].Lchild = 0;
		ht[i].Rchild = 0;
	}

	for(i=n+1; i<=m; i++)
	{
		select(ht, i-1, &s1, &s2);
		ht[i].weight = ht[s1].weight + ht[s2].weight;
		ht[i].Lchild = s1;
		ht[i].Rchild = s2;
		ht[s1].parent = i;
		ht[s2].parent = i;
	}
/*
	for(i=1; i<=m; i++)
	{
		printf("序号:%d ",i);
		printf("权重:%d ",ht[i].weight);
		printf("双亲:%d ",ht[i].parent);
		printf("左孩:%d ",ht[i].Lchild);
		printf("右孩:%d\n",ht[i].Rchild);
	}*/
}


void chc(HTree *ht, char** hc, int n)//小心**
{
	char *cd;
	int start;
	int i, c, p;
	cd = (char *)malloc(sizeof(char)*n);
	cd[n-1] = '\0';
	for(i=1; i<=n; i++)
	{
		start = n-1;
		c = i;
		p = ht[i].parent;
		while(p != 0)
		{
			--start;
			if(ht[p].Lchild == c)
				cd[start] = '0';
			else
				cd[start] = '1';
			c = p;
			p = ht[p].parent;
		}
		hc[i] = (char *)malloc((n - start) * sizeof(char));

		strcpy(hc[i], &cd[start]);//把cd复制到hc，经常把顺序弄烦了，汗……
	//	printf("## %s ##\n", hc[i]);
	}
//	for(i=1; i<=n; i++)
//		printf("## %s ##\n", hc[i]);
	free(cd);
}

//译码
//zip编码后的文件保存在这个字符串里
void thc(HTree *ht, char* str, char* zip, int n, ASCII *c)
{
	int i, p, x;
	i = 0;//从字符组的头开始译码
	p = 2*n-1;//准备从双亲结点开始找
	x = 0;

	while(zip[i] != '\0')
	{
		//读0为左
		if(zip[i] == '0')
		{
			p = ht[p].Lchild;
			if(ht[p].Lchild == 0 || ht[p].Rchild == 0)//读到叶子结点则输出，然后从头再来
			{
				str[x] = c->ascii[p-1].character;//哈夫曼树是从1开始，我的字符组是从0开始，所以要-1
				p = 2*n-1;//从头再来
				x++;
			}
		}

		//读1为右
		else if(zip[i] == '1')
		{
			p = ht[p].Rchild;
			if(ht[p].Lchild == 0 || ht[p].Rchild == 0)//读到叶子结点则输出，然后从头再来
			{
				str[x] = c->ascii[p-1].character;//哈夫曼树是从1开始，我的字符组是从0开始，所以要-1
				p = 2*n-1;//从头再来
				x++;
			}
		}
		i++;
	}
	str[x] = '\0';//字符串最后添个结束符

	//printf("%s",str);
	//printf("\n");
}


void complie(char** hc, char* str, char* zip, ASCII* p)
{
	int i=0, j, len;
	len = strlen(str);
	//printf("$$ %d $$", len);
	//while(str[i] != '\0')
	while(i != len)
	{
		for(j=0; j<=p->num; j++)
		{
			if(str[i] == p->ascii[j].character)
			{
				strcat(zip, hc[j+1]);//把hc连接在zip后面，我的字符是从0开始的，哈夫曼编码是从1开始的，所以要加1，还有那个强制类型转换，注意！！
				break;//找到后就退出，能提高一点效率
			}
		}
		i++;
	}
}

void readfile(char* str)
{
	FILE *fp;
	int i;
	i=0;
	
	if((fp = fopen("text.txt","rb")) == NULL)
	{
		printf("文件不存在\n");
		return;
	}

	while(!feof(fp))//文件没结束就一直读
	{
		str[i] = fgetc(fp);//读一个字符，fp指针自动后移
		if(feof(fp))//读了一个字符之后如果文件结束，把最后一个字符改成\0
		{
			str[i] = '\0';
		}
		i++;
	}

	fclose(fp);
}

void savebin(unsigned char* bin, INFO *p)
{
	FILE *fp;
	int i;
	i=0;
	
	if((fp = fopen("yasuo.bin","wb")) == NULL)
	{
		printf("创建文件失败\n");
		return;
	}

	fwrite(&p->size,4,1,fp);//前四个字节保存压缩文件长度p->size
	fwrite(&p->free,1,1,fp);//第五个字节保存文件最后一字节补0的个数

	for(i=0; i<p->size; i++)//从第6字节开始保存压缩文件
	{
		fwrite(&bin[i],1,1,fp);
	}
	fclose(fp);
}


void chartobin(char* zip, unsigned char* bin, INFO *p)
{
	unsigned char tmp;
	int i, j;
	
	p->size = strlen(zip)/8;//整数字节的长度

//	printf("size: %d\n", p->size);

	for(j=0; j<p->size; j++)//先保存整数字节
	{
		for(i=j*8; i<(j+1)*8; i++)//单片机玩多了，位操作小意思
		{
			if(zip[i] == '0')
			{
				tmp = (tmp<<1)|0x00;
			}
			if(zip[i] == '1')
			{
				tmp = (tmp<<1)|0x01;
			}
		}

		bin[j] = tmp;//每凑够一字节，就保存
	}
	
	p->free = 8 - (strlen(zip)%8);//文件尾补零的个数
	if(p->free == 8)//不解释
		p->free = 0;

//	printf("free: %d\n", p->free);

	if(p->free)//保存最后补全的一字节
	{
		for(j=0; j<8 - (p->free); j++)//先保存最后面多出来的那几位
		{
			if(zip[p->size * 8 + j] == '0')
			{
				tmp = (tmp<<1)|0x00;
			}
			if(zip[p->size * 8 + j] == '1')
			{
				tmp = (tmp<<1)|0x01;
			}
		}

		for(j=8 - (p->free); j<8; j++)//其余位补0
			//tmp = (tmp<<1)|0x00;
			tmp = (tmp<<1);
		bin[p->size] = tmp;//数组的size是实际size-1
		p->size++;//所以这里size++才是真实size
	}

//	printf("free: %d\n", p->free);


/*	printf("\n\n重头戏来了\n\n");

	for(i=0; i<p->size; i++)
	{
		printf("%x ", bin[i]);
	}
*/
//	printf("\n\n测试标志1\n\n");
//	printf("size: %d\n", size);
}

void bintochar(unsigned char* bin, char* zip, INFO *p)
{
	unsigned char tmp, save;
	int n,j,i;
	n=0;

	for(j=0; j<p->size; j++)//开始译码
	{
		tmp = bin[j];//先复制一下

		for(i=0; i<8; i++)//位操作，电脑不像单片机有CY位，所以就与0x80进行与运算来代替读取CY位
		{
			save = tmp & 0x80;

			if(save == 0x00)
				zip[n] = '0';
			if(save == 0x80)//0x80 = 1000 0000
				zip[n] = '1';

			tmp = tmp<<1;
			n++;
		}
	}

	zip[p->size*8 - p->free] = '\0';//除去最后一字节多补的0
//	printf("strlen 2: %d\n", strlen(zip));
}

void readbin(unsigned char* bin, INFO *p)
{
	FILE *fp;
	int i;
	i=0;
	
	if((fp = fopen("yasuo.bin","rb")) == NULL)
	{
		printf("创建文件失败\n");
		return;
	}

	fread(&p->size,4,1,fp);//前四个字节保存压缩文件长度
	fread(&p->free,1,1,fp);//第五个字节保存文件最后一字节补0的个数

	for(i=0; i<p->size; i++)//从第6字节开始保存压缩文件
	{
		fread(&bin[i],1,1,fp);
	}
	fclose(fp);
}

void savefile(char* str)
{
	FILE *fp;
	int i;
	i=0;
	
	if((fp = fopen("output.txt","wb")) == NULL)
	{
		printf("文件不存在\n");
		return;
	}

	while(str[i] != '\0')//字符串没结束就一直存
	{
		fputc(str[i],fp);
		i++;
	}

	fclose(fp);
}