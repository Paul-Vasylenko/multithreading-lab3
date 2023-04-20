public class Consumer implements Runnable {
    private SharedBuffer queue;
    public Consumer(SharedBuffer q) {
        queue = q;
    }
    @Override
    public void run() {
        try {
            while(true) {
                int value = queue.take();
                System.out.println("CONSUMER: got value " + value);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("ERROR: Consumer.java line 14");
        }
    }
}


