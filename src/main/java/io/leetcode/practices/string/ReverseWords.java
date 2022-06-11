package io.leetcode.practices.string;

import java.util.Stack;

/**
 * @author dcyu
 * @since 2022-04-10 13:12
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = " the sky is blue ";//"hello world ";
        reverseWords(s);
    }

    /**
     * 翻转字符串单词
     * @param s
     * @return java.lang.String
     * @url https://leetcode.cn/leetbook/read/array-and-string/crmp5/
     */
    static String reverseWords(String s) {

        Stack<String> stack = new Stack();
        StringBuilder clist = new StringBuilder(16);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c != ' ') clist.append(c);
            if(c == ' ' || i == s.length() - 1){
                String s1 = clist.toString().trim();
                if(s1.length() > 0){
                    stack.push(clist.toString());
                    if(i < s.length()-1){
                        clist = new StringBuilder(16);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder(16);
        while(!stack.empty()){
            String n = stack.pop();
            if(n != null && n.trim() != ""){
                sb.append(n);
                if(!stack.empty()){
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
