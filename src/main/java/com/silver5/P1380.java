package com.silver5;

import java.io.*;
import java.util.StringTokenizer;

public class P1380 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 1;
        StringBuilder sb = new StringBuilder();

        int caseNum = 0;
        while (n > 0) {
            caseNum++;
            n = Integer.parseInt(br.readLine());
            String[] stus = new String[n+1];
            int[] chk = new int[n+1];
            for (int i = 1 ; i <= n ; i ++) {
                stus[i] = br.readLine();
            }
            for (int i = 1; i <= n*2-1 ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                //int sn = Integer.parseInt(br.readLine().split(" ")[0]);
                chk[Integer.parseInt(st.nextToken())]++;
            }
            for (int i = 1 ; i < chk.length ; i++) {
                //if (chk[i] < 2) sb.append(caseNum).append(" ").append(stus[i]).append("\n");
                if (chk[i] < 2) sb.append(caseNum).append(" ").append(stus[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
