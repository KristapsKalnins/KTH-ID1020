/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    20.09.2019 10:00
    Quicksort C implementation
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

void exchange(int* a, int i, int j){
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}

void insertionSort(int*a, int hi, int lo){              //1.Sorts array with insertion sort
int tmp;
for(int i = lo; i <= hi; i++){
    for(int j = i; (j > 0 && a[j] < a[j-1]); j--){
	exchange(a, j, j-1);
        }
    }
}



void sort(int* a, int lo, int hi, int cut){
  if((hi - lo) <= cut){
    insertionSort(a, hi, lo);
    return;
  }
  else{
    if(hi <= lo) return;
    int lt = lo, i = lo+1, gt = hi;
    int v = a[lo];
    while(i <= gt){
        if(a[i] < v)        exchange(a, lt++, i++);
        else if(a[i] > v)   exchange(a, i, gt--);
        else                i++;
    }
    sort(a, lo, lt-1, cut);
    sort(a, gt+1, hi, cut);
  }
}

int main(){
    int length;
    int cut;
    scanf("%d", &cut);
    scanf("%d", &length);

    int* in = (int*)malloc(length * sizeof(int));

    for(int i = 0; i < length; i++){
        scanf("%d",in + i);
    }

    sort(in, 0, length-1, cut);
    //printArray(in, length);
}
