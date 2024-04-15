import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*RGB 거리
 * 1번집의 색 != 2번집의 색
 * n번집의 색 != N-1번집의 색
 * i(2<=iM=N-1)번집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다
 * 첫째줄 : 집의수 (2<=N<=1000)
 * 둘째줄 : R,G,B 로 칠하는 비용이 한줄에 하나씩 (비용 =< 1000)*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 집의 수
        Integer[][] arr = new Integer[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // R
            arr[i][1] = Integer.parseInt(st.nextToken()); // G
            arr[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        int[][] dp = new int[N][3]; // 최소비용을 담을 dp

        // 초기 비용 설정
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for (int i = 1; i < N; i++) {
            // 현재 색상의 값은 이전에 선택한 나머지 색상값 중 작은값 + 현재 인덱스의 색상값 
           dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + arr[i][0];
           dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + arr[i][1];
           dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + arr[i][2];
        }

        int min = Math.min(Math.min(dp[N-1][1],dp[N-1][2]), dp[N-1][0]);
        System.out.println(min);


    }
}
