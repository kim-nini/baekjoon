import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        int[][] residents = new int[15][15]; // 0층부터 14층, 1호부터 14호

        // 0층 초기화: 0층 i호에는 i명이 산다.
        for (int i = 1; i <= 14; i++) {
            residents[0][i] = i;
        }

        // 1층부터 k층까지 초기화
        for (int k = 1; k <= 14; k++) {
            for (int n = 1; n <= 14; n++) {
                // k층 n호에는 k-1층 1호부터 n호까지의 합이 산다
                for (int j = 1; j <= n; j++) {
                    residents[k][n] += residents[k-1][j];
                }
            }
        }

        // 테스트 케이스별 결과 출력
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호
            System.out.println(residents[k][n]);
        }
    }
}
