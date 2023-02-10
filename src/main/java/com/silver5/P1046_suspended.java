package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1046_suspended {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        Dots dots = new Dots(3);
        for (int i = 0 ; i < 3 ; i ++) {
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            dots.setDot(x, y);
        }
        System.out.println(dots.parallelSideExists());
    }

    static class Dots {
        private final int capacity;
        private final int[][] dots;

        private int curr = 0;

        Dots(int capacity) {
            this.capacity = capacity;
            this.dots = new int[capacity][2];
        }

        void setDot(int x, int y) {
            if (this.curr >= capacity) throw new IndexOutOfBoundsException();
            dots[curr][0] = x;
            dots[curr][1] = y;
            curr++;
        }

        boolean parallelSideExists() {
            return parallelSideExists('x') && parallelSideExists('y');
        }

        private boolean parallelSideExists(char d) {
            boolean b = false;
            int temp = dots[0][d == 'x' ? 0 : d == 'y' ? 1 : -1];
            for (int i = 1 ; i < dots.length ; i++) {
                if (temp != dots[i][1]) {
                    b = true;
                    break;
                }
            }
            return b;
        }

        double getBiggestRound() {
            return 0.0;
        }

        double getSmallestRound() {
            return 0.0;
        }

        double getLongestLineInDots() {
            return 0.0;
        }

        double getLongestLine() {
            return 0.0;
        }

        void printDots() {
            for(int i = 0 ; i < dots.length ; i++) {
                char dotName = i == 0 ? 'A' : i == 1 ? 'B' : i == 2 ? 'C' : ' ';
                System.out.printf("%c(%d,%d)\n", dotName, dots[i][0], dots[i][1]);
            }
        }
    }
}
