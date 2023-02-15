package com.silver4;

import java.io.*;

public class P9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < len ; i++) {
            String ps = br.readLine();
            int res = 0;
            for (char c : ps.toCharArray()) {
                if (c == '(') res--;
                else res++;
                if (res > 0) break;
            }
            sb.append(res == 0 ? "YES" : "NO").append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
