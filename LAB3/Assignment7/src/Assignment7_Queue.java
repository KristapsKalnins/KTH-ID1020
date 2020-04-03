import java.util.Iterator;

public class Assignment7_Queue<E> implements Iterable<E> {


    private Node first = null; //First node

    //creating the base Node
    private class Node {
        public E value;
        public Node nextNode;
        public Node prevNode;
    }


    public void enqueue(E value) {
        Node n = new Node();
        n.value = value;
        n.nextNode = first;
        if (first != null) {
            first.prevNode = n;
        }
        first = n;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iter = new Iterator<E>() {
            Node copy = first;

            @Override
            public boolean hasNext() {
                return copy != null;
            }

            @Override
            public E next() {
                E value = copy.value;
                copy = copy.nextNode;
                return value;
            }
        };
        return iter;
    }

    public E removeKth(int k) {                  //Loops through list to find element and then removes it
        int count = 1;
        Node copy = first;
        while (count++ < k && copy != null) {
            copy = copy.nextNode;
        }
        if (copy == first) {                      //Special case if k = 1
            first = first.nextNode;
        } else if (copy == null) {
            System.out.println();
            System.out.print("No element with such index -> " + k);
            return null;
        } else {
            copy.prevNode.nextNode = copy.nextNode;
            copy.nextNode.prevNode = copy.prevNode;
        }
        return copy.value;
    }

    public E dequeue() {
        Node copy = first;
        while (copy.nextNode != null) {
            copy = copy.nextNode;
        }
        E out = copy.value;
        if (copy.prevNode == null) { //End case for first
            first = null;
            return out;
        } else {
            copy.prevNode.nextNode = null;
        }
        return out;
    }

    public void printList() {
        if (first == null) {
            System.out.println();
            System.out.print("Empty queue!");
        } else {
            System.out.println();
            for (E val : this) {
                System.out.print("[" + val + "], ");
            }
        }
    }


}