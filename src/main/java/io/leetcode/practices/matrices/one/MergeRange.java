package io.leetcode.practices.matrices.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * @author dcyu
 * @since 2022-04-06 22:17
 * @url https://leetcode.cn/leetbook/read/array-and-string/c5tv3/
 */
public class MergeRange {

    public static void main(String[] args) {
        //int[][] in //= {{1,3},{15,18},{2,6},{8,10}};
        int[][] in = {{2,3},{5,5},{2,2},{3,4},{3,4}};
        merge(in);
    }

//    static int[][] copy(int[][] src,int[] e){
//        int[][] tmp = new int[src.length + 1][];
//        for(int i=0;i<src.length;i++){
//            tmp[i] = src[i];
//        }
//        tmp[src.length] = e;
//        return tmp;
//    }

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<int[]>();
        // merge
        int[] tmp = intervals[0];
        for(int k=1;k<intervals.length;k++){

            if(tmp[1] < intervals[k][0]){
                result.add(tmp);
                tmp = intervals[k];
            }else{
                tmp[1] = Math.max(tmp[1], intervals[k][1]);
            }
        }
        result.add(tmp);
        return result.toArray(new int[result.size()][2]);
    }

//    static int[][] sort(int[][] intervals, int l, int r){
//        if(r-l==0) return new int[][]{intervals[l]};
//        int mid = (r - l)/2 + l;
//
//        int[][] left = sort(intervals, l, mid);
//        int[][] right = sort(intervals, mid+1, r);
//
//        return sort_merge(left, right);
//
//    }
//
//    static int[][] sort_merge(int[][] l, int[][] r){
//        int[][] tmp = new int[l.length + r.length][];
//        int i=0,j=0;
//        for(int k=0;i<l.length||j<r.length;k++){
//            if(i >= l.length){
//                tmp[k] = r[j];
//                j++;
//            }else if(j >= r.length){
//                tmp[k] = l[i];
//                i++;
//            }else if(l[i][0] < r[j][0]){
//                tmp[k] = l[i];
//                i++;
//            }else {
//                tmp[k] = r[j];
//                j++;
//            }
//        }
//        return tmp;
//    }
}
