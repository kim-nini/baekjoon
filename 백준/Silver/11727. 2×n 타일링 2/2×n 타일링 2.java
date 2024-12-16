import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(calc(N));
    }

    static long calc(int N) {
       if (N == 1) return 1; // N이 1일 경우 1을 반환
        if (N == 2) return 3; // N이 2일 경우 기본값 3 반환

        int[] dp = new int[N + 1];
        dp[1] = 1; // dp[1] = 1
        dp[2] = 3; // dp[2] = 3

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007; // 모듈러 연산 추가
        }
        return dp[N];
    }
}
