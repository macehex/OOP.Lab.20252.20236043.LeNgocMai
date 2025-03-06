import javax.swing.*;
public class Bai61verCustomDialog {
    public static void main(String[] args) {
        String[] options = { "i do", "i don't" };
        var choice = JOptionPane.showOptionDialog(null, "Do you want the first class ticket ?",
                "Choose:",0,1,null, options, options[0]);
        switch (choice) {
            case 0:
            JOptionPane.showMessageDialog(null, "You've chosen the ticket");
            break;
            case 1:
            JOptionPane.showMessageDialog(null, "You've refused the ticket");
            break;
        default:
            break; 
        }
        System.exit(0);
        }
    
}
