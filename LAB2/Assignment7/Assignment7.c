/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    16.09.2019 13:00
    Linked list fifo queue in C
*********************************************************************************/
#include <stdio.h>
#include <stdlib.h>

typedef struct x{
    int num;
    struct x *next, *prev;
}node, *nodeP;

nodeP createElem(int value){
    nodeP n = (nodeP) malloc(sizeof(node));
    n->num = value;
    n->next = n->prev = n;
    return n;
}

nodeP createList(void){
    return createElem(-1);
}

void iterate(nodeP first, void (*fun)(nodeP)){
    nodeP temp;

    for(temp = first->next; temp != first; temp = temp->next)
        (*fun)(temp);
}

void insertAfter(nodeP point, nodeP n){
    n->next = point->next;
    n->prev = point;
    n->next->prev = n;
    point->next = n;
}

void printList(nodeP node){
    printf("[%d], ", node->num);
}

void enqueue(nodeP first, nodeP n){
    nodeP temp;
    for(temp = first->next; temp != first && n->num >= temp->num; temp = temp->next);
    insertAfter(temp->prev, n);
    iterate(first, printList);
    printf("\n");
}

nodeP dequeue(nodeP first){
    nodeP out = first;
    first->prev = first->prev->prev;
    first->prev->next = first;
    iterate(first, printList);
    printf("\n");
    return out;

}



int main(){
   nodeP first = createList();
    enqueue(first, createElem(2));
    enqueue(first, createElem(10));
    enqueue(first, createElem(7));
    enqueue(first, createElem(1));
    enqueue(first, createElem(9));
    enqueue(first, createElem(23));
    enqueue(first, createElem(10));
    

    // for(int i = 0; i < 10; i++){
    //     dequeue(first);
    //     iterate(first, printList);
    //      printf("\n");
    // }
}