
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.awt.Component;
import javax.swing.JOptionPane;
import java.lang.Math; // for pow 

public class EquationSolver {
   public static void main(String[] var0) {
      String strNotification = "";
      String m = JOptionPane.showInputDialog(null,
            "SOLVE:\n1. First-degree equation (linear equation) with one variable\n2. System of first-degree equations (linear system) with two variables\n3. Second-degree equation with one variable\n4. Exit",
            "Input the mode of your choosing", 1);
      int mode = Integer.parseInt(m);
      switch (mode) {
         case 1: // ax+b=0
            String num1 = JOptionPane.showInputDialog(null,
                  "Input the variable a in ax+b=0", "Input variable a ", 1);
            String num2 = JOptionPane.showInputDialog(null,
                  "Input the variable b in ax+b=0", "Input variable b ", 1);

            double a = Double.parseDouble(num1);
            if (a == 0) {
               JOptionPane.showMessageDialog(null, "ERROR: infinite x ", "ERROR", JOptionPane.INFORMATION_MESSAGE);
               break;
            }
            double b = Double.parseDouble(num2);
            double x = -(b / a);
            strNotification += x;
            JOptionPane.showMessageDialog(null, strNotification, "Result of x:", JOptionPane.INFORMATION_MESSAGE);
            break;
         case 2: // ax + by = c
                 // dx + ey = f
                 // I want a cleaner user experience so i'll split the string up
                 // Enter a b c d e f, with the delimiter "|"
                 // String string ="bla-bla"
            String string = JOptionPane.showInputDialog(null,
                  "a_1x + b_1y + c_1 = 0\nda_2x +b_2y + c_2 = 0\n Please input a1 b1 c1 a2 b2 c2\n Remember to use ' '(space) as a delimiter!\nExample:\n1x + 2b + 3 = 0\n4x + 5y + 6 = 0. Enter: 1 2 3 4 5 6",
                  "Input variables with delimiter", 1);
            String[] parts = string.split(" "); // space is the delimiter
            // 0|1|2|3|4|5
            double a1 = Double.parseDouble(parts[0]);
            double b1 = Double.parseDouble(parts[1]);
            double c1 = Double.parseDouble(parts[2]);
            double a2 = Double.parseDouble(parts[3]);
            double b2 = Double.parseDouble(parts[4]);
            double c2 = Double.parseDouble(parts[5]);

            if ((a1 / a2) == (b1 / b2)) {
               if ((a1 / a2) == (c1 / c2)) {
                  strNotification += "Infinite solutions";
               } else {
                  strNotification += "No solution";
               }
            } else { // if != => unique solutions
               double x_2 = (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
               double y_2 = (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);
               strNotification += "x = " + x_2 + "," + " y = " + y_2;
            }
            JOptionPane.showMessageDialog(null, strNotification, "Solution:", JOptionPane.INFORMATION_MESSAGE);
            break;
         case 3: // ax*2 + bx + c = 0
            String longstringhehe = JOptionPane.showInputDialog(null,

                  "ax^2 + bx + c = 0\nInput variables with delimiter\n Please input a b c \nRemember to use ' '(space) as a delimiter!\nExample:\nx^2 + 2x +3 = 0 Enter: 1 2 3 ",
                  "Input variables with delimiter", 1);
            String[] bits = longstringhehe.split(" "); // space is the delimiter
            // 0|1|2|3|4|5
            double a_ = Double.parseDouble(bits[0]);
            double b_ = Double.parseDouble(bits[1]);
            double c_ = Double.parseDouble(bits[2]);
            if (a_==0){
               // a=0 case
               double x_ = -(c_/b_);
               strNotification += "Not a quadratic equation, x = " + x_;
               JOptionPane.showMessageDialog(null, strNotification, "Solution:", JOptionPane.INFORMATION_MESSAGE);
               break;
   
            }

            double discriminant = Math.pow(b_, 2) - 4 * a_ * c_; // (num, power)
            if (discriminant > 0) {
               // different two roots
               double x1 = (-b_ + Math.sqrt(discriminant)) / (2 * a_);
               double x2 = (-b_ - Math.sqrt(discriminant)) / (2 * a_);
               strNotification += "x1 = "+x1+","+" x2 = "+x2;
            } else if (discriminant == 0) {
               // two root = eachother
               double x_ = (-b_ + Math.sqrt(discriminant)) / (2 * a_);
               strNotification += "x1 = x2 = "+x_;
            } else {
               // <0 : no real root 
               strNotification += "no real root possible ";
            }
            JOptionPane.showMessageDialog(null, strNotification, "Solution:", JOptionPane.INFORMATION_MESSAGE);
            break;
         default:
            break;
      }

      System.exit(0);
   }
}
