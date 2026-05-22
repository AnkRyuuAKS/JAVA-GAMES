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

    public synchronized void push(int value) throws StackException {
        if (top == maxSize - 1) {
            throw new StackException("Stack overflow");
        }
        arr[++top] = value;
        System.out.println("Pushed: " + value);
    }

    public synchronized int pop() throws StackException {
        if (top == -1) {
            throw new StackException("Stack underflow");
        }
        int value = arr[top--];
        System.out.println("Popped: " + value);
        return value;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }
}

public class secondQues{
    public static void main(String[] args) {
        MyStack stack = new MyStack(10);

        Thread pushThread = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                try {
                    stack.push(i);
                    Thread.sleep(200);
                } catch (StackException e) {
                    System.out.println(e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread popThread = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                try {
                    stack.pop();
                    Thread.sleep(300);
                } catch (StackException e) {
                    System.out.println(e);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        pushThread.start();
        popThread.start();

        try {
            pushThread.join();
            popThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");
    }
}
