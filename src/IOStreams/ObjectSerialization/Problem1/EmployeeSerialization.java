package IOStreams.ObjectSerialization.Problem1;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Date;

public class EmployeeSerialization {

    public static void main(String[] args) {

        Employee emp = new Employee(
                "Rahul",
                new Date(),
                "IT",
                "Software Engineer",
                50000.0
        );

        try {

            FileOutputStream fos = new FileOutputStream("data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(emp);

            oos.close();
            fos.close();

            System.out.println("Employee object serialized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
