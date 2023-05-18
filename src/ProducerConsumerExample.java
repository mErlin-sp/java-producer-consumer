public class ProducerConsumerExample {
    public static void main(String[] args) {
        System.out.println("Java Producer Consumer Application");
        Drop drop = new Drop();

        (new Thread(new Producer(drop))).start();
        (new Thread(new Consumer(drop))).start();
    }
}