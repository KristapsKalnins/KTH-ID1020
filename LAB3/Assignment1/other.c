#include <stdio.h>
#include <ctype.h>

void alphaCheck(){
    char c;
    while((c=getchar()) != EOF){
        if(!isalpha(c) && c != '-')
            putchar(' ');
        else
            putchar(c);
    }
}

int main(){
    alphaCheck();
}