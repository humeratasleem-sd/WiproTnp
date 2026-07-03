package JavaFundamentals.Arrays;
import java.util.*;
public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || arr[i] != arr[i + 1]) {
                System.out.print(arr[i]);
                if (i != n - 1)
                    System.out.print(",");
            }
        }
        System.out.print("}");
	}

}
