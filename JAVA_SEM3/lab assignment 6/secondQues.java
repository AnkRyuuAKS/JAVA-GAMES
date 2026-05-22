public class secondQues{

    public static void main(String[] args) {
        try {
            try {
                performDivisionWithHandling();
            } catch (ArithmeticException ae) {
                System.out.println("Caught ArithmeticException: " + ae);

                int[] numbers = {1, 2, 3};
                System.out.println("Accessing out-of-bounds index: " + numbers[5]);
            }
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + aioobe);
        }

        System.out.println("\n--- Now, swapping the sequence ---\n");

        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Accessing out-of-bounds index: " + numbers[5]);

            performDivisionWithHandling();
        } catch (ArithmeticException ae) {
            System.out.println("Caught ArithmeticException: " + ae);
        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + aioobe);
        }

        System.out.println("\nProgram continues normally.");
    }

    public static void performDivisionWithHandling() {
        int a = 10;
        int b = 0;
        int result = a / b;
        System.out.println("Result: " + result);
    }
}
