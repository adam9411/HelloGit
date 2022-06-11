package io.leetcode.practices.matrices.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 零矩阵
 * @author dcyu
 * @since 2022-04-09 18:20
 * @url https://leetcode.cn/leetbook/read/array-and-string/ciekh/
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,0,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        setZeroes(matrix);
    }


    static void setZero(int[][] matrix, int y, int x){
        int dp, da, wp, wa;
        dp=da=y;wp=wa=x;
        int d = matrix.length; int w = matrix[0].length;
        while(--dp >= 0){
            matrix[dp][x] = 0;
        }
        while(++da < d){
            matrix[da][x] = 0;
        }
        while(--wp >= 0){
            matrix[y][wp] = 0;
        }
        while(++wa < w){
            matrix[y][wa] = 0;
        }
    }

    static void setZeroes(int[][] matrix) {

        //List<int[]> coordinate = new ArrayList<int[]>();
        List<Integer> y = new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 0) //coordinate.add(new int[]{i,j});
                {
                    if(!y.contains(j)){
                        setZero(matrix, i, j);
                        y.add(j);
                        break;
                    }
                }
            }
        }

        //for(int k=0;k<coordinate.size();k++){
        //    int x = coordinate.get(k)[0];
        //    int y = coordinate.get(k)[1];
        //    for(int i=0;i<matrix.length;i++){
        //        matrix[i][y] = 0;
        //    }
        //    for(int j=0;j<matrix[0].length;j++){
        //        matrix[x][j] = 0;
        //    }
        //}
    }
}
