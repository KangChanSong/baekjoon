package com.bronze;

import java.io.*;
import java.util.StringTokenizer;

public class P1357 {
    private static final StringBuilder stringBuilder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        problem1357(reader, writer);
    }

    private static void problem1357(BufferedReader reader, BufferedWriter writer) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int x = reverseAndConvertToInteger(tokenizer.nextToken());
        int y = reverseAndConvertToInteger(tokenizer.nextToken());
        writer.write(String.valueOf(reverseAndConvertToInteger(String.valueOf(x + y))));
        writer.flush();
        writer.close();
    }

    private static int reverseAndConvertToInteger(String s) {
        stringBuilder.setLength(0);
        return Integer.parseInt(stringBuilder.append(s).reverse().toString());
    }
}
