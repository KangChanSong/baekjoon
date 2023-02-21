package com.silver3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P1463_FASTER {
    static Integer[] dp; //각 숫자별로 1로 만드는 연산 횟수의 최솟값을 저장한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //정수 N을 입력한다.
        dp = new Integer[N+1];

        //기본값을 설정해준다.
        //dp[N]!=null이 아니게끔 하는 기본값
        dp[0] = 0;
        dp[1] = 0;

        System.out.println(solve(N)); //N을 1로 만드는 연산 횟수의 최솟값을 출력한다.
    }


    private static int solve(int N) {
        if(dp[N]==null) {
            //N을 1로 만드는 연산의 최솟값은
            //2로 나누는 횟수와 3을 나누는 횟수를 비교해서 그 중 작은 값을 택해야 한다.
            //N%2, N%3만큼은 -1을 하는 연산 횟수이며,
            //+1은 각 연산을 할 때마다 그 횟수를 카운팅 하기 위함이다.
            //따라서 위와 같은 점화식을 도출할 수 있다.
            dp[N] = Math.min(solve(N/2) + 1 + N%2 , solve(N/3) + 1 + N%3);
        }
        return dp[N];
    }
}