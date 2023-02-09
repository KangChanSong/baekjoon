package com.bronze;

import java.io.*;

public class P1526 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        N = toInt(reader.readLine());
        System.out.println(N < 7 ? 4 : Math.max(solve("4"), solve("7")));
    }
    private static int solve(String s) {
        int n1 = toInt(s + "4");
        int n2 = toInt(s + "7");
        if (n1 > N) return Integer.parseInt(s);
        else if (n2 > N) return n1;
        return Math.max(solve(s + "4"), solve(s + "7"));
    }
    private static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
