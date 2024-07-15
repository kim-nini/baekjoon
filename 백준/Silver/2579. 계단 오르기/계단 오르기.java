import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];

        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(maxScore(scores));

    }

    public static int maxScore(int[] scores) {
        int n = scores.length;
        if (n == 0) return 0;
        if (n == 1) return scores[0];
        if (n == 2) return scores[0] + scores[1];

        int[][] dp = new int[n][3];
        
        dp[0][1] = scores[0];
        dp[0][2] = scores[0];
        dp[1][1] = scores[1];
        dp[1][2] = scores[0] + scores[1];
        
        for (int i = 2; i < n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + scores[i];
            dp[i][2] = dp[i-1][1] + scores[i];
        }

        return Math.max(dp[n-1][1], dp[n-1][2]);
    }

}
