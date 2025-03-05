import javax.swing.JOptionPane;
public class Bai61ChoosingOption {
    public static void main(String[] args) {
        int option = JOption.Pane.showConfirmDialog(null, "Do you want the first class ticket?");
        javax.swing.JOptionPane.showMessageDialog(null, "You've chosen: "+
                (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
        System.exit(0);
    }
}
