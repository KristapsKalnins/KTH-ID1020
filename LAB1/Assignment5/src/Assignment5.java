/*********************************************************************************
 Kristaps Kalniņš TCOMK2
 07.09.2019 18:00
 Generic iterable FIFO queue implemented using a double linked list. The k-th
 element of the queue can be removed
 *********************************************************************************/
import java.util.Iterator;

public class Assignment5<E extends Comparable<E>> implements Iterable<E>  {


        private Node first = null; //First node

        //creating the base Node
        private class Node {
            public E value;
            public Node nextNode ;
            public Node prevNode ;
        }


        public void enqueue(E value){
            Node n = new Node();
            n.value = value;
            n.nextNode = first;
            if(first != null){
                first.prevNode = n;
            }
            first = n;
        }

        @Override
        public Iterator<E> iterator() {
            Iterator<E> iter = new Iterator<E>() {
                Node copy = first;
                @Override
                public boolean hasNext(){return copy != null;}

                @Override
                public E next() {
                    E value = copy.value;
                    copy = copy.nextNode;
                    return  value;
                }
            };
            return iter;
        }

        public E removeKth(int k){                  //Loops through list to find element and then removes it
            int count = 1;
            Node copy = first;
           while(count++ < k && copy != null){
                copy = copy.nextNode;
           }
            if(copy == first){                      //Special case if k = 1
                first = first.nextNode;
            }
            else if(copy == null) {
                System.out.println();
                System.out.print("No element with such index -> " + k);
                return null;
            }
            else {
                copy.prevNode.nextNode = copy.nextNode;
                copy.nextNode.prevNode = copy.prevNode;
            }
            return copy.value;
        }

        private boolean isLess(E one, E two){
            int cmp = one.compareTo(two);
            if (cmp < 0){ return true;}
            else return false;
        }

    private boolean isMore(E one, E two){
        int cmp = one.compareTo(two);
        if (cmp > 0){ return true;}
        else return false;
    }

    private boolean isEqualTo(E one, E two){
        int cmp = one.compareTo(two);
        if (cmp == 0){ return true;}
        else return false;
    }


    public void insertSorted(E value){                //Inserts elements in sorted order
        if(first == null) {                             //if list is empty, creates first node
            Node n = new Node();
            n.value = value;
            n.nextNode = first;
            first = n;
        }
        else if(isMore(first.value, value)){                   //If "value" is less than first's value, create new first and link to list
            Node n = new Node();
            n.value = value;
            n.nextNode = first;
            first.prevNode = n;
            first = n;
        }
        else{
            Node copy = first;
            while(copy.nextNode != null && isLess(copy.nextNode.value, value)){
                copy = copy.nextNode;
            }
            if(copy.nextNode == null){                  //Case for "value" being the largest value
                Node n = new Node();
                n.value = value;
                n.prevNode = copy;
                copy.nextNode = n;
            }
            else{
                Node n = new Node();                    //Case for "value" being in the middle of the list
                n.value = value;
                n.nextNode = copy.nextNode;
                n.prevNode = copy;
                copy.nextNode.prevNode = n;
                copy.nextNode = n;
            }

        }
    }





        public E dequeue(){
            Node copy = first;
            while (copy.nextNode != null) {
                copy = copy.nextNode;
            }
            E out = copy.value;
            if(copy.prevNode == null){ //End case for first
                first = null;
                return out;
            }
            else{
                copy.prevNode.nextNode = null;
            }
            return out;
        }

        public void printList (){
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
            Assignment5<Integer> queue = new Assignment5<>();
            for(int i = 0; i < 10; i++){
                queue.enqueue(i);
                queue.printList();
            }

            queue.removeKth(1);
            queue.printList();
            queue.removeKth(2);
            queue.printList();
            queue.removeKth(3);
            queue.printList();
            queue.removeKth(4);
            queue.printList();
            queue.removeKth(20);
            queue.printList();
            queue.removeKth(5);
            queue.printList();


            System.out.println();
            System.out.println();
            Assignment5<Integer> sort = new Assignment5<>();
            java.util.Random rand = new java.util.Random();
            for(int i = 0; i <= 20; i++){
                int j = rand.nextInt(100);
                sort.insertSorted(j);
                sort.printList();
            }
        }
    }