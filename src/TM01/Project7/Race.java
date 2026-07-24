package TM01.Project7;

public class Race {

    public static void main(String[] args) {

        HareTortoise hare = new HareTortoise("Hare");
        HareTortoise tortoise = new HareTortoise("Tortoise");

        // Give higher priority to Hare
        hare.setPriority(Thread.MAX_PRIORITY);
        tortoise.setPriority(Thread.MIN_PRIORITY);

        hare.start();
        tortoise.start();
    }
}
