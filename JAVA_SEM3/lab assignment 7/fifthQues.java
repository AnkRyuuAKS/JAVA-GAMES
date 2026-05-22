class StackException extends Exception {
    public StackException(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "StackException: " + getMessage();
    }
}

class MyStack {
    private int[] arr;
    private int top;
    private int maxSize;

    public MyStack(int n) {
        arr = new int[n];
        maxSize = n;
        top = -1;
    }

    public synchronized void push(int value) {
        while (top == maxSize - 1) {
            try {
                System.out.println("Stack full, push waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        arr[++top] = value;
        System.out.println("Pushed: " + value);
        notifyAll();
    }

    public synchronized int pop() {
        while (top == -1) {
            try {
                System.out.println("Stack empty, pop waiting...");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int value = arr[top--];
        System.out.println("Popped: " + value);
        notifyAll();
        return value;
    }
}

public class fifthQues {
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);

        Thread pushThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    stack.push(i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        Thread popThread = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    stack.pop();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        pushThread.start();
        popThread.start();

        try {
            pushThread.join();
            popThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Main thread finished.");
    }
}
