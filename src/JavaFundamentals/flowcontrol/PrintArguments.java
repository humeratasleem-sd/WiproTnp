package JavaFundamentals.flowcontrol;
import java.util.Scanner;
public class PrintArguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
            System.out.println("No Values");

        } else {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i != args.length - 1) {
                    System.out.print(",");
                }
            }
        }
	}
}
