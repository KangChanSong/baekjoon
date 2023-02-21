package com.silver3;

import java.io.*;

public class P1463 {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        solve(n, 0);
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
    private static void solve(int n, int cnt) {
        if (cnt > res) return;
        if (n == 1) {
            res = Math.min(cnt, res);
            return;
        }
        cnt++;
        if (n % 3 == 0) solve(n / 3, cnt);
        if (n % 2 == 0) solve(n / 2, cnt);
        solve(n - 1, cnt);
    }
}
