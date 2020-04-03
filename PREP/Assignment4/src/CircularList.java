/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    31.08.2019 13:00
    Creates a circular double linked list to which you can add values after a spe
	cific int or to the start of the list or insert the value in ascending order 
	in a sorted list. There's also a method for printing the
	list to stdout and to remove items from the list
*********************************************************************************/
public class CircularList {

    private Node first; //First node

	
	//creating the base Node
    private static class Node {
        public int value;
        public Node nextNode ;
        public Node prevNode;
    }

	//creates the first Node of the list
    public void firstNode(int number){
        first = new Node();
        first.value = number;
        first.nextNode = first;
        first.prevNode = first;
    }

	//Inserts int in the begining of the list
    public void push(int value){
        Node newNode = first;
        first = new Node();
        first.value = value;
        first.nextNode = newNode;
        first.prevNode = newNode.prevNode;
        newNode.prevNode.nextNode = first;
        newNode.prevNode = first;
    }

	//Inserts int after a specific int
    public void insertAfter(int p, int n){
        Node start = first;
        Node in = new Node();
        in.value = n;
        while(start.value != p){
            start = start.nextNode;

        }
        in.nextNode = start.nextNode;
        in.prevNode = start;
        start.nextNode = in;
        in.nextNode.prevNode = in;
    }

	//Prints list to stdout
    public void printList(){
        Node start = first;
        do{
            System.out.print(start.value + " ");
            start = start.nextNode;
        }while(start != first);
    }

	//Sorts list using bubble sort
    public void sortList(){
        Node start = first;
        Node inner = start;
        int temp;
        do{
            do{
                if (inner.value > inner.nextNode.value) {
                    temp = inner.value;
                    inner.value =  inner.nextNode.value;
                    inner.nextNode.value = temp;
                }
                inner = inner.nextNode;
            }while(inner.nextNode != first);
            inner = first;
            start = start.nextNode;
        }while(start != first);

    }

	//Inserts an int in ascending order in a sorted list
    public void insertSorted(int n){
        sortList();
        Node start = first;
        while(start.value < n && start.nextNode != first){
            start = start.nextNode;
        }
        if(start == first) {
            push(n);
        }
        else if(start.nextNode == first){
            insertAfter(start.value, n);
        }
        else{
            insertAfter(start.prevNode.value, n);
        }
    }

	//Removes int from list
    public void remove(int ref){
        Node start = first;
        while(start.value != ref){
            start = start.nextNode;
        }
        if (start == first){
            start.prevNode.nextNode = start.nextNode;
            start.nextNode.prevNode = start.prevNode;
            first = start.nextNode;
        }
        else {
            start.prevNode.nextNode = start.nextNode;
            start.nextNode.prevNode = start.prevNode;
        }

    }

    public static void main(String[] args){

		//creating a list and printing it
        CircularList circle = new CircularList();
        circle.firstNode(37);
        circle.push(1);
        circle.push(100);
        circle.push(50);
        circle.push(75);
        circle.push(25);
        circle.push(102);
        circle.push(589);
        circle.printList();

		//Testing sort and insert
        circle.insertSorted(600);
        System.out.println();
        circle.printList();

		//Testing remove
        circle.remove(1);
        System.out.println();
         circle.printList();

         //Testing insert after
        circle.insertAfter(25, 24);
        System.out.println();
        circle.printList();




    }



}
