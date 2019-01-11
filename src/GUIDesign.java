import javax.swing.*;

public class GUIDesign {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GUIDesign");
        frame.setContentPane(new GUIDesign().GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel GUI;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton openButton;
    private JButton saveButton;
    private JButton keyButton;
    private JButton orelevantInfoknappButton;
}
