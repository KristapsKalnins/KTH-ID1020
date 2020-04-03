/*********************************************************************************
    Kristaps Kalniņš TCOMK2
    29.08.2019 13:00
    Creates an array of a size specified through stdin,
    then takes the inputted size number of elements and stores them in the array
    and outputted to stdout in reverse order
*********************************************************************************/
import java.util.Scanner;

public class Array {

    public static void main(String[] args){
        //Create scanner to read from stdin
        Scanner in = new Scanner(System.in);

        //Read int from stdin and store it in the nrElements variable
        int nrElements = in.nextInt();
        
        //Create an array of length nrElements 
        int[] elem = new int[nrElements];

        //Fill out array with inputs from stdin by stepping through the
        // array with a loop and an increasing index
        for (int i = 0; i < nrElements; i++ ){
            elem[i] = in.nextInt();
        }

        //Close scanner since there we won't be reading any input anymore
        in.close();

        //Print the elements of the array to stdout by stepping through the
        // array with a loop and a decreasing index
        for (int i = 0; i < nrElements; i++){
            System.out.println(elem[nrElements-1-i]);
        }
    }
}
