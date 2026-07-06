package OOPS_Inheritance.ClassesAndObjects;
import java.util.*;

public class TestBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        Scanner sc = new Scanner(System.in);

		        System.out.print("Enter width: ");
		        int width = sc.nextInt();

		        System.out.print("Enter height: ");
		        int height = sc.nextInt();

		        System.out.print("Enter depth: ");
		        int depth = sc.nextInt();

		        Box b = new Box(width, height, depth);

		        System.out.println("Volume : " + b.volume());

	}

}
