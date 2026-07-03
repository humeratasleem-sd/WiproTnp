package JavaFundamentals.Arrays;
import java.util.*;
public class Only14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean flag = true;

        for (int i = 0; i < n; i++) {

            if (arr[i] != 1 && arr[i] != 4) {
                flag = false;
                break;
            }
        }

        System.out.println(flag);


	}

}
