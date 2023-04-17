import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue {
    int maxSize;
    private final ArrayBlockingQueue<Integer> queue;
    private final Lock lock = new ReentrantLock();
    public SharedQueue(int size) {
        this.maxSize = size;
        this.queue = new ArrayBlockingQueue<>(size);
    }

    public int take() throws InterruptedException {
        return queue.take();
    }

    public void put(int value) throws InterruptedException {
        queue.put(value);
        lock.lock();
        try {
            int size = queue.size();
            if (size > maxSize) {
                maxSize = size;
            }
        } finally {
            lock.unlock();
        }
    }
}
