import java.util.concurrent.ArrayBlockingQueue;

public class SharedQueue {
    int size;
    private final ArrayBlockingQueue<Integer> queue;
    public SharedQueue(int size) {
        this.size = size;
        this.queue = new ArrayBlockingQueue<>(size);
    }

    public int take() {
        try {
            return queue.take();
        } catch (InterruptedException e){
            System.out.println("Interrupted exception");
        }
    }
}
