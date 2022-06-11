package io.leetcode.practices.string;

/**
 * @author dcyu
 * @since 2022-04-10 13:12
 */
public class StrStr {

    public static void main(String[] args) {
        strStr("mississippi","issipi");
    }

    /**
     * 实现strStr()
     * @param haystack
     * @param needle
     * @return int
     * @url https://leetcode.cn/leetbook/read/array-and-string/cm5e2/
     */
    static int strStr(String haystack, String needle) {
        if(needle.trim().length() == 0) return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            int j=0;
            while(j < needle.length() && haystack.charAt(i+j) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length())
                return i;
        }
        return -1;
    }
}
