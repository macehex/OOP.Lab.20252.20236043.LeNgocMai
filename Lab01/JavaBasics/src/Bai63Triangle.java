import java.util.Scanner;

public class Bai63Triangle {
    public static void main(String[] args) {
        // write a program to display a triangle with a height of n stars '*'
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the height of the triangle:");
        int n = Integer.valueOf(keyboard.nextLine());

        Triangle(n);

        keyboard.close();

    }

    public static void Triangle(int n) {
        
        // space before line = ( n - 1 ) - depth +1

        for (int i = 1; i <= n; i++) {
            int step = (i * 2) - 1;
            String string = "";
            while (step > 0) {
                string += "*";
                step--;
            }
            int space_cnt = n-i;
            while (space_cnt > 0) {
                string = " " + string;
                space_cnt--;
            }
            
            System.out.println(string);
           
        }
    }
}