package com.silver4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[len];
        for (int i = 0 ; i < len ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0 ; i < len ; i++) {
            int sum = 0;
            for (int j = 0; j <= i ; j++) {
                sum += arr[j];
            }
            res += sum;
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}
