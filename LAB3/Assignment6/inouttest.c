#include <stdio.h>

int main(){
    int mainc = 0;
    char c;
    while( (c = getchar()) != EOF){
   // putchar(c);
    if(c == '\n'){
        mainc += 2;
    }
    else{
    mainc++;
    }
    }
    printf("%d", mainc);
}