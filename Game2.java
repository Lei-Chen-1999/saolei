package com.saolei;

import java.util.Scanner;

public class Game2 {

    public static void main(String[] args){
        System.out.println("请选择游戏难度(输入数字 1 or 2 or 3)：" +
                "\n1：9*9；" + "\n2：16*16；" + "\n3：16*30；" + "\n输入-1退出。");
        System.out.print("\n您选择的是：");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input != 1 & input != 2 & input != 3 ) {
            System.out.println("请输入1或2或3");
            System.out.print("您选择的是：");
            input = scanner.nextInt();
        }
        setBomb(input);
    }

    private static void setBomb(int input) {
        int rows, cols, bombCount;
        if (input == 1) {
            rows = 9;
            cols = 9;
            bombCount = 10;
            rBomb(rows, cols, bombCount);
        } else if (input == 2) {
            rows = 16;
            cols = 16;
            bombCount = 40;
            rBomb(rows, cols, bombCount);
        } else if (input == 3) {
            rows = 16;
            cols = 30;
            bombCount = 99;
            rBomb(rows, cols, bombCount);
        }
    }

    //TODO: 随机生成雷
    private static void rBomb(int rows, int cols, int bombCount) {
        String[][] labels;
        int newRows = rows - 1;
        int newCols = cols - 1;
        labels = new String[rows][cols];
        for (int i = 0; i < bombCount; i++) {
            int rRow = (int) (Math.random() * rows);
            int rCol = (int) (Math.random() * cols);
            labels[rRow][rCol] = "*";
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (labels[i][j] != "*"){
                    {
                        if (i == 0) {
                            if (j == 0) {
                                int count = 0;
                                if (labels[0][1] == "*") count++;
                                if (labels[1][0] == "*") count++;
                                if (labels[1][1] == "*") count++;
                                labels[i][j] = count + "";
                            } else if (j == newCols) {
                                int count = 0;
                                if (labels[0][j - 1] == "*") count++;
                                if (labels[1][j - 1] == "*") count++;
                                if (labels[1][j] == "*") count++;
                                labels[i][j] = count + "";
                            } else {
                                int count = 0;
                                if (labels[i][j - 1] == "*") count++;
                                if (labels[i][j + 1] == "*") count++;
                                if (labels[i + 1][j - 1] == "*") count++;
                                if (labels[i + 1][j] == "*") count++;
                                if (labels[i + 1][j + 1] == "*") count++;
                                labels[i][j] = count + "";
                            }
                        } else if (i == newRows) {
                            if (j == 0) {
                                int count = 0;
                                if (labels[7][0] == "*") count++;
                                if (labels[7][7] == "*") count++;
                                if (labels[8][1] == "*") count++;
                                labels[i][j] = count + "";
                            } else if (j == newCols) {
                                int count = 0;
                                if (labels[7][7] == "*") count++;
                                if (labels[7][8] == "*") count++;
                                if (labels[8][7] == "*") count++;
                                labels[i][j] = count + "";
                            } else {
                                int count = 0;
                                if (labels[i - 1][j - 1] == "*") count++;
                                if (labels[i - 1][j] == "*") count++;
                                if (labels[i - 1][j + 1] == "*") count++;
                                if (labels[i][j - 1] == "*") count++;
                                if (labels[i][j + 1] == "*") count++;
                                labels[i][j] = count + "";
                            }
                        }
                    }//TODO:边角
                    {
                        if ( i != 0 && i != newRows ) {
                            if (j == 0) {
                                int count = 0;
                                if (labels[i - 1][j] == "*") count++;
                                if (labels[i - 1][j + 1] == "*") count++;
                                if (labels[i][j + 1] == "*") count++;
                                if (labels[i + 1][j] == "*") count++;
                                if (labels[i + 1][j + 1] == "*") count++;
                                labels[i][j] = count + "";
                            } else if (j == newCols && i != 0) {
                                int count = 0;
                                if (labels[i - 1][j - 1] == "*") count++;
                                if (labels[i - 1][j] == "*") count++;
                                if (labels[i][j - 1] == "*") count++;
                                if (labels[i + 1][j - 1] == "*") count++;
                                if (labels[i + 1][j] == "*") count++;
                                labels[i][j] = count + "";
                            } else {
                                int count = 0;
                                if (labels[i - 1][j - 1] == "*") count++;
                                if (labels[i - 1][j] == "*") count++;
                                if (labels[i - 1][j + 1] == "*") count++;
                                if (labels[i][j - 1] == "*") count++;
                                if (labels[i][j + 1] == "*") count++;
                                if (labels[i + 1][j - 1] == "*") count++;
                                if (labels[i + 1][j] == "*") count++;
                                if (labels[i + 1][j + 1] == "*") count++;
                                labels[i][j] = count + "";
                            }
                        }
                    }//TODO:内部
                }
                System.out.print(labels[i][j]+" ");
            }
            System.out.println();
        }
    }


}
