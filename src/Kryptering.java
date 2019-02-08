import javax.swing.*;
import java.io.*;

public class Kryptering {
    public static void main(String[] args) {
        /*JFrame frame = new JFrame("GUIDesign");
        GUIDesign theGUI = new GUIDesign();
        frame.setContentPane(theGUI.GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Model theModel = new Model();
        Controller theController = new Controller(theGUI, theModel);*/
        String filnamn;
        String msg = null;
        FileReader fr = null;

        filnamn = JOptionPane.showInputDialog(null, "Ange filnamn");
        /*FileWriter fw = null;
        try {
            fw = new FileWriter(filnamn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter utFil = new PrintWriter(bw);*/
        try {
            fr = new FileReader(filnamn);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader inFil = new BufferedReader(fr);
        try {
            msg = inFil.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //String msg = JOptionPane.showInputDialog(null, "Skriv in ditt meddelande");
        String key = "sgsa";
        int[] crypt = new int[msg.length()];

        while (msg.length() > key.length()) {
            key = key + key;
        }

        for (int i = 0; i < msg.length(); i++) {
            crypt[i] = msg.charAt(i) ^ key.charAt(i);
        }

        for (int i = 0; i < crypt.length; i++) {
            System.out.println(Integer.toBinaryString(crypt[i]));
        }

        int[] decrypt = new int[crypt.length];
        for (int i = 0; i < crypt.length; i++) {
            decrypt[i] = crypt[i] ^ key.charAt(i);
        }

        for (int i = 0; i < decrypt.length; i++) {
            System.out.print((char) decrypt[i]);
        }
    }
}