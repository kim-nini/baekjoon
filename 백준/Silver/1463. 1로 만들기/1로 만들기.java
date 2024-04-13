import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1];  // dp[i]는 숫자 i를 1로 만들기 위한 최소 연산 횟수를 저장

        // 초기값 설정, 1은 이미 1이므로 연산이 필요 없다.
        dp[1] = 0;

        // 2부터 N까지 각 숫자에 대해 최소 연산 횟수 계산
        for (int i = 2; i <= N; i++) {
            // 먼저 1을 빼는 연산을 기본으로 설정
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지면, 2로 나누었을 때와 현재 최소값을 비교하여 더 작은 값 선택
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지면, 3으로 나누었을 때와 현재 최소값을 비교하여 더 작은 값 선택
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        // 결과 출력
        System.out.println(dp[N]);
    }
}
