import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Kryptering {
    public static void main(String[] args) {

        /**
         * Kod som kopplar till GUI designen, bortkommenterad eftersom jag inte kom så långt.
         */
        /*JFrame frame = new JFrame("GUIDesign");
        GUIDesign theGUI = new GUIDesign();
        frame.setContentPane(theGUI.GUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        Model theModel = new Model();
        Controller theController = new Controller(theGUI, theModel);*/
        /**
         * Variabler
         */
        String filnamn;
        String msg = null;
        String key = "sgsa";
        FileReader fr = null;
        int linenumber;

        /**
         * Frågar om namn på filen som ska krypteras och läser vad som står i filen.
         */
        filnamn = JOptionPane.showInputDialog(null, "Ange filnamn");
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

        msg = lines.get(0);
        int[] crypt = new int[msg.length()];

        /**
         * Kollar om nyckeln är för kort och gör den längre
         */
        while (msg.length() > key.length()) {
            key = key + key;
        }

        /**
         * Jämför bokstav per bokstav med nyckeln och krypterar binärt genom att jämföra deras binära tal, om nyckels tal och inputens
         * tal inte matchar så blir det krypterade talet en etta, annars blir det en nolla.
         */
        for (int i = 0; i < msg.length(); i++) {
            crypt[i] = msg.charAt(i) ^ key.charAt(i);
        }

        /**
         * Skriver ut de binära talen i terminalen.
         */
        for (int i = 0; i < crypt.length; i++) {
            System.out.println(Integer.toBinaryString(crypt[i]));
        }

        /**
         * Skriver in den krypterade binära datan i en annan fil
         */
        DataOutputStream output = null;
        try {
            output = new DataOutputStream (new BufferedOutputStream(new FileOutputStream("kopiaAvFilename.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < crypt.length; i++) {
                    output.write(crypt[i]);
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Läser från den krypterade filen
         */
        DataInputStream input = null;
        try {
            input = new DataInputStream (new BufferedInputStream(new FileInputStream("kopiaAvFilename.txt")));
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

        /**
         * Jämför de binära talen med nyckeln och konverterar tillbaka till läsbar text.
         */
        int[] decrypt = new int[crypt.length];
        for (int i = 0; i < crypt.length; i++) {
            decrypt[i] = crypt[i] ^ key.charAt(i);
        }

        /**
         * Skriver ut det decrypterade meddelandet.
         */
        for (int i = 0; i < decrypt.length; i++) {
            System.out.print((char) decrypt[i]);
        }
    }
}