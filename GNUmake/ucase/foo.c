#include <stdio.h>

#define toString(X) toString2(X)
#define toString2(X) #X

int main(void)
{
    printf("FILE: " toString(FILE) "\n");
    return 0;
}
