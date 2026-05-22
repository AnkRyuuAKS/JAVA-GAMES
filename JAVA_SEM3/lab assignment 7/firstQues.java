class SumOfNumberUsingThread extends Thread {
    private int start;
    private int end;
    private long partialSum;
    public SumOfNumberUsingThread(int start, int end) {
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }

    // this method allows the threading
    public void run() {
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
    }
    public long getPartialSum() {
        return partialSum;
    }
}

public class firstQues {
    public static void main(String[] args) {
        int n = 1000; // You can change this value as needed
        int numThreads = 8;

        SumOfNumberUsingThread[] threads = new SumOfNumberUsingThread[numThreads];
        int range = n / numThreads;
        int start = 1;

        // Create and start threads
        for (int i = 0; i < numThreads; i++) {
            int end = start + range - 1;
            if(end > n) end = n;
            threads[i] = new SumOfNumberUsingThread(start, end);
            threads[i].start();
            start = end + 1;
        }
        long mainThreadSum = 0;
        if (n % numThreads != 0) {
            for (int i = (range * numThreads) + 1; i <= n; i++) {
                mainThreadSum += i;
            }
        }
        long totalSum = mainThreadSum;
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                totalSum += threads[i].getPartialSum();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Sum from 1 to " + n + " = " + totalSum);
    }
}
