package com.kuber.common;

import java.util.Scanner;

public class MaxMatrix {

    /*int m[101][101];//有向图的邻接矩阵*/
    public static int[][] m = new int[101][101];
    /*int x[101];//当前团的解*/
    public static int[] x = new int[101];
    /*int bestx[101];//最优解*/
    public static int[] bestx = new int[101];
    public static int n;//表示图的顶点数
    public static int cn = 0;//当前团的大小
    public static int bestn;//当前最优值

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图的顶点数：");
        n = scanner.nextInt();
        System.out.println("请输入图的邻接矩阵：");
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        getBestn(1);
        System.out.println("最优解即最大团的顶点数为："+bestn);
        System.out.print("顶点分别为：");
        for (int i = 1; i <= n; i++) {
            if(bestx[i] == 1){
                System.out.print(i+" ");
            }
        }
    }
    public static void getBestn(int i) {

        if(i > n){//递归出口，到根节点时，更新最优值和最优解，返回
            bestn = cn;//更新最优值
            for(int j = 1; j <= n; j++)
                bestx[j] = x[j];
            return ;//返回
        }
        x[i] = 1;//先假定x[i]=0;
        for(int j = 1; j < i; j++){
            if(x[j] == 1 && m[i][j] == 0){
                x[i] = 0;//如果该点与已知解中的点无边相邻
                break;//则不遍历左子树
            }
        }
        if(x[i] == 1){
            //当且仅当x[i]==1时，遍历左子树
            cn++;//该点加入当前解
            getBestn(i+1);//递归调用
            cn--;//还原当前解
        }
        x[i] = 0;//假定x[i]==0
        if((cn+n-i) > bestn){//如果当前值+右子树可能选择的节点<当前最优解，不遍历左子树
            x[i] = 0;
            getBestn(i+1);
        }
    }
}
