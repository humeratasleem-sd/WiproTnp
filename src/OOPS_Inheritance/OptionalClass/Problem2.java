package OOPS_Inheritance.OptionalClass;
import java.util.*;
public class Problem2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String address=null;
		String result=Optional.ofNullable(address).orElse("India");
		System.out.println(result);

	}

}
