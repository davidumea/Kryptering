import javax.swing.*;

public class CMDInput {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No argument");
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        } else if (args.length == 1) {
            for(int i = 0; i < args.length; i++) {
                System.out.println("AA " + args[i]);
            }
        }
    }
}
