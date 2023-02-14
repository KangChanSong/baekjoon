package com.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1331 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] chess = new int[7][7];
        int befX = 0, befY = 0;
        int startX = 0 , startY = 0;

        for (int i = 0 ; i < 6 ; i++) {
            for (int j = 0 ; j < 6 ; j++) {
                char[] chars = br.readLine().toCharArray();
                int x = chars[0] - 64;
                int y = chars[1] - 48;

                chess[x][y] += 1;

                // 같은 곳 두번 방문했는지 확인
                if (chess[x][y] > 1) {
                    System.out.println("Invalid");
                    return;
                }

                if (i==0&&j==0) {
                    startX = x;
                    startY = y;
                }
                else {
                    // 나이트가 갈 수 있는 경로인지 확인
                    if (!isValidPath(befX, x, befY, y)) {
                        System.out.println("Invalid");
                        return;
                    }
                }
                befX = x;
                befY = y;
            }
        }

        // 맨 뒤, 맨 앞 경로 확인
        System.out.println(isValidPath(befX, startX, befY, startY) ? "Valid" : "Invalid");
    }

    private static boolean isValidPath(int befX, int x,  int befY, int y) {
        int xGap = Math.abs(befX - x), yGap = Math.abs(befY - y);
        return ((xGap == 1 && yGap ==2) || (xGap == 2 && yGap == 1));
    }
}
