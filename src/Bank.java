import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Bank {
    public static final int NTEST = 10000;
    private final AtomicIntegerArray accounts;
    private long ntransacts = 0;
    private final Lock locker = new ReentrantLock();
    public Bank(int n, int initialBalance){
        accounts = new AtomicIntegerArray(n);
        int i;
        for (i = 0; i < accounts.length(); i++)
            accounts.set(i, initialBalance);
        ntransacts = 0;
    }
//    public void transfer(int from, int to, int amount) {
//        accounts[from] -= amount;
//        accounts[to] += amount;
//        ntransacts++;
//        if (ntransacts % NTEST == 0)
//            test();
//    }

    public synchronized void transferSync(int from, int to, int amount) {
        accounts.accumulateAndGet(from, amount, (prev, add) -> prev - add);
        accounts.accumulateAndGet(to, amount, (prev, add) -> prev + add);
        ntransacts++;
        if (ntransacts % NTEST == 0)
            test();
    }
    public void test(){
        int sum = 0;
        for (int i = 0; i < accounts.length(); i++)
            sum += accounts.get(i);
        System.out.println("Transactions:" + ntransacts
                + " Sum: " + sum);
    }
    public int size(){
        return accounts.length();
    }
}