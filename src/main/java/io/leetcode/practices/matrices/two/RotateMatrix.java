package io.leetcode.practices.matrices.two;

/**
 * 旋转矩阵
 * @author dcyu
 * @since 2022-04-09 12:56
 * @url https://leetcode.cn/leetbook/read/array-and-string/clpgd/
 */
public class RotateMatrix {
    public static void main(String[] args) {

        int[][] matrix = {
                {1,2,3},{4,5,6},{7,8,9}
        };

//        int[][] matrix = {
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

        visulMatrix(matrix);

        rotate(matrix);
    }


    static void rotate(int[][] matrix){
//        plan A
//        int[][] result = new int[matrix.length][matrix[0].length];
//        for(int i=0;i<matrix.length;i++){
//            int[] row = matrix[i];
//            int col = matrix.length - 1 - i;
//            for(int j=0;j<row.length;j++){
//                result[j][col] = row[j];
//            }
//        }

//        plan B
        for(int i=0;i<(matrix.length+1)/2;i++){

            int y = matrix.length - 1 - i;
            for(int j=0;j<(matrix[i].length)/2;j++){
                int x = matrix[i].length - 1 - j;
                // ij i-j -i-j -ij
                // ij ix yx yj
                int a = matrix[i][j];
                int b = matrix[j][y];
                int c = matrix[y][x];
                int d = matrix[x][i];

                matrix[j][y] = a;
                matrix[y][x] = b;
                matrix[x][i] = c;
                matrix[i][j] = d;

            }
        }
        visulMatrix(matrix);
    }

    static void visulMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            int[] e = matrix[i];
            for(int j=0;j<e.length;j++){
                System.out.print(" "+e[j]+" ");
            }
            System.out.println(" ");
        }
        System.out.println("-----------");
    }
}
