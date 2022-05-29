package com.kuber.algorithmtest;

import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1,3,5,8,9,10,11,23,44,66,88,99,100};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入x：");
        int findNum = scanner.nextInt();
        int[] rearr = binarySearch(arr, findNum);
        if(rearr[1] != 0){
            System.out.println(findNum+"不在数组中，位置i为第"+rearr[0]+"个,位置j为第"+rearr[1]+"个");
        }else{
            System.out.println(findNum+"在数组中，位置i、j重合，为第"+rearr[0]+"个");
        }

    }

    public static int[] binarySearch(int[] arr,int x){
        int i, j;
        int find = -1;//标志位
        int high = arr.length - 1; // 数组的右边界
        int mid;  //中间值的下标
        int low = 0; //数组的左边界
        int[] rearr = new int[2];
        while(low <= high){
            mid = (low + high) / 2;
            if (arr[mid] == x){
                find = mid;
                break;
            }
            else if (x > arr[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        if(find == -1){
            //如果x没有在其中，则执行完，top为底，low为顶，x在中间。
            i = high + 1;
            j = low + 1;
            rearr[0] = i;
            rearr[1] = j;
        }else{
            i = find;
            j = i;
            rearr[0] = j + 1;
            rearr[1] = 0;
        }
        return rearr;
    }
}
