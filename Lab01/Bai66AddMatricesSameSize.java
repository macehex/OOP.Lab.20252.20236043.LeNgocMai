import java.util.Scanner;
import java.util.Arrays;

public class Bai66AddMatricesSameSize {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("Enter the size of the matrices mxn\nExample: for 2x3 enter 2 3");
        int m = key.nextInt();
        int n = key.nextInt();
        
        //Enter the first array
        int[][] a1 = new int[m][n];
        System.out.println("Array 1");
        for (int j = 0; j < m; j++) {
            System.out.println("Enter numbers of row "+j+", each separated by a ' '(space)");
            for (int i = 0; i < n; i++) {
                a1[j][i] = key.nextInt(); 
            }
        }
        //Enter the second array 
        int[][] a2 = new int[m][n];
        System.out.println("Array 2");
        for (int j = 0; j < m; j++) {
            System.out.println("Enter numbers of row "+j+", each separated by a ' '(space)");
            for (int i = 0; i < n; i++) {
                a2[j][i] = key.nextInt(); 
            }
        }

        // Adding
        int[][] sumOfMatrices= new int[m][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sumOfMatrices[j][i] = a2[j][i] + a1[j][i];
            }
        }
        //Display
        System.out.println("The sum matrice is:"); 
        String message = ""; 
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                message = message + sumOfMatrices[j][i];
                message += ", ";
            }
            message +="\n";
        }
        System.out.println(message);

        key.close();
    }
}
