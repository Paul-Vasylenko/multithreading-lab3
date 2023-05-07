public class AsyncBankTest {
    public static final int ACCOUNTS = 10;
    public static final int INITIAL_BALANCE = 10000;
    public static void main(String[] args) {
        Bank b = new Bank(ACCOUNTS, INITIAL_BALANCE);
        int i;
        var start = System.currentTimeMillis();
        var threads = new TransferThread[ACCOUNTS];
        for (i = 0; i < ACCOUNTS; i++){
            TransferThread t = new TransferThread(b, i,
                    INITIAL_BALANCE);
            t.setPriority(Thread.NORM_PRIORITY + i % 2);
            threads[i] = t;
            t.start();
        }
        try{
            for(var t : threads) t.join();
        } catch(InterruptedException e) {

        }
        var end = System.currentTimeMillis();
        var time = end - start;

        System.out.println(time);
    }
}