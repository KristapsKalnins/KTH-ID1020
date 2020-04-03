/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    20.09.2019 10:00
    Mergesort C implementation
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>

int* aux;

void printArray(int* a, int length){                //Prints array
    for(int i = 0; i < length; i++){
        printf("[%d], ", *a);
        a++;
    }
    printf("\n");
}

void merge(int* a, int lo, int mid, int hi){
    int i = lo, j = mid+1;
    for(int k = lo; k<=hi; k++)
        aux[k] = a[k];
    for (int k = lo; k <= hi; k++)
        if      (i > mid)           a[k] = aux[j++];
        else if (j> hi)             a[k] = aux[i++];
        else if (aux[j] < aux[i])   a[k] = aux[j++];
        else                        a[k] = aux[i++];
}

void sort(int* a, int lo, int hi){
    if (hi <= lo) return;
    int mid = lo + (hi - lo)/2;
    sort(a, lo, mid);
    sort(a, mid+1, hi);
    merge(a, lo, mid, hi);
}

int main(){
    int length;
    int cut;
    scanf("%d", &cut); //for compatability
    scanf("%d", &length);

    aux = (int*)malloc(length * sizeof(int));
    int* in = (int*)malloc(length * sizeof(int));

    for(int i = 0; i < length; i++){
        scanf("%d",in + i);
    }

    sort(in, 0, length-1);
    //printArray(in, length);
}