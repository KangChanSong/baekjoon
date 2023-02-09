package com.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        double max = 0;
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<len ; i++) {
            double s = Double.parseDouble(st.nextToken());
            if (max < s)  max = s;
            sum+=s;
        }
        System.out.println(sum / max / (double) len * 100.0);
    }
}
