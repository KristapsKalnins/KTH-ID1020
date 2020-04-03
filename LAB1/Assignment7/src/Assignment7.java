import java.util.Scanner;
/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    08.09.2019 15:00
    Filter that checks if a file has balanced brackets using a stack-like linked
    list
*********************************************************************************/
public class Assignment7 {

    private Node first; //First node
    private int N; //"Stack counter"
    private String text;

    //Base node
    private static class Node {
        public char elem;
        public Node nextNode;
    }

    public void fileRead() {                            //Method that reads text from stdin
        StringBuilder builder = new StringBuilder();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            builder.append(in.next());                  //Builder is used, because a lot of string concatenation is done
        }
        text = builder.toString();                      //Put stdin text in string var "text"
        in.close();
    }

    public void fileTest() {                            //Method that checks if the brackes are balanced
        int square = 0;
        int paren = 0;
        int curl = 0;
        for (int i = 0; i < text.length(); i++) {      //If left bracket, push to stack, if right, pop from stack and read
            switch (text.charAt(i)) {
                case '(':
                    push('(');
                    break;
                case ')':
                    if(pop() != '(')
                        paren++;
                    break;
                case '{':
                    push('{');
                    break;
                case '}':
                    if(pop() != '{')
                        curl++;
                    break;
                case '[':
                    push('[');
                    break;
                case ']':
                    if(pop() != '[')
                        square++;
                    break;
            }
        }
        if(square == 0 && paren == 0 && curl == 0 && N == 0){       //If any of the pop returnd non-matching bracekts, print how many were unbalanced,
            System.out.println("Everything balanced");              //else print "Everything balanced"
        }
        else{
            if(N != 0)
                while(N > 0)
                    switch (pop()){
                        case'(':
                            paren++;
                            break;
                        case '{':
                            curl++;
                            break;
                        case '[':
                            square++;
                            break;
                    }
            StringBuilder out = new StringBuilder();
            out.append("Unbalanced\n");
            out.append(paren); out.append(" :parentheses\n");
            out.append(curl); out.append(" :curly brackets\n");
            out.append(square); out.append(" :square brackets\n");
            System.out.println(out.toString());
        }
    }

    //Add new node to "top" of list i.e. adds new first node
    public void push(char value) {
        Node newNode = first;
        first = new Node();
        first.elem = value;
        first.nextNode = newNode;
        N++;
    }

    //Remove first node from "top" of list i.e. removes first node and return the value within that node
    public char pop() {
        if (N != 0) {
            char value = first.elem;
            first = first.nextNode;
            N--;
            return value;
        }
        else {
            return 'N';
        }
    }



    public static void main(String[] args) {
        Assignment7 filter = new Assignment7();
        filter.fileRead();
        filter.fileTest();

    }
}
