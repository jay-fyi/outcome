package outco.outcome.util;

import java.util.Arrays;

public class KnapsackMatrixPrinter {

    public static void print(String msg, int[][] matrix, int[] profits, int[] weights){

        System.out.println(msg);
        System.out.println("P, W, I, Cap ---------------->");
        System.out.println("-, -, 0, " + Arrays.toString(matrix[0]));
        for(int row = 1; row < matrix.length; row++){
            System.out.println(profits[row-1] + ", " + weights[row-1] + ", " + row +", "+ Arrays.toString(matrix[row]));
        }
        System.out.println();

    }

    public static void print(String msg, boolean[][] matrix, int[] nums){

        System.out.println(msg);
        System.out.println("N, I, Sum ---------------->");
        System.out.println("-, 0, " + Arrays.toString(matrix[0]));
        for(int row = 1; row < matrix.length; row++){
            System.out.println( nums[row-1] + ", " + row +", "+ Arrays.toString(matrix[row]));
        }
        System.out.println();

    }
}
