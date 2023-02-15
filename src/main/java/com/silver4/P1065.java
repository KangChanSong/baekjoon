package com.silver4;

import java.io.*;

public class P1065 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int res = 99;
        for (int i = 100; i <= n ; i++) {
            int h = i / 100;
            int te =  (i % 100) / 10;
            int o = (i % 100) % 10;
            if (h - te == te - o) res++;
        }
        bw.write(String.valueOf(n < 100 ? n : res));
        bw.flush();
        bw.close();
        br.close();
    }
}
