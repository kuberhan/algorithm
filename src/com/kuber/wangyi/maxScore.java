package com.kuber.wangyi;

import java.util.Scanner;

public class maxScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String scannerString = scanner.next();
        char[] chars = scannerString.toCharArray();
        int[] res = new int[chars.length];
        int result = 0;
        int mark = 0;
        res[0] = chars[0] - 96;
        for (int i = 1; i < chars.length; i++) {
            if (Math.abs(chars[i] - chars[i-1]) == 1 || chars[i] == chars[i-1]){
                res[i] = Math.max(res[i-1], chars[i-1] + chars[i] - 192);
                mark = res[i];
            }else{
                result += mark;
                mark = 0;
                res[i] =  chars[i] - 96;
            }
        }
        System.out.println(result+mark);
    }
}
