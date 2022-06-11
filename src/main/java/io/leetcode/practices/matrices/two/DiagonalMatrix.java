package io.leetcode.practices.matrices.two;

/**
 * 对角线遍历
 * @author dcyu
 * @since 2022-04-09 18:52
 * @url https://leetcode.cn/leetbook/read/array-and-string/cuxq3/
 */
public class DiagonalMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},{4,5,6},{7,8,9}
        };
        findDiagonalOrder(matrix);
    }

    static int[] findDiagonalOrder(int[][] mat){
        int M = mat.length; int N = mat[0].length;
        int[] result = new int[M * N];
        int x=0,y=0;// x 二维 y 一维
        boolean c = false;int sum=0;
        for(int j=0;j<M*N;j++){
//            if(x+y > sum){
//                sum = x+y;
//                c = !c;
//            }
            result[j] = mat[y][x];
            System.out.println(mat[y][x]);
            if((x+y)%2 == 1){// 左下角方向
//                if(x > 0) x--;
//                if(y < M - 1) y++;
                // 判断向下还是向右
                if(y == M - 1){
                    x++;
                }else{
                    if(x > 0) x--;
                    if(y < M - 1) y++;
                }
            }else{// 右上角方向
//                if(x < N - 1) x++;
//                if(y > 0) y--;
                // 判断向右还是向下
                if(x == N - 1){
                    y++;
                }else{
                    if(x < N - 1) x++;
                    if(y > 0) y--;
                }
            }
        }

        return result;
    }
}
