#include "load_so.h"
#include <dlfcn.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
int do_test_so_func(int a,int b)
{
    printf("do_test_so_func is called!\n");
    void* handle;
    typedef int (*FPTR)(int,int);

    handle = dlopen("./test_so.so", 1);
    FPTR fptr = (FPTR)dlsym(handle, "test_so_func");

    int result = (*fptr)(a,b);
    return result;
}