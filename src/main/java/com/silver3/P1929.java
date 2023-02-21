package com.silver3;

import java.io.*;
import java.util.StringTokenizer;

public class P1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        int[] dp = new int[max+1];

        for(int i = 2; i < dp.length ; i++) {
            if (dp[i] == 1) continue;
            for(int j = 2 ; i * j < dp.length ; j++) {
                if (dp[i*j] == 1) continue;
                dp[i*j] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = min; i < dp.length; i++) {
            if (i > 1 && dp[i] == 0) sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
