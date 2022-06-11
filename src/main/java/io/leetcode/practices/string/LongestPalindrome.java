package io.leetcode.practices.string;

/**
 * @author dcyu
 * @since 2022-04-10 13:12
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "bcca";//"babad";
        longestPalindrome(s);
    }

    /**
     * 最长回文子串
     * @param s
     * @return java.lang.String
     * @url https://leetcode.cn/leetbook/read/array-and-string/conm7/
     */
    static String longestPalindrome(String s) {
//        奇数有效
//        int i=0,j=0;// i 第几个字符 j 回文长度
//        for(int k=0;k<s.length();k++){
//            for(int l=0;l<=Math.min(k, s.length()-1-k);l++){
//                if(s.charAt(k + l) == s.charAt(k - l)){
//                    System.out.println(k +""+ s.charAt(k) + "" + l);
//                    if(j<l){
//                        j=l;
//                        i=k;
//                    }
//                }else break;
//            }
//            if(s.length()-1-k <= j) return s.substring(i-j, i+j+1);
//        }
//        return s.substring(i-j, i+j+1);


        int[] index = new int[]{0,0};
        for(int k=0;k<s.length();k++){
            int[] x = g(s, k, k);
            if(x[1] - x[0] > index[1] - index[0]){
                index = x;
            }

            int[] y = g(s, k, k+1);
            if(y[1] - y[0] > index[1] - index[0]){
                index = y;
            }
        }
        return s.substring(index[0], index[1]);
    }

    static int[] g(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;r++;
        }
        return new int[]{l+1, r};
    }
}
