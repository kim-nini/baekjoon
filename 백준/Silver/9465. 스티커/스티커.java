
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스
        StringTokenizer st;
        // 위 아래 양 옆의 합보다 높은 스티커 담기
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n][2]; // 스티커 윗줄
            int sum =0;
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<n; i++){
                sticker[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i =0; i<n; i++){
                sticker[i][1] = Integer.parseInt(st.nextToken());
            }

            if(n<2){
                System.out.println(Math.max(sticker[0][1],sticker[0][0]));
                continue;
            }

            int[][] dp = new int[n][2]; // 최대비용 dp
            // 초기값
            dp[0][0] = sticker[0][0];
            dp[0][1] = sticker[0][1];
            dp[1][1] = dp[0][0]+sticker[1][1];
            dp[1][0] = dp[0][1]+sticker[1][0];
            // sticker[i][1] + sticker[i+1][0], sticker[i+1][1] 중 더 큰값넣기


            for (int i=2; i<n; i++){
                dp[i][0] = Math.max(dp[i-1][1] , dp[i-2][1])+ sticker[i][0];
                dp[i][1] = Math.max(dp[i-1][0] , dp[i-2][0])+ sticker[i][1];
            }

            int max = Math.max(dp[n-1][0],dp[n-1][1]);
            System.out.println(max);




        }

    }
}
