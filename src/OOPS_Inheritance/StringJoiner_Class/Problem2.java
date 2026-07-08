package OOPS_Inheritance.StringJoiner_Class;

import java.util.StringJoiner;

public class Problem2 {

    public static void main(String[] args) {

        StringJoiner s1 = new StringJoiner("-");
        s1.add("Hyderabad");
        s1.add("Chennai");
        s1.add("Bangalore");

        StringJoiner s2 = new StringJoiner("-");
        s2.add("Mumbai");
        s2.add("Delhi");
        s2.add("Pune");

        // s1 merged to s2
        StringJoiner merge1 = new StringJoiner("-");
        merge1.merge(s1);
        merge1.merge(s2);

        System.out.println("s1 merged to s2:");
        System.out.println(merge1);

        // s2 merged to s1
        StringJoiner merge2 = new StringJoiner("-");
        merge2.merge(s2);
        merge2.merge(s1);

        System.out.println("\ns2 merged to s1:");
        System.out.println(merge2);
    }
}