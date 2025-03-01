
// //Write a program to calculate sum, difference, product, and quotient 
// of 2 double numbers which are entered by users.
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create Scanner

        System.out.println("Enter the first number:");
        double number1 = Double.valueOf(scanner.nextLine());

        System.out.println("Enter the second number:");
        double number2 = Double.valueOf(scanner.nextLine());

        // calculate sum
        double sum = number1 + number2;
        System.out.println("The sum of two numbers is: " + sum);

        // calculate difference
        double difference;
        if (number1 < number2) {
            difference = number2 - number1;
        } else {
            difference = number1 - number2;
        }
        System.out.println("The difference of the two numbers is: " + difference);
        // calculate product

        double product = number1 * number2;
        System.out.println("The product of the two numbers is: " + product);
        // calculate quotient

        double quotient = number1 / number2;
        System.out.println("The quotient of the two numbers is: " + quotient);

        scanner.close();
    }
}