import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

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
        String key = "sgsa";
        FileReader fr = null;
        int linenumber;

        DataOutputStream output = null;
        try {
            output = new DataOutputStream (new BufferedOutputStream(new FileOutputStream("myData.dat")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            output.write(14);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Decrypt

        DataInputStream input = null;
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream("myData.dat")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            int i;
            while ((i = input.read()) >= 0)
            System.out.println(i);
        } catch (IOException e) {
            e.printStackTrace();
        }


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
        ArrayList<String> lines = new ArrayList<String>();
        try {
            while ((msg = inFil.readLine()) != null) {
                lines.add(msg);

            }

        } catch (IOException e) {

        }


        //String msg = JOptionPane.showInputDialog(null, "Skriv in ditt meddelande");
        msg = lines.get(0);
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