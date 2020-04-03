/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    29.08.2019 14:39
    Creates an array of a size specified through stdin,
    then takes the inputted size number of elements and stores them in the array
    and outputted to stdout in reverse order
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int main(){
    int nrElements = 0;

    //Read int from stdin and store it in the nrElements variable
    scanf("%d", &nrElements);

    //Creates a pointer, which points to a space in memory, which has been allocated for nrElements amount of integers
    int* array = (int *)malloc(nrElements * sizeof(int));

    //Loop reads in numbers from stdin and increments the "array" pointer
    for(int i = 0; i < nrElements; i++){
        scanf("%d", array + i);
    }

    //Loop prints numbers stored in the addresses pointed to by "array"
    // and decrements the array pointer to output to stdout the same numbers in reverse order
    for(int i = nrElements - 1; i >= 0; i--){
        printf("%d\n", *(array + i));
    }

    //Frees the memory allocated to "array" after it's not needed anymore
    free(array);
    return 0;
}