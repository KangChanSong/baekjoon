package com.bronze;

import java.io.*;

public class Problem1296 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        problem1296_mine(reader, writer);
    }

    public static void problem1296_mine(BufferedReader reader, BufferedWriter writer) throws IOException {
        String yeondoo = reader.readLine();
        int count = Integer.valueOf(reader.readLine());
        String[] teamNames = new String[count];
        for (int i = 0 ; i < count ; i++) {
            teamNames[i] = reader.readLine();
        }

        int[] yeondooCounts = countLOVE(yeondoo);

        String result = null;
        int max = 0;

        for (String team : teamNames) {
            int[] teamCounts = countLOVE(team);
            int calc = calculate(yeondooCounts, teamCounts);

            if (max < calc) {
                max = calc;
                result = team;
            }

            if (max == calc) {
                if (result == null || result.compareTo(team) > 0) {
                    result = team;
                }
            }
        }

        writer.write(result);
        writer.flush();
        writer.close();
    }

    private static int[] countLOVE(String s) {
        int[] loveCounts = new int[4];
        char[] loveChars = "LOVE".toCharArray();
        for(int i = 0; i < loveChars.length ; i++) {
            char alphabet = loveChars[i];
            int count = countChar(alphabet, s);
            loveCounts[i] = count;
        }
        return loveCounts;
    }

    private static int countChar(char c, String s) {
        int cnt = 0;
        for (char fromS : s.toCharArray()) {
            if (c == fromS) cnt++;
        }
        return cnt;
    }

    private static int calculate(int[] yeondooCounts, int[] teamCounts) {
        int L = yeondooCounts[0] + teamCounts[0];
        int O = yeondooCounts[1] + teamCounts[1];
        int V = yeondooCounts[2] + teamCounts[2];
        int E = yeondooCounts[3] + teamCounts[3];

        return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
    }
}