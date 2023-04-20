import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBuffer {
    private final SynchronousQueue<Integer> queue;
    private final Lock lock = new ReentrantLock();
    public SharedBuffer() {
        this.queue = new SynchronousQueue<>();
    }

    public int take() throws InterruptedException {
        return queue.take();
    }

    public void put(int value) throws InterruptedException {
        queue.put(value);
        lock.lock();
        try {
            int size = queue.size();
        } finally {
            lock.unlock();
        }
    }
}
