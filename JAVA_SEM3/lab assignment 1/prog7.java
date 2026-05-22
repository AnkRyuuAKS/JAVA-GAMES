import java.util.Scanner;

public class prog7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binaryStr = sc.nextLine();

        boolean isValid = true;
        for (int i = 0; i < binaryStr.length(); i++) {
            char ch = binaryStr.charAt(i);
            if (ch != '0' && ch != '1') {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Input is not in proper format");
        }else{
            int decimal = 0,pow = 1;
            for(int i = binaryStr.length() - 1;i>=0;i--){
                int bit = binaryStr.charAt(i) - '0';
                decimal += (bit * pow);
                pow *= 2;
            }
            System.out.println("Decimal Equivalent:" + decimal);
        }
    }
}