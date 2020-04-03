import java.util.Iterator;
/*********************************************************************************
 Kristaps Kalniņš TCOMK2
 08.09.2019 12:00
 Generic iterable FIFO queue implemented using a double linked list. Elements are
 inserted in sorted order
 *********************************************************************************/

public class Assignment6 implements Iterable<Integer> {

    private Node first; //First node

    //creating the base Node
    private class Node {
        public int value;
        public Node nextNode ;
        public Node prevNode ;
    }


    public void insertSorted(int value){                //Inserts elements in sorted order
        if(first == null) {                             //if list is empty, creates first node
            Node n = new Node();
            n.value = value;
            n.nextNode = first;
            first = n;
        }
        else if(first.value > value){                   //If "value" is less than first's value, create new first and link to list
            Node n = new Node();
            n.value = value;
            n.nextNode = first;
            first.prevNode = n;
            first = n;
        }
        else{
            Node copy = first;
            while(copy.nextNode != null && copy.nextNode.value < value){
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

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iter = new Iterator<>() {
            Node copy = first;
            @Override
            public boolean hasNext(){return copy != null;}

            @Override
            public Integer next() {
                int value = copy.value;
                copy = copy.nextNode;
                return  value;
            }
        };
        return iter;
    }

    public int removeKth(int k){
        int count = 1;
        Node copy = first;
        while(count++ < k && copy != null){
            copy = copy.nextNode;
        }
        if(copy == first){
            first = first.nextNode;
        }
        else if(copy == null) {
            System.out.println();
            System.out.print("No element with such index -> " + k);
            return -1;
        }
        else {
            copy.prevNode.nextNode = copy.nextNode;
            copy.nextNode.prevNode = copy.prevNode;
        }
        return copy.value;
    }

    public void printList (){
        if(first == null){
            System.out.println();
            System.out.print("Empty queue!");
        }
        else {
            System.out.println();
            for(Integer val : this) {
                System.out.print("["+val + "], ");
            }
        }
    }





    public static void main(String[] args){
        Assignment6 queue = new Assignment6();
        java.util.Random rand = new java.util.Random();
        for(int i = 0; i <= 20; i++){
            int j = rand.nextInt(100);
            queue.insertSorted(j);
            queue.printList();
        }
    }
}
