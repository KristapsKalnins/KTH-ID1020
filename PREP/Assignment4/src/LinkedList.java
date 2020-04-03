/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    31.08.2019 13:00
    Creates a stack-like linked list. An int can be pushed and poped from the 
    start of the list and also can be inserted after a specific int. The list can
    be sorted and then an int inserted in ascending order.There's a method for 
    printing the list. as well
*********************************************************************************/
public class LinkedList {

    private Node first; //First node
    private int N; //"Stack counter"

    //Base node
    private static class Node {
        public int value;
        public Node nextNode;
    }

    //Add new node to "top" of list i.e. adds new first node
    public void push(int value){
        Node newNode = first;
        first = new Node();
        first.value = value;
        first.nextNode = newNode;
        N++;
    }

    //Remove first node from "top" of list i.e. removes first node and return the value within that node
    public int pop(){
        int value = first.value;
        first = first.nextNode;
        N--;
        return value;
    }

    //Prints the list
    public void printList(){
        Node start = first;
        while(start != null){
            System.out.print(start.value + " ");
            start = start.nextNode;
        }
    }

    //Inserts int after a given int
    public void insert(int p, int n){
        Node start = first;
        Node in = new Node();
        in.value = n;
        while(start.value != p){
            start = start.nextNode;
        }
        in.nextNode = start.nextNode;
        start.nextNode = in;
    }

    //Sorts list the inserts int in order
    public void insertSorted(int n){
        Node start = first;
        Node inner = start;
        int temp;
        while(start != null){
            while(inner.nextNode != null) {
                if (inner.value > inner.nextNode.value) {
                    temp = inner.value;
                    inner.value =  inner.nextNode.value;
                    inner.nextNode.value = temp;
                }
                inner = inner.nextNode;
            }
         inner = first;
         start = start.nextNode;
        }

        start = first;
        while(start.nextNode.value < n && start.nextNode.nextNode != null){
            start = start.nextNode;
        }

        if(start.nextNode.nextNode == null && start.nextNode.value < n){
            insert(start.nextNode.value, n);
        }
        else if(start.value == first.value){
            push(n);
        }
        else{
            insert(start.value, n);
        }
    }


    public static void main (String[] args){
        //Create lists
        LinkedList list = new LinkedList();
        list.push(7);
        list.push(3);
        list.push(15);
        list.push(1);
        list.push(4);
        list.push(2);
        list.push(489);
        list.push(120);

        //Testing print
        list.printList();

        //Testing insert
        list.insert(3, 25);

        System.out.println();

        list.printList();

        //Tesing sorted insert
        list.insertSorted(0);
        System.out.println();
        list.printList();

        list.insertSorted(6);
        System.out.println();
        list.printList();

        list.insertSorted(1000);
        System.out.println();
        list.printList();

        //Testing pop
        System.out.println();
        System.out.println(list.pop() + ": Poped int");
        list.printList();
    }

}
