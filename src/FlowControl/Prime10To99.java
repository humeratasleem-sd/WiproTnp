package FlowControl;

public class Prime10To99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 10; i <= 99; i++) {
            boolean prime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime)
                System.out.print(i + " ");
        }
	}
}
