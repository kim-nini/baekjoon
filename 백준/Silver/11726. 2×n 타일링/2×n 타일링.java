import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        System.out.println(calc(N));

    }

    static int calc(int N) {
       if(N==0) return 1;
       if(N==1) return 1;

       int[] dp = new int[N+1];
       dp[0] = 1;
       dp[1] = 1;

       for(int i=2;i<=N;i++) {
           dp[i] = (dp[i-1]+dp[i-2])%10007;
       }
       return dp[N];

    }

}
