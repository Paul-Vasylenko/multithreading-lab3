public class Main {
    public static int QUEUE_SIZE = 100000;
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue(QUEUE_SIZE);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}