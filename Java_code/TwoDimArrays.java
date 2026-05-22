import java.util.*;
public class TowDimArrays{
    //OUTPUT
    public static void printArry(int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
        }
    }
    //Spiral Matrix;
    public static void spiralMatrix(int matrix[][]){
        int startRow=0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while(startRow <= endRow && startCol <= endCol){
            //top
            for(int j = startCol;j<=endCol;j++){
                System.out.print(matrix[startRow][j] +" ");
            }
            //right
            for(int i = startRow + 1;i<=endRow;i++){
                System.out.print(matrix[i][endCol] +" ");
            }
            //bottom
            for(int j = endCol -1;j>=startCol;j--){
                System.out.print(matrix[endRow][j] +" ");
                if(startRow == endCol){
                    break;
                }
            }
            //left
            for(int i = endRow -1;i>=startCol+1;i--){
                System.out.print(matrix[i][startCol] +" ");
                if(startCol == endCol){
                    break;
                }
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }
    public static int diagoMatrix(int matrix[][]){//0(n^2)

    int sum =0;

    // for (int i =0;i<matrix.length;i++){
    //     for(int j=0;j<matrix[0].length;j++){
    //         if(i==j){
    //            sum+=matrix[i][j];
    //         }
    //         else if(i+j == matrix.length-1){
    //             sum += matrix[i][j];
    //         }
    //     }
    // }
    //     return sum;

    for(int i=0;i<matrix.length;i++){
        //pd
        sum+= matrix[i][i];
        //sd
        if(i != matrix.length-1-i){
        sum+= matrix[i][matrix.length-i-1];
        } 
    }
    System.out.println(sum);
    return sum;

    }
    //Searching in 2D Arrays:-
    public static boolean stairSearch(int matrix1[][],int key){
        int row = 0; int col = matrix1[0].length - 1;

        while(row < matrix1.length && col >= 0){
            if(matrix1[row][col] == key){
                System.out.println("found key at"+"("+ row +"," + col + ")");
                return true;
            }
            else if(key < matrix1[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }
    //Print the number of elements in the array:-
    public static void numElemt(int arrys[][],int key){
        int count = 0;
        for(int i =0;i<arrys.length;i++){
            for(int j =0;j<arrys[0].length; j++){
                if(arrys[i][j] == key){
                    count++;
                }
            }
        }
        System.out.println("no.of elemts of"+ key + "is: " +count );
    }
    //Print out the sum of numbers in second row:-
    public static int sumOfsecndRow(int nums[][]){
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum += nums[1][i];
        }
        System.out.println(sum);
        return sum;
    }
    //Transpose of a Matrix:-
    public static void transpose(int matrix[][]){
        int row = 4 ;int column = 4;
        int transpose[][] = new int[column][row];
        for(int i =0;i<row;i++){
            for(int j = 0; j<column ;j++){
                transpose[j][i] = matrix[i][j];
            }
        }
    }
    public static void printtranspose(int transpose[][]){
    for(int i=0;i<4;i++){
        for(int j = 0;j<4;j++){
            System.out.println(transpose[i][j]);
        }
    }
    }
    public static void main(String args[]){
        int matrix[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printArry(matrix);
        spiralMatrix(matrix);
        diagoMatrix(matrix);

       int matrix1[][]={{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
       stairSearch(matrix1,7);

        int arrys[][] = {{4,7,8},{8,8,7}};
        numElemt(arrys,7);

        int nums[][] = {{1,4,9},{11,4,3},{2,2,3}};
        sumOfsecndRow(nums);

        int transpose[][] = transpose(matrix);
        printtranspose(transpose);

    }
}