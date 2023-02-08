package com.bronze;

import java.io.*;

public class P1356 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        problem1356(reader, writer);
    }

    private static void problem1356(BufferedReader reader, BufferedWriter writer) throws IOException {
        int[] nums = toIntArr(reader.readLine());

        String res = "NO";

        for (int x = 0 ; x < nums.length ; x++) {
            int f = 1;
            int b = 1;
            for (int i = 0 ; i <= x ; i++) {
                f*= nums[i];
            }
            for (int j = x+1 ; j < nums.length ; j++) {
                b*= nums[j];
            }

            if (f == b) res = "YES";
        }

        writer.write(nums.length == 1 ? "NO" : res);
        writer.flush();
        writer.close();
    }

    private static int[] toIntArr(String input) {
        char[] chars = input.toCharArray();
        int[] nums = new int[chars.length];

        for (int i = 0 ; i < chars.length ; i++) {
            nums[i] = chars[i] - '0';
        }

        return nums;
    }
}