
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

    //multiply - 1 
    public void multiply(double scaler){
        for(int i = 0;i<arr.length;i++){
            arr[i] = (int)(arr[i] * scaler);
        }
    }

    //multipy-2
    public int multiply(Vector other){
        if(arr.length != other.arr.length){
            System.out.println("The array sizes must be same");
            return -1;
        }
        int prod = 0;
        for(int i = 0;i<arr.length;i++){
            prod += (arr[i] * other.arr[i]);
        }
        return prod;
    }
}

public class secondProb {
    public static void main(String[] args) {
        int[] data = {1,2,3,45};
        int[] data2 = {2,3,4,5};
        Vector vc = new Vector(data);
        Vector vc2 = new Vector(data2);
        System.out.print(vc.multiply(vc2));
    }
}
