package com.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Bronze1Problems {
    public static void problem1032(BufferedReader reader, BufferedWriter writer) throws IOException {
        int size = Integer.parseInt(reader.readLine());

        char[] result = reader.readLine().toCharArray();

        for (int i = 1 ; i < size ; i++) {
            char[] chars = reader.readLine().toCharArray();
            for (int j = 0 ; j < chars.length ; j++) {
                if (result[j] != chars[j]) {
                    result[j] = '?';
                }
            }
        }

        writer.write(String.valueOf(result));
        writer.close();
    }

    public static void problem1110(BufferedReader reader, BufferedWriter writer) throws IOException {
        int number = Integer.parseInt(reader.readLine());

        int count = 0;
        int calc = number;
        while (true) {
            count++;
            int front = calc / 10;
            int back = calc % 10;

            int newBack = (front + back) % 10;
            calc = (back * 10) + newBack;
            if (calc == number) break;
        }

        writer.write(String.valueOf(count));
        writer.close();
    }

    public static void problem1145(BufferedReader reader, BufferedWriter writer) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] numbers = new int[5];
        for (int i = 0 ; i < 5 ; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 1; i < 1000000 ; i++) {
            int divCount = 0;
            for (int number : numbers) if (i % number == 0) divCount++;

            if (divCount > 2) {
                writer.write(String.valueOf(i));
                writer.flush();
                writer.close();
                return;
            }
        }
    }
}
