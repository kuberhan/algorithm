package com.kuber.meituan;



import java.util.Scanner;

public class mysticCode {

    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int n = sc1.nextInt();
        int t = sc1.nextInt();
        //n字符串长度，t为1加密或者2解密
        Scanner sc2 = new Scanner(System.in);

        java.lang.String s = sc2.next();//字符串
        char[] sChars = s.toCharArray();
        char[] tChars = new char[n];
        //t=1,加密
        if(t == 1){

            if (n % 2 == 1){
                int mark = (n / 2);
                tChars[0] = sChars[mark];
                int left = mark - 1, right = mark + 1;
                int count = 1;
                while (left >= 0 && right <= n - 1){
                    tChars[count] = sChars[left--];
                    tChars[++count] = sChars[right++];
                    count++;
                }
            }else {
                int mark = (n / 2) - 1;
                int count = 0;
                int left2 = mark, right2 = mark + 1;
                while (left2 >= 0 && right2 <= n - 1){
                    tChars[count] = sChars[left2--];
                    tChars[++count] = sChars[right2++];
                    count++;
                }
            }
        }else { //t=2解密
            if (n % 2 == 1){
                int mark2 = (n / 2);
                tChars[mark2] = sChars[0];
                int left = mark2 - 1, right = mark2 + 1;
                int count = 1;
                while (left >= 0 && right <= n - 1){
                    tChars[left--] = sChars[count];
                    tChars[right++] = sChars[++count];
                    count++;
                }
            }else {
                int mark2 = (n / 2) - 1;
                int count = 0;
                int left2 = mark2, right2 = mark2 + 1;
                while (left2 >= 0 && right2 <= n - 1){
                    tChars[left2--] = sChars[count];
                    tChars[right2++] = sChars[++count];
                    count++;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(tChars[i]);
        }
        System.out.println(stringBuilder);
    }
}
