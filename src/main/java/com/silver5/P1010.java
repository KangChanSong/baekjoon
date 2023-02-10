package com.silver5;

import java.io.*;
import java.util.Arrays;

public class P1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = toInt(br.readLine());
        int[] results = new int[len];
        for(int i = 0 ; i < len ; i ++) {
            String[] sights = br.readLine().split(" ");
            int west = Integer.parseInt(sights[0]);
            int east = Integer.parseInt(sights[1]);

            int[] arr = new int[east - west + 1];
            Arrays.fill(arr, 1);
            results[i] = solve(west, arr, 1);
        }

        for(int r : results) {
            bw.write(r + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static int solve(int limit, int[] arr, int count) {
        int temp;
        for (int i = 0 ; i  < arr.length ; i++) {
            temp = 0;
            for (int j = i ; j < arr.length ; j++) {
                temp += arr[j];
            }
            arr[i] = temp;
        }

        if (count == limit) {
            return arr[0];
        }
        return solve(limit, arr, ++count);
    }

    private static int toInt(String s){
        return Integer.parseInt(s);
    }
}
