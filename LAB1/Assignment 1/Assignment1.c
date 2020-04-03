/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    04.09.2019 13:41
    Two different impelementations of a program that prints out a char string
    backwards.
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>


void printReverseRec(){
    char in;
    if((in = getchar()) != '\n')    //Reads in char and if it's not a new line char calls itself again
        printReverseRec();
    putchar(in);                    //Recursivly prints chars in reverse order
}

void printReverseIter(){
    char* array = malloc(10 * sizeof(char));    //Allocate space in memory for 10 chars
    char* copy = array;                         //Copy array pointer

    while((*array = getchar()) != '\n')         //While stdin is not '\n' write to address specified by the "array" pointer and increment after each write
        array++;

    while(array != copy && putchar(*--array));  //Whille the array pointer hasn't returned to the starting value, print char to stdout and decrement pointer

    free(array);                                //Free allocated space
}

int main(){
    printReverseRec();
    putchar('\n');
    printReverseIter();
    return 0;
}