///*********************************************************************************
// Kristaps Kalniņš TCOMK2
// 07.09.2019 18:00
// Generic iterable FIFO queue implemented using a double linked list. The k-th
// element of the queue can be removed
// *********************************************************************************/
//import java.util.Iterator;
//
//public class MinPQ<Key ,E extends Comparable<E>> implements Iterable<E>  {
//
//
//        public Node first = null; //First node
//
//        //creating the base Node
//        private class Node {
//            public E value;
//            public Key Key;
//            public Node nextNode ;
//            public Node prevNode ;
//        }
//
//
//        public void enqueue(Key key, E value){
//            Node n = new Node();
//            n.value = value;
//            n.Key = key;
//            n.nextNode = first;
//            if(first != null){
//                first.prevNode = n;
//            }
//            first = n;
//        }
//
//        public boolean contains(Key key){
//            int found = 0;
//            if(first == null) return false;
//            Node copy = first;
//            while(copy.nextNode != null){
//                if(copy.Key == key){
//                    found++;
//                    break;
//                }
//                copy = copy.nextNode;
//            }
//            if(found != 0) return true;
//            else           return false;
//        }
//
//        @Override
//        public Iterator<E> iterator() {
//            Iterator<E> iter = new Iterator<E>() {
//                Node copy = first;
//                @Override
//                public boolean hasNext(){return copy != null;}
//
//                @Override
//                public E next() {
//                    E value = copy.value;
//                    copy = copy.nextNode;
//                    return  value;
//                }
//            };
//            return iter;
//        }
//
//    public boolean isEmpty(){ return first == null;}
//
//        public E removeKth(int k){                  //Loops through list to find element and then removes it
//            int count = 1;
//            Node copy = first;
//           while(count++ < k && copy != null){
//                copy = copy.nextNode;
//           }
//            if(copy == first){                      //Special case if k = 1
//                first = first.nextNode;
//            }
//            else if(copy == null) {
//                System.out.println();
//                System.out.print("No element with such index -> " + k);
//                return null;
//            }
//            else {
//                copy.prevNode.nextNode = copy.nextNode;
//                copy.nextNode.prevNode = copy.prevNode;
//            }
//            return copy.value;
//        }
//
//        private boolean isLess(E one, E two){
//            int cmp = one.compareTo(two);
//            if (cmp < 0){ return true;}
//            else return false;
//        }
//
//    private boolean isMore(E one, E two){
//        int cmp = one.compareTo(two);
//        if (cmp > 0){ return true;}
//        else return false;
//    }
//
//    private boolean isEqualTo(E one, E two){
//        int cmp = one.compareTo(two);
//        if (cmp == 0){ return true;}
//        else return false;
//    }
//
//    public void change(Key key, E value){
//            Node copy = first;
//            while(copy.Key != key){
//                copy = copy.nextNode;
//                }
//            copy.value = value;
//        }
//
//
//
//    public void insertSorted(Key key, E value){                //Inserts elements in sorted order
//        if(first == null) {                             //if list is empty, creates first node
//            Node n = new Node();
//            n.value = value;
//            n.Key = key;
//            n.nextNode = first;
//            first = n;
//        }
//        else if(isMore(first.value, value)){                   //If "value" is less than first's value, create new first and link to list
//            Node n = new Node();
//            n.value = value;
//            n.Key = key;
//            n.nextNode = first;
//            first.prevNode = n;
//            first = n;
//        }
//        else{
//            Node copy = first;
//            while(copy.nextNode != null && isLess(copy.nextNode.value, value)){
//                copy = copy.nextNode;
//            }
//            if(copy.nextNode == null){                  //Case for "value" being the largest value
//                Node n = new Node();
//                n.value = value;
//                n.Key = key;
//                n.prevNode = copy;
//                copy.nextNode = n;
//            }
//            else{
//                Node n = new Node();                    //Case for "value" being in the middle of the list
//                n.value = value;
//                n.Key = key;
//                n.nextNode = copy.nextNode;
//                n.prevNode = copy;
//                copy.nextNode.prevNode = n;
//                copy.nextNode = n;
//            }
//
//        }
//    }
//
//
//
//
//
//        public Key dequeue(){
//            Node copy = first;
//            while (copy.nextNode != null) {
//                copy = copy.nextNode;
//            }
//            Key out = copy.Key;
//            if(copy.prevNode == null){ //End case for first
//                first = null;
//                return out;
//            }
//            else{
//                copy.prevNode.nextNode = null;
//            }
//            return out;
//        }
//
//        public void printList (){
//            if(first == null){
//                System.out.println();
//                System.out.print("Empty queue!");
//            }
//            else {
//                System.out.println();
//                for(E val : this) {
//                    System.out.print("["+val + "], ");
//                }
//            }
//        }
//    }








/*********************************************************************************
 Kristaps Kalniņš TCOMK2
 07.09.2019 18:00
 Generic iterable FIFO queue implemented using a double linked list. The k-th
 element of the queue can be removed
 *********************************************************************************/
import java.util.Iterator;
import java.util.Random;

public class MinPQ<Key ,E extends Comparable<E>> implements Iterable<E>  {


    public Node first = null; //First node

    //creating the base Node
    private class Node {
        public E value;
        public Key Key;
        public Node nextNode ;
        public Node prevNode ;
    }


    public void enqueue(Key key, E value){
        Node n = new Node();
        n.value = value;
        n.Key = key;
        n.nextNode = first;
        if(first != null){
            first.prevNode = n;
        }
        first = n;
    }

    public boolean contains(Key key){
        int found = 0;
        if(first == null) return false;
        Node copy = first;
        while(copy != null){
            if(copy.Key == key){
                found++;
                break;
            }
            copy = copy.nextNode;
        }
        if(found != 0) return true;
        else           return false;
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

    public boolean isEmpty(){ return first == null;}

    public Key removeKth(int k){                  //Loops through list to find element and then removes it
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
        return copy.Key;
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

    public void change(Key key, E value){
        Node copy = first;
        while(copy.Key != key){
            copy = copy.nextNode;
        }
        copy.value = value;
    }



    public void insertSorted(Key key, E value){                //Inserts elements in sorted order
        if(first == null) {                             //if list is empty, creates first node
            Node n = new Node();
            n.value = value;
            n.Key = key;
            n.nextNode = first;
            first = n;
        }
        else if(isMore(first.value, value)){                   //If "value" is less than first's value, create new first and link to list
            Node n = new Node();
            n.value = value;
            n.Key = key;
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
                n.Key = key;
                n.prevNode = copy;
                copy.nextNode = n;
            }
            else{
                Node n = new Node();                    //Case for "value" being in the middle of the list
                n.value = value;
                n.Key = key;
                n.nextNode = copy.nextNode;
                n.prevNode = copy;
                copy.nextNode.prevNode = n;
                copy.nextNode = n;
            }

        }
    }





//        public Key dequeue(){
//            Node copy = first;
//            while (copy.nextNode != null) {
//                copy = copy.nextNode;
//            }
//            Key out = copy.Key;
//            if(copy.prevNode == null){ //End case for first
//                first = null;
//                return out;
//            }
//            else{
//                copy.prevNode.nextNode = null;
//            }
//            return out;
//        }



    public Key dequeue(){
        return removeKth(1);
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
        MinPQ<Integer, Integer> pq = new MinPQ<>();
        for(int i = 0; i <= 20; i++){
            java.util.Random rand = new Random();
            pq.insertSorted(i, i);
            pq.printList();
        }
        System.out.println();
        pq.change(0, 20);
        pq.printList();
        pq.change(1,20);
        pq.change(20, 1);
        pq.printList();
        System.out.println();
        for(int i = 0; i <= 21; i++){
            System.out.println(pq.contains(i));
        }

    }
}