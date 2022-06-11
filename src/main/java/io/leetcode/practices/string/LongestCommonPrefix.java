package io.leetcode.practices.string;

/**
 * @author dcyu
 * @since 2022-04-10 13:12
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"cir", "cat"};//new String[]{"flower", "flow", "flight"};
        longestCommonPrefix(strs);
    }

    /**
     * 最长公共前缀
     * @param strs
     * @return java.lang.String
     * @url https://leetcode.cn/leetbook/read/array-and-string/ceda1/
     */
    static String longestCommonPrefix(String[] strs) {

        String result = strs[0];
        for(int i=1;i<strs.length;i++){
            int index=0;
            for(int j=0;j<Math.min(strs[i].length(), result.length());j++){
                if(strs[i].charAt(j) == result.charAt(j)) index++;
                else break;
            }
            result = result.substring(0, index);
        }
        return result;
    }
}
