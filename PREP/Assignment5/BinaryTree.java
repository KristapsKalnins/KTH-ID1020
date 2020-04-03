/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    1.08.2019 12:00
    Class for creating a binary tree. The tree can be searched and traversd in
    three different ways.
*********************************************************************************/
public class BinaryTree {

    private Node root;

    //Base nodes of tree
    private static class Node{
        public int key;
        public Node right;
        public Node left;
    }

    //Inserting the first root of tree
    public void insertRoot(int val){
        root = new Node();
        root.key = val;
        root.right = null;
        root.left = null;

    }

    //Insert a int into the tree
    public void insert(Node root, int newKey){
        Node in = new Node();
        in.key = newKey;
        if (in.key < root.key){
            if(root.left == null)
                root.left = in;
            else
                insert(root.left, newKey);
        }
        else{
            if (root.right == null)
                root.right = in;
            else
                insert(root.right, newKey);
        }
    }

    //Three different traverses
    public void prefixTraverse(Node root){
        if(root == null)
            return;
        System.out.print(root.key + " ");
        prefixTraverse(root.left);
        prefixTraverse(root.right);
    }

    public void infixTraverse(Node root){
        if(root == null)
            return;
        infixTraverse(root.left);
        System.out.print(root.key + " ");
        infixTraverse(root.right);
    }

    public void postfixTraverse(Node root){
        if(root == null)
            return;
        postfixTraverse(root.left);
        postfixTraverse(root.right);
        System.out.print(root.key + " ");
    }

    //Binary search for finding ints in tree
    public boolean binSearch(Node root, int key){
        if(root == null) {
            return false;
        }
        else if(root.key == key){
            return true;
        }
        else if(root.key > key){
            return binSearch(root.left, key);
        }
        else{
            return binSearch(root.right, key);
        }
    }


    public static void main(String[] args){
        //Building tree
        BinaryTree tree = new BinaryTree();
        tree.insertRoot(7);
        tree.insert(tree.root, 5);
        tree.insert(tree.root, 6);
        tree.insert(tree.root, 10);
        tree.insert(tree.root, 9);
        tree.insert(tree.root, 2);
        tree.insert(tree.root, 3);
        tree.insert(tree.root, 4);
        tree.insert(tree.root, 8);
        tree.insert(tree.root, 1);

        //testin traverses
        tree.prefixTraverse(tree.root);

        System.out.println();
        tree.infixTraverse(tree.root);

        System.out.println();
        tree.postfixTraverse(tree.root);

        //Testing search
        System.out.println();
        System.out.print(tree.binSearch(tree.root, 1));

        System.out.println();
        System.out.print(tree.binSearch(tree.root, 11));
        

    }
}
