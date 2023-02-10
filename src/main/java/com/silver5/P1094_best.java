package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1094_best {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(reader.readLine());
        System.out.println(Integer.bitCount(target));
    }
}
