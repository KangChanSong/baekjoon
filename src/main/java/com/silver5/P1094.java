package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class P1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int num : new int[]{64,32,16,8,4,2,1}) {
            if (num > target) continue;
            count++;
            target -= num;
            if (target <= 0) break;
        }
        System.out.println(count);
    }
}
