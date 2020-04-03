/*
    Kristaps Kalniņš TCOMK2
    28.08.2019 13:31
    Reads chars from stdin and if the char ir an 'a', changes
    it to 'X', else outputs the same char unchanged
    Takes input either from the terminal or a file(stdin)
*/
#include <stdio.h>

int main(){
    char in;
    //Gets chars while not end of file
    while((in = getchar()) != EOF){
        //inserts chars replacing 'a' with 'X'
       if (in == 'a'){
           putchar('X');
       }
       else{
           putchar(in);
       }
    }
    return 0;
}