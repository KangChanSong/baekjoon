package com.silver5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String result = "";
        StringBuilder sb = new StringBuilder(word).reverse();
        for (int i = 1 ; i < word.length() - 1 ; i++) {
            String first = sb.substring(0, i);
            for (int j = 1 ; j < word.length() - i ; j++) {
                String newStr = sb.substring(j+i, word.length()) + sb.substring(i, j + i) + first;
                if (result.equals("")) result = newStr;
                else if (result.compareTo(newStr) > 0) result = newStr;
            }
        }
        System.out.println(result);
    }
}
