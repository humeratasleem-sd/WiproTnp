package TM01.Project7;

class HareTortoise extends Thread {

    private String winner = "";

    public HareTortoise(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {

            System.out.println(getName() + " : " + i + " meters");

            // Hare sleeps after reaching 60 meters
            if (getName().equals("Hare") && i == 60) {
                System.out.println("Hare is sleeping for 1 second...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Check winner
            if (i == 100 && winner.equals("")) {
                winner = getName();
                System.out.println("\nWinner is : " + winner);
            }

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
