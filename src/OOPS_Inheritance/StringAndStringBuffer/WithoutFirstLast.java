package OOPS_Inheritance.StringAndStringBuffer;
import java.util.Scanner;
public class WithoutFirstLast {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(str.substring(1, str.length() - 1));
    }

}
