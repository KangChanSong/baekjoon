package com.bronze;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int caseCount = parseInt(reader.readLine());
        String[] results = new String[caseCount];
        for (int i = 0 ; i < caseCount ; i++) {
            results[i] = solve(reader);
        }
        for (String winner : results) {
            System.out.println(winner);
        }
    }

    private static String solve(BufferedReader reader) throws IOException {
        reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int sCnt = parseInt(tokenizer.nextToken());
        int bCnt = parseInt(tokenizer.nextToken());

        int sMax = getStrongestFrom(reader, sCnt);
        int bMax = getStrongestFrom(reader, bCnt);

        if (sMax >= bMax) return "S";
        return "B";
    }
    private static int getStrongestFrom(BufferedReader reader, int cnt) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int max = 0;
        for (int i = 0; i < cnt; i++) {
            int army = parseInt(tokenizer.nextToken());
            if (max < army) max = army;
        }
        return max;
    }
}
