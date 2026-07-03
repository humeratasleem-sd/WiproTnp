package JavaFundamentals.flowcontrol;

import java.util.Scanner;

public class PositiveNegativeZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		if(n>0) {
			System.out.println("Positive");
		}else if(n<0) {
			System.out.println("Negative");
		}else {
			System.out.println("Zero");
		}

	}

}
