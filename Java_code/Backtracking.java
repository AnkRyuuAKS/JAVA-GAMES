public class Backtracking{
    public static void changeArr(int arr[],int i,int val){
        //Base case;
        if( i == arr.length){
            printArr(arr);
            return;
        }
        //Recursion(kaam);
        arr[i] = val;
        changeArr(arr,i+1,val+1);//function call
        arr[i] = arr[i] - 2;//backtracking step
    }
    public static void printArr(int arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    //find the number of subsets;
    public static void findSubsets(String str,String ans,int i){
        //Base case
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        //recursion;
        //yes choice:
        findSubsets(str,ans+str.charAt(i),i+1);
        //no choice:
        findSubsets(str,ans,i+1);//Backtracking
    }
    //find permutation;
    public static void findPermutation(String str,String ans1){
        //base case;
        if(str.length()==0){
            System.out.println(ans1);
            return;
        }
        //recursion;
        for(int i=0;i<str.length();i++){
            char curr = str.charAt(i);
            String Newstr = str.substring(0,i) + str.substring(i+1,str.length());
            findPermutation(Newstr,ans1+curr);
        }
    }


   
///////////========= N QUEEN CODE=======////////
  
  
    public static boolean isSafe(char board[][],int row,int col){
        //vertically up;
        for(int i=row-1; i>=0 ;i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //diag left up;
        for(int i=row-1, j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //diag right up;
        for(int i=row-1,j=col+1; i>=0 &&j<=0 ;i--,j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;   
    }
      static int count=0;
    public static void nQueen(char board[][],int row){
        //base case;
        if(row == board.length){
            printBoard(board);
            count++;
            return;
        }
        //column loop;
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueen(board,row+1);//function call
                board[row][j] ='X';//backtracking step
            }
        }

    }
    public static void printBoard(char board[][]){
        System.out.println("-----chess board-----");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
 
 //grid ways;
    
    public static int gridWays(int i,int j,int n1,int m1){
        //base case;
        if(i==n1-1 &&j==m1-1){
            return 1;
        }
        else if(i == n1||j == m1){
            return 0;
        }

        //recursion;
        int w1 = gridWays(i,j+1,n1,m1);//right
        int w2 = gridWays(i+1,j,n1,m1);//down
        return w1+w2;
    }


/////////========SUDOKU PROBLEM========//////////


    public static boolean isSafe(int sudoku[][],int row,int col,int digit){
        //column;
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }

        //row;
        for(int j=0;j<=8;j++){
           if(sudoku[row][j]==digit){
            return false;
           } 
        }

        //grid;
        int sr = (row/3)*3;//starting row
        int sc = (col/3)*3;//starting col
        //3X3 grid
        for(int i=sr;i<=sr+3;i++){
            for(int j=sc;j<=sc+3;j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
       return true; 
    } 
    public static boolean sudokuProbl(int sudoku[][],int row,int col){
        //Base case;
        if(row == 9 ){
            return true;
        }

        //recursion;
        int nextRow = row ; int nextCol = col+1;
        if(col+1==9){
            nextRow = row+1;
            nextCol = 0;
        }
        
        if(sudoku[row][col] != 0){
            return sudokuProbl(sudoku,nextRow,nextCol);
        }
        for(int digit = 1;digit <= 9;digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
                if(sudokuProbl(sudoku,nextRow,nextCol)){//solution exsits
                    return true;
                }
                else{
                    sudoku[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void printSudoku(int sudoku[][]){
        for(int i =0;i<9 ;i++){
            for(int j =0;j<9;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
        int arr[] = new int[5];
        changeArr(arr,0,1);
        printArr(arr);

        String str ="abc";
        findSubsets(str,"",0);

        findPermutation(str,"");

//Placing queens program
        int n = 5;
        char board[][] = new char[n][n];
        //initialize;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'X';
            }
        }

        nQueen(board,0); 
        System.out.println("no. of nQueen board="+count);  

        //Grid Problem:=
        int n1=3,m1=3;
        System.out.println("No. of paths :"+gridWays(0,0,n1,m1));

        //=======sudoku Problem:-
        int sudoku[][] = {{0,0,8,0,0,0,0,0,0},
        {4,9,0,1,5,7,0,0,2},
        {0,0,3,0,0,4,1,9,0},
        {1,8,5,0,6,0,0,2,0},
        {0,0,0,0,2,0,0,6,0},
        {9,6,0,4,0,5,3,0,0},
        {0,3,0,0,7,2,0,0,4},
        {0,4,9,0,3,0,0,5,7},
        {8,2,7,0,0,9,0,1,3} }; 

        if(sudokuProbl(sudoku,0,0)){
            System.out.println("Solution exists");
            printSudoku(sudoku);
        }
        else{
            System.out.println("Solution dosent exists");
        }
         
    }
}