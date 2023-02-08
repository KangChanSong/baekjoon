package com.bronze;

import java.io.*;

public class P1373 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] nums = toIntArray(reader.readLine());
        writer.write(binaryToOctal(nums));
        writer.flush();
        writer.close();
    }

    private static int[] toIntArray(String input) {
        char[] chars = input.toCharArray();
        int[] nums = new int[chars.length];
        for(int i = 0 ; i < chars.length ; i++) {
            nums[i] = chars[i] - '0';
        }
        return nums;
    }

    private static String binaryToOctal(int[] nums) {
        int[] arr = new int[(nums.length / 3) + (nums.length % 3 == 0 ? 0 : 1)];
        for(int i = 0 ; i < nums.length ; i++) {
            int power = nums.length - i - 1;
            if (nums[i] == 1) {
                if (power < 3 ) {
                    arr[0] += Math.pow(2, power);
                    continue;
                }
                arr[power / 3] += Math.pow(2, power % 3);
            }
        }

        StringBuilder builder = new StringBuilder();
        for(int i = arr.length - 1 ; i >= 0 ; i--) {
            builder.append(arr[i]);
        }
        return builder.toString();
    }

}
