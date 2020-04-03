/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    10.09.2019 11:00
    1. Insertion sort implementation in C
    2. Sort in descending order
    3. Prints the number of swaps
    4. Prints the array inversions and counts them
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int swaps = 0;                                      //3.Global var for swap counter

void printArray(int* a, int length){                //Prints array
    for(int i = 0; i < length; i++){
        printf("[");
        printf("%d", *a);
        printf("], ");
        a++;
    }
    printf("\n");
}


int inversionCount(int* a, int length){             //4.Counts the number of inversions needed tp sort the array
    int inver = 0;
    for(int i = 0; i < length; i++){
        for(int j = 1; j < length ; j++){
            if(i < j && a[i] > a [j]){
                printf("[%d,%d], [%d,%d]\n",i, a[i], j, a[j]);
                inver++;
            }
        }
    }
    return inver;
}

void insertionSort(int*a, int length){              //1.Sorts array with insertion sort
int tmp;
for(int i = 1; i < length; i++){
    for(int j = i; (j > 0 && a[j] < a[j-1]); j--){
        tmp = a[j];
        a[j] = a[j-1];
        a[j-1] = tmp;
        swaps++;
        printArray(a, length);
        }
    }
}





int main(){
    int length;

    printf("How many ints are in the array?\n");
    scanf("%d", &length);

    int* in = (int*)malloc(length * sizeof(int));

    for(int i = 0; i < length; i++){
        scanf("%d",in + i);
    }
    
    // for(int i = 0; i < length; i++){                //2.Multiply all the values by -1
    //     *(in+i) = *(in+i) * -1;
    // }
    
    printf("Number of inversions: %d\n",inversionCount(in, length)); //4.Prints inversion count and the inversions

    insertionSort(in, length);

    printf("\nNumber of swaps: %d\n\n",swaps);     //3.Prints the number of swaps

    // for(int i = 0; i < length; i++){               //Multiply all by -1 again to get the descending order
    //     *(in+i) = *(in+i) * -1;
    // }

    //printf("Array in descending order:\n");
    printArray(in, length);                         
  
    return 0;
}