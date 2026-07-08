package OOPS_Inheritance.OptionalClass;

import java.util.Optional;

public class Problem1 {

    public static void main(String[] args) {

        String[] names = new String[5];

        names[0] = "Tasleem";  

        Optional<String> optional = Optional.ofNullable(names[0]);

        if (optional.isPresent()) {
            System.out.println("Value: " + optional.get());
            System.out.println("Length: " + optional.get().length());
        } else {
            System.out.println("Value is null");
        }
    }
}