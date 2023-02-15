package com.silver5;

public class P4673 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[] chk = new int[10001];
        for (int i = 1; i < chk.length ; i++) {
            if (chk[i] > 0) continue;
            int d = i;
            while (true) {
                d = d + d/10000 + (d%10000)/1000 + (d%1000)/100 + (d%100)/10 + d%10;
                if (d > 10000) break;
                chk[d]++;
            }
        }
        for(int i = 1; i < chk.length ; i++) {
            if (chk[i] == 0) sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
