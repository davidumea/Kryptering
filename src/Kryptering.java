import javax.swing.*;

public class Kryptering {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIDesign");
        GUIDesign theGUI = new GUIDesign();
        frame.setContentPane(theGUI.GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Model theModel = new Model();
        Controller theController = new Controller(theGUI, theModel);
    }
}
