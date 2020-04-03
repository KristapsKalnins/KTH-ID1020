/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    04.09.2019 14:30
    Java implementation of the reversing string program. This implementation uses
    a LIFO queue i.e. a stack;
*********************************************************************************/
import java.util.Scanner;

class Assignment2{

    private Node first;

    private static class Node{                          //Base node ADT constructor
        public char character;
        public Node next;
    }

    public void push(char character){                   //Operation to push chars to linked list stack
        Node newNode = first;
        first = new Node();
        first.character = character;
        first.next = newNode;
    }

    public char pop(){                                  //Operation to pop chars from linked list stack
        char character = first.character;
        first = first.next;
        return character;
    }


    public void itterative(){                           //Method that prints a line from stdin to stdout backwards
        Scanner in = new Scanner(System.in);            //Create new scanner
        String input = in.nextLine();                   //Read input from stdin
        for(int i = 0; i < input.length(); i++){        //For the length of the string push the chars to stack
            push(input.charAt(i));
        }
        for(int i = 0; i < input.length(); i++){        //Again for the length of the string pop the chars and print them to stdout
            System.out.print(pop());
        }
        in.close();
    }

    public static void main(String[] args){             //Testing the method in main
        Assignment2 ass = new Assignment2();            
        ass.itterative();
    }
} 