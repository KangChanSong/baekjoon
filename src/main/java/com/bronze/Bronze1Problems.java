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

    public static void problem1236(BufferedReader reader, BufferedWriter writer) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());

        char[][] chars = new char[m][n];

        int c = 0;
        int r = m;

        for (int i = 0 ; i < m ; i++) {
            String input = reader.readLine();
            if (input.contains("X")) r--;
            chars[i] = input.toCharArray();
        }

        for (int i = 0 ; i < n ; i++) {
            boolean isX = false;
            for(int j = 0 ; j < m ; j++) {
                if (chars[j][i] == 'X') {
                    isX = true;
                    break;
                }
            }
            if (!isX) c++;
        }

        writer.write(String.valueOf(Math.max(r, c)));
        writer.flush();
        writer.close();
    }
    public static void problem1259_mine(BufferedReader reader, BufferedWriter writer) throws IOException {
        String[] results = new String[1000000];

        int currIdx = 0;
        while (true) {
            String numStr = reader.readLine();
            if (numStr.equals("0")) break;

            int sameCount = 0;
            int strLength = numStr.length();
            for(int i = 0; i < strLength / 2 ; i++) {
                if (numStr.charAt(i) == numStr.charAt(strLength - (i + 1))) {
                    sameCount++;
                };
            }
            if (sameCount == strLength / 2) {
                results[currIdx] = "yes\n";
            } else {
                results[currIdx] = "no\n";
            }
            currIdx++;
        }

        for (int i = 0 ; i < results.length ; i++) {
            if (results[i] == null) break;
            writer.write(results[i]);
        }
        writer.flush();
        writer.close();
    }

    public static void problem1259_best(BufferedReader reader) throws IOException {
        String s;
        while (!(s = reader.readLine()).equals("0")) {
            System.out.println(s.equals(new StringBuilder(s).reverse().toString()) ? "yes" : "no");
        }
    }

    public static void problem1268(BufferedReader reader, BufferedWriter writer) throws IOException {
        int m = Integer.parseInt(reader.readLine());

        int[] res = new int[m];
        int[][] info = new int[m][5];
        int[][] dupinf = new int[m][m];

        // 입력
        for(int i = 0 ; i < m ; i++) {
            String[] istrs = reader.readLine().split(" ");
            for (int j = 0 ; j < 5 ; j++)
                info[i][j] = Integer.valueOf(istrs[j]);
        }

        for(int i = 0 ; i < 5 ; i++ ) {
            for(int j = 0 ; j < m ; j++) {
                for(int k = 0 ; k < m ; k++) {
                    if (j == k) continue;
                    if (dupinf[j][k] == 1) continue;

                    if(info[j][i] == info[k][i]) {
                        dupinf[j][k] = 1;
                        res[j]++;
                    }
                }
            }
        }

        // 정답 추출
        int max = 0;
        int result = 0;
        for(int i = m-1 ; i >= 0 ; i--) {
            if (max <= res[i]) {
                max = res[i];
                result = i;
            }
        }

        writer.write(String.valueOf(result+1));
        writer.flush();
        writer.close();
    }
}
