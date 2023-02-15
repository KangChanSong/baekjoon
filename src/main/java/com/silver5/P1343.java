package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1343 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        if (s.length() < 2) {
            if (s.equals("X")) exit();
            else sb.append('.');
        }

        int cnt = 1;
        for (int i = 0 ; i < s.length()-1 ; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i+1);

            if (current == next) {
                cnt++;
            } else {
                append(sb, current, cnt);
                cnt = 1;
            }

            if (i+1 == s.length()-1) {
                append(sb, next, cnt);
            }
        }

        System.out.println(sb);
    }

    private static void append(StringBuilder sb, char c, int cnt) {
        if (c == 'X') {
            if (cnt % 2 != 0) exit();
            for(int i = 1 ; i <= cnt / 4 ; i++) sb.append("AAAA");
            if (cnt % 4 != 0) sb.append("BB");
        } else {
            for(int i = 1 ; i <= cnt; i++) sb.append('.');
        }
    }
    private static void exit() {
        System.out.println(-1);
        System.exit(0);
    }
}
