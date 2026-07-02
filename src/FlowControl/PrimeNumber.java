package FlowControl;

public class PrimeNumber {
	public static void main(String[] args) {
	if (args.length == 0) {
        System.out.println("Please enter a number");
        return;
    }

    int n = Integer.parseInt(args[0]);

    if (n <= 1) {
        System.out.println("Not Prime");
        return;
    }

    boolean prime = true;

    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            prime = false;
            break;
        }
    }

    if (prime)
        System.out.println("Prime");
    else
        System.out.println("Not Prime");

}
}