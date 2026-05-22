class Vector {
    public int[] arr;

    // Constructor taking array
    public Vector(int[] arr1) {
        arr = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
    }

    // Copy constructor
    public Vector(Vector other) {
        arr = new int[other.arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = other.arr[i];
        }
    }

    // Set method
    public void set(int index, int value) {
        arr[index] = value;
    }

    // Get method
    public int get(int index) {
        if (index >= 0 && index < arr.length) {
            return arr[index];
        } else {
            System.out.println("Index out of bounds!");
            return -1;
        }
    }
}


public class firstProb {
    public static void main(String[] args) {
        int[] data = {1,2,3,45};
        Vector vc = new Vector(data);

        for (int i = 0; i < vc.arr.length; i++) {
            System.out.print(vc.arr[i] + " ");
        }
        System.out.println();
    }
}