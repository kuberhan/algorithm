package com.kuber.leetcode.swordtooffer;


import org.junit.Test;

/*剑指 Offer 05. 替换空格*/
public class exam05 {
    public String replaceSpace(String s) {
        String newS = s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                newS = newS + "  ";
            }
        }
        char[] words = newS.toCharArray();
        int left = s.length() - 1;
        int right = words.length - 1;
        while (right > left){
            while (left >= 0 && words[left] == ' '){
                int i = 0;
                words[right--] = '0';
                words[right--] = '2';
                words[right--] = '%';
                left--;
            }
            if (left < 0) break;
            words[right] = words[left];
            right--;
            left--;
        }
        return new String(words) ;
    }

    //优化代码
    public String replaceSpace2(String s) {
        String newS = s;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                newS = newS + "  ";
            }
        }
        char[] words = newS.toCharArray();
        int left = s.length() - 1;
        int right = words.length - 1;
        while (left >= 0 && right > left){
            if (words[left] == ' '){
                int i = 0;
                words[right--] = '0';
                words[right--] = '2';
                words[right--] = '%';
            }else {
                words[right] = words[left];
                right--;
            }
            left--;
        }
        return new String(words) ;
    }

    /*直接用java自带的StringBuilder*/
    public String replaceSpace3(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }

        return res.toString();
    }

    @Test
    public void test(){
        String s = " We  are happy. ";
        System.out.println(replaceSpace3(s));
    }
}
