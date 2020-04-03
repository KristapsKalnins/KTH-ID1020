import java.util.Iterator;
/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    05.09.2019 18:00
    Generic iterable FIFO queue implemented using a double linked list.
*********************************************************************************/
class Assignment3<E> implements Iterable<E> {

    private Node first = null;                                  //First node

    private class Node {                                        //creating the base Node
        public E value;
        public Node nextNode ;
        public Node prevNode ;
    }

	
    public void enqueue(E value){                               //Enqueue objects to start of queue by updating first
        Node n = new Node();
        n.value = value;
        n.nextNode = first;
        if(first != null){
            first.prevNode = n;
        }
        first = n;
    }

    @Override
    public Iterator<E> iterator() {                             //Iterator for iterating through the queue
        Iterator<E> iter = new Iterator<E>() {
            Node copy = first;
            @Override
            public boolean hasNext(){return copy != null;}      //Checks if the iterator has gone of the linked list

            @Override
            public E next() {                                   //After checking hasNext() return value of node and move on to the next one
                E value = copy.value;
                copy = copy.nextNode;
                return  value;
            }
        };
        return iter;
    }

    public E dequeue(){                                         //Dequeues last object of queue and returns it's value
            Node copy = first;
            while (copy.nextNode != null) {
                copy = copy.nextNode;
            }
            E out = copy.value;
            if(copy.prevNode == null){                          //End case when there's only one object left in the queue
                first = null;
                return out;
            }
            else{
                copy.prevNode.nextNode = null;
            }
            return out;
    }

    public void printList (){                                   //Prints list with a for each loop, prints "Empty queue" if the queue is empty.
        if(first == null){
            System.out.println();
            System.out.print("Empty queue!");
        }
        else {
            System.out.println();
            for(E val : this) {
                System.out.print("["+val + "], ");
            }
        }
    }

   


    public static void main(String[] args){
        Assignment3<Integer> queue = new Assignment3<>();
       for(int i = 0; i < 50; i++){                         //Enqueueing 50 integers
           queue.enqueue(i);
           queue.printList();
       }


        for(int i = 0; i < 50; i++){                        //Dequeueing 50 integers
            queue.dequeue();
            queue.printList();
        }
    }
}