public class firstQues{

    public static void main(String[] args) {
        try {
            performDivisionWithHandling();
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e);
        }

        System.out.println("Program continues after exception handling.");
    }

    public static void performDivisionWithHandling() {
        int a = 10;
        int b = 0;
        int result = a / b; 
        System.out.println("Result: " + result);
    }
}
