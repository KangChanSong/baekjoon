package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i < Integer.MAX_VALUE ; i++) {
            sum += i;
            if (sum >= num) printAnswer(i,num - (sum - i));
        }
    }
    private static void printAnswer(int i, int n) {
        if (i%2!=0) System.out.printf("%d/%d", i-n+1, n);
        else System.out.printf("%d/%d", n, i-n+1);
        System.exit(0);
    }
}
