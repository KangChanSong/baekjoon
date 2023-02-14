package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        int res = len;

        for(int i = 0 ; i < len ; i++) {
            String input = br.readLine();
            int[] chk = new int[122 - 95];
            for (int j = 1 ; j <= input.length() ; j++) {
                int c = input.charAt(j-1);
                int before = chk[c-96];
                if (j - before > 1 && before != 0) {
                    res--;
                    break;
                } else {
                    chk[c-96] = j;
                }
            }
        }

        System.out.println(res);
    }
}
