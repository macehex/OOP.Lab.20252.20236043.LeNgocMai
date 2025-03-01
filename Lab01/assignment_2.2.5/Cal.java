
// //Write a program to calculate sum, difference, product, and quotient 
// of 2 double numbers which are entered by users.
import javax.swing.JOptionPane;

public class Cal {
    public static void main(String[] args) {

        String strNum1, strNum2;
        double sum, difference, product, quotient;

        String strNotification = "";

        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ", "Input the first number",
                JOptionPane.INFORMATION_MESSAGE);

        strNum2 = JOptionPane.showInputDialog(null,
                "Please input the second number that is not 0: ", "Input the second number",
                JOptionPane.INFORMATION_MESSAGE);

        double a = Double.parseDouble(strNum1), b = Double.parseDouble(strNum2);
        // sum
        sum = a + b;
        // difference
        if (a > b) {
            difference = a - b;
        } else {
            difference = b - a;
        }
        // product
        product = a * b;
        quotient = a / b;
         
        String str1 = "The sum is " + sum + " The difference is " + difference + " The product is " + product
                + " The quotient is " + quotient;
        strNotification += str1;
        JOptionPane.showMessageDialog(null, strNotification,
                "Show two numbers", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
