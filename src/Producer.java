import java.util.Random;

public class Producer implements Runnable {
    private final Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
//        String[] importantInfo = {
//                "Mares eat oats",
//                "Does eat oats",
//                "Little lambs eat ivy",
//                "A kid will eat ivy too"
//        };
        Random rd = new Random();

        int[] importantInfo = new int[5000];
        for (int i = 0; i < importantInfo.length; i++) {
            importantInfo[i] = rd.nextInt(); // storing random integers in an array
            System.out.println(importantInfo[i]); // printing each array element
        }

        for (int i : importantInfo) {
            drop.put(String.valueOf(i));
            try {
                Thread.sleep(rd.nextInt(10));
            } catch (InterruptedException ignored) {
            }
        }
        drop.put("DONE");
    }
}