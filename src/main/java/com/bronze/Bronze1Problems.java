package com.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

    public static void problem1157_mine(BufferedReader reader, BufferedWriter writer) throws IOException {
        char[] alphs = reader.readLine().toUpperCase().toCharArray();

        Map<Character, Integer> map = new HashMap<>();

        for(char c : alphs) {
            if (map.containsKey(c)) {
                Integer value = map.get(c);
                map.put(c, ++value);
            } else {
                map.put(c, 1);
            }
        }

        char result = ' ';
        int maxCount = 0;
        for(Object key : map.keySet().toArray()) {
            char keyChar = (char) key;
            Integer currVal = map.get(keyChar);
            if (currVal == maxCount) {
                result = '?';
            }

            if (currVal > maxCount) {
                result = keyChar;
                maxCount = currVal;
            }
        }

        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
    }

    // ASCII CODE
    // a,b,c...  = 97,98,99...
    // A,B,C...  = 65,66,67...
    // ?         = 63
    public static void problem1157_best() throws IOException {
        int[] a = new int[26]; // 0 = A, 1 = B, 2 = C...
        int c, max = 0, maxa = -2;

        while ((c = System.in.read()) > 64) {
            a[c -= c < 96 ? 65 : 97]++;

            if (max < a[c]) {
                max = a[c];
                maxa = c;
            } else if (max == a[c])
                maxa = -2;
        }

        System.out.print((char)(maxa + 65));
    }
}
