/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    12.09.2019 11:00
    Group integers by sign
    6. For every outer loop the elements in the array which have index that's
    lower than 'i' or index higher than'pos' are negative or positive respectively
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>


void printArray(int* a, int length){                //Prints array
    for(int i = 0; i < length; i++){
        printf("[%d], ", *a);
        a++;
    }
    printf("\n");
}

void signGroup(int* a, int length){
    int pos = length - 1;
    int temp;
    for(int i = 0; i < length; i++){

        if(i == pos){
            int zeroInd = 0;
            for(int j = 0; j < length; j++){
                if(a[j] == 0){
                    zeroInd = j;
                    a[j] = a[i];
                    a[i] = 0;
                    i++;
                }
            }
            break;
        }
        
        else if(a[i] >= 0){
            while(a[pos] >= 0){             //fixes [1;2;3;5;-6] case
                pos--;
            }
            temp = a[pos];
            a[pos] = a[i];
            a[i]  = temp;
            printArray(a, length);
        }
    }    
}

int main(){
    int length;
    scanf("%d", &length);

    int* in = (int*)malloc(length * sizeof(int));

    for(int i = 0; i < length; i++){
        scanf("%d",in + i);
    }

    signGroup(in, length);
    printArray(in, length);
    
}