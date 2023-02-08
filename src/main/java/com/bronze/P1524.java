package com.bronze;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1524 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseCount = parseInt(reader.readLine());
        String[] results = new String[caseCount];
        for (int i = 0 ; i < caseCount ; i++) {
            results[i] = solve(reader);
        }
        for (String winner : results) {
            System.out.println(winner);
        }
        writer.flush();
        writer.close();
    }

    private static String solve(BufferedReader reader) throws IOException {
        reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int sCnt = parseInt(tokenizer.nextToken());
        int bCnt = parseInt(tokenizer.nextToken());

        int[] sArmy = getArmyInput(reader, sCnt);
        int[] bArmy = getArmyInput(reader, bCnt);

        return chooseWinner(sArmy, bArmy);
    }

    private static String chooseWinner(int[] sArmy, int[] bArmy) {
        int sS = getStrongestOne(sArmy);
        int bS = getStrongestOne(bArmy);
        if (sS >= bS) {
            return "S";
        }
        return "B";
    }

    private static int getStrongestOne(int[] armies) {
        int max = 0;
        for (int army : armies) {
            if (max < army) max = army;
        }
        return max;
    }

    private static int[] getArmyInput(BufferedReader reader, int cnt) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] armies = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            armies[i] = parseInt(tokenizer.nextToken());
        }

        return armies;
    }
}
