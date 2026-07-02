package FlowControl;

public class SumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 if (args.length == 0) {
	            System.out.println("Please enter a number");
	            return;
	        }
	     int num = Integer.parseInt(args[0]);
	     num = Math.abs(num);
	     int sum = 0;
	     while (num > 0) {
	        sum += num % 10;
	        num /= 10;
	    }
	    System.out.println(sum);
	}
}
