import java.util.Iterator;
/*********************************************************************************
 Kristaps Kalniņš TCOMK2
 07.09.2019 17:00
 Generic iterable FIFO circular doubly linked list. Elements can be added and
 removed form the start and the begining of the list;
 *********************************************************************************/
public class Assignment4<E> implements Iterable<E>{
    private Node first; //First node

    //creating the base Node
    private class Node {
        public E value;
        public Node nextNode ;
        public Node prevNode ;
    }


    public void insertFirst(E value){                   //Inserts value as first in the list
        if(first == null){
            first = new Node();
            first.nextNode = new Node();
            first.nextNode.value = value;
            first.nextNode.nextNode = first;
            first.nextNode.prevNode = first;
            first.prevNode = first.nextNode;
        }
        else {
            Node n = first.nextNode;
            first.nextNode = new Node();
            first.nextNode.value = value;
            first.nextNode.nextNode = n;
            first.nextNode.prevNode = n.prevNode;
            n.prevNode.nextNode = first.nextNode;
            n.prevNode = first.nextNode;
        }
    }

    public void insertLast(E value){                    //Inserts value as last in the list
        if(first == null){
            first = new Node();
            first.nextNode = new Node();
            first.nextNode.value = value;
            first.nextNode.nextNode = first;
            first.nextNode.prevNode = first;
            first.prevNode = first.nextNode;
        }
        else {
            Node n = new Node();
            n.value = value;
            n.nextNode = first;
            n.prevNode = first.prevNode;
            first.prevNode.nextNode = n;
            first.prevNode = n;
        }
    }

    @Override
    public Iterator<E> iterator() {                 //Same iterator as in assignment 3
        Iterator<E> iter = new Iterator<E>() {
            Node copy = first.nextNode;
            @Override
            public boolean hasNext(){
                return (copy != first);
            }

            @Override
            public E next() {
                E value = copy.value;
                copy = copy.nextNode;
                return  value;
            }
        };
        return iter;
    }


    public E removeFirst(){                         //Removes first elements
        E out = first.nextNode.value;
        first.nextNode = first.nextNode.nextNode;
        first.nextNode.prevNode = first;
        return out;
    }
    public E removeLast(){                          //Removes last element
        E out = first.prevNode.value;
        first.prevNode = first.prevNode.prevNode;
        first.prevNode.nextNode = first;
        return out;
    }


    public void printList (){                       //Prints list(Same as asignment 3)
        if(first == first.nextNode){
            System.out.println();
            System.out.print("Empty list!");
        }
        else {
            System.out.println();
            for(E val : this) {
                System.out.print("["+val + "], ");
            }
        }
    }




    public static void main(String[] args){
        Assignment4<Integer> queue = new Assignment4<>();
        for(int i = 0; i < 10; i++){                //Creates list
            queue.insertLast(i);
            queue.insertFirst(i);
            queue.printList();
        }
        System.out.println();
        for(int i = 0; i < 10; i++){                //Testing removeFirst and removeLast      
            if(i % 2 == 0) {
                queue.removeFirst();
            }
            else{
                queue.removeLast();
            }
            queue.printList();
        }


    }
}
