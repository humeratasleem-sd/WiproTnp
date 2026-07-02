package FlowControl;
import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        while (num > 0) {
            System.out.print(num % 10);
            num = num / 10;
        }
	}

}
