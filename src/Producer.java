import java.util.Arrays;
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

        short[] importantInfo = new short[100];
        for (int i = 0; i < importantInfo.length; i++) {
            importantInfo[i] = (short) rd.nextInt(); // storing random integers in an array
//            System.out.println(importantInfo[i]); // printing each array element
        }
        System.out.println(Arrays.toString(importantInfo));

        for (int i : importantInfo) {
            drop.put(String.valueOf(i));
            System.out.format("MESSAGE SENT: %s%n", i);
            try {
                Thread.sleep(rd.nextInt(10));
            } catch (InterruptedException ignored) {
            }
        }
        drop.put("DONE");
    }
}