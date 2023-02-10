package com.silver5;

import java.io.*;

public class P1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        String[] r = new String[len];

        // Arrays.sort 사용하면 금방 해결될 문제였음...
        for (int i = 0;  i < len ; i++ ) {
            String input = br.readLine();
            r[i] = input;
            if (i == 0) continue;
            int x = i;
            while (x-1 >=0 && !isPreceding(r[x-1], r[x]) ) {
                changePosition(r, x);
                x--;
            }
        }

        String curr = "";
        for (String res : r) {
            if (curr.equals(res)) continue;
            curr = res;
            bw.write(res + "\n");
        }
        bw.flush();
        bw.close();
    }

    static boolean isPreceding(String s1, String s2) {
        if (s1.length() < s2.length()) return true;
        if (s1.length() == s2.length()) return s1.compareTo(s2) < 0;
        return false;
    }

    static void changePosition(String[] r, int x) {
        String tmp = r[x];
        r[x] = r[x -1];
        r[x -1] = tmp;
    }
}
