package JavaFundamentals.flowcontrol;

public class InterestPercentage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String gender = args[0];
        int age = Integer.parseInt(args[1]);
        if (gender.equalsIgnoreCase("Female")) {
            if (age >= 1 && age <= 58) {
                System.out.println("Interest = 8.2%");
            } 
            else if (age >= 59 && age <= 100) {
                System.out.println("Interest = 9.2%");
            }

        } 
        else if (gender.equalsIgnoreCase("Male")) {

            if (age >= 1 && age <= 58) {
                System.out.println("Interest = 8.4%");
            } 
            else if (age >= 59 && age <= 100) {
                System.out.println("Interest = 10.5%");
            }

        }

	}

}
