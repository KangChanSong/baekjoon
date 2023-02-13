package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int res = 0;
        if (a % b == 0) {
            System.out.println(res);
            System.exit(0);
        }

        for(int i = 1 ; i <= n ; i++) {
            res = a % b != 0 ? a % b * 10 / b : 0;
            if (i == n || a == 0) {
                System.out.println(res);
                break;
            }
            a = a % b * 10;
        }
    }
}
