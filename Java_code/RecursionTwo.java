public class RecursionTwo{
    //TILING PROBLEM:=
    public static int tilingProbl(int n){
        //Base Case:-
        if(n == 0|| n == 1){
            return 1;
        }

        //Vertical Choice:-
        int fnm1 = tilingProbl(n-1);

        //Horizontal Choice:-
        int fnm2 = tilingProbl(n-2);

        int totWays = fnm1 + fnm2;
        return totWays;
    }

    //Remove duplicate char from String:-
    public static void removeDuplicate( String str,int idx ,StringBuilder newStrg , boolean map[]){
        //Base Case;
        if( idx == str.length()){
            System.out.println(newStrg);
            return;
        }

        //kaam
        char currChar = str.charAt(idx);
        //char - a helps to find the idxGap  of map'
        if( map[currChar - 'a'] == true){
            //duplicate
            removeDuplicate(str , idx + 1,newStrg, map);
        }
        else{
            map[currChar - 'a'] = true;
            removeDuplicate(str , idx+1 , newStrg.append(currChar) , map);
        }
    }

    //FRIENDS PAIRING PROBLEM:-
    public static int friendsPairing(int n){
        //bc:
        if( n == 1 || n==2){
            return n;
        }
        //choices
          //single:-
          int fnm1 = friendsPairing(n - 1);
          //pair:-
          int fnm2 = friendsPairing(n -2);
          int pairWays = (n-1)* fnm2;

        //totWays:
        int totWays = fnm1 + pairWays;
        return totWays;
    }

    //BINARY STRING PROBLEM;-
    public static void printBinString(int n ,int lastPlace , String binStr){

        //base case
        if( n== 0){
            System.out.println(binStr);
            return;
        }
        //kaam;
        // if( lastPlace == 0){
        //     printBinString( n- 1,0,binStr.append("0"));
        //     printBinString( n-1 , 0 binStr.append("1"));
        // }
        // else{
        //     printBinString( n- 1,0,binStr.append("0"));
        //  }
        printBinString( n-1 ,0 ,binStr+"0");

        if(lastPlace == 0){
            printBinString( n-1 ,1, binStr+"1");
        }
    }

    //Ocurrance of the given elements:-
    public static void occuranceAll(int n ,int arr[],int key){
        //Base case:
        if( n == arr.length ){
            return;
        }
        
        if( arr[n] == key){
           System.out.print(n +" ");
        }
            occuranceAll( n+1,arr,key);
        System.out.print  ln();
    }

    //Digits to words :-
    public static void printDigToWOrd( String digit[] , int num){

        //Base Case :-
        if( num == 0){
            return ;
        }
       //WORK
        int lastDig = num % 10;
        printDigToWOrd( digit,num/10);
        System.out.print(digit[lastDig]+" ");
    }
    public static void main(String args[]){
        System.out.println(tilingProbl(3));

        String str = "appnnnnacoolege";
        removeDuplicate(str , 0 ,new StringBuilder(""),new boolean[26]);

        System.out.println("total ways "+friendsPairing(3));

        printBinString(3,0,"");

        int arr[] = {3,2,4,5,6,2,7,2,2};
        occuranceAll(0,arr,2);

        String digit[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        printDigToWOrd( digit , 1968);
         
    }
}