#include "test_so.h"
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
//gcc -fPIC -shared ./test_so.c -o test_so.so
int test_so_func(int a,int b)
{
    printf("test_so_func is called!\n");
    return a*b;
}