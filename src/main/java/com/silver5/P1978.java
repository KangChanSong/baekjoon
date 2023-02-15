package com.silver5;

import java.io.*;
import java.util.StringTokenizer;

public class P1978 {
    public static void main(String[] args) throws IOException {
        boolean[] sosus = new boolean[1001];
        sosus[1]=true;
        for(int i = 2 ; i <= 1000 ; i++) {
            if (sosus[i]) continue;
            for (int j = i ; i*j <= 1000; j++) {
                if (sosus[i*j]) continue;
                sosus[i*j] = true;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int res = 0;
        for (int i = 0 ; i < n ; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (!sosus[input]) res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}
