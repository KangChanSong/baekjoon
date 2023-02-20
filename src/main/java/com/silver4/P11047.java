package com.silver4;

import java.io.*;
import java.util.StringTokenizer;

public class P11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.readLine();

        int[] coins = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
        int res = 0;
        for (int i = 10 - n; i < 10 ; i++) {
            int coin = coins[i];
            while(k >= coin) {
                k -= coin;
                res++;
            }
        }

        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}
