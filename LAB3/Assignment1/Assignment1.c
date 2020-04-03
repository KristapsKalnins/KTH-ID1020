/*****************************************************************
 *          TCOMK2  Kristaps Kalniņš
 * C program which reads from stdin and prints only the
 * alphabetical chars, replacing all other chars with a ' ' char.
 * **************************************************************/
#include <stdio.h>
#include <ctype.h>

void alphaCheck(){
    char c;
    while((c=getchar()) != EOF){
        if(!isalpha(c))
            putchar(' ');
        else
            putchar(c);
    }
}

int main(){
    alphaCheck();
}