import java.util.Scanner;

public class prog8{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your word: ");
        String word = sc.nextLine();

        int[] freq = new int[26];
        for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            freq[ch - 'a']++;
        }
        char[] letters = new char[26];
        int[] counts = new int[26];
        int size = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                letters[size] = (char) (i + 'a');
                counts[size] = freq[i];
                size++;
            }
        }

        for(int i = 0;i<size-1;i++){
            for(int j = 0;j<size - i-1;j++){
                if(counts[j] < counts[j+1] ||
                   (counts[j] == counts[j+1] && letters[j] > letters[j+1])){
                    // swapong counts
                    int tempCount = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = tempCount;

                    // swaping  letters
                    char tempChar = letters[j];
                    letters[j] = letters[j + 1];
                    letters[j + 1] = tempChar;                   
                }
            }
        }
        System.out.println("Sorted letters by frequency:");
        for(int i = 0;i<size;i++){
            System.out.println(letters[i] + ":" + counts[i]);
        }
        sc.close();
    }
}