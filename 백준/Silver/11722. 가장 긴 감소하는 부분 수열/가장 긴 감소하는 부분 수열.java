import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
/*가장 긴 감소하는 부분 수열
* arr[N-1] */
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 수열 받기
        }

        int[] dp = new int[N]; // 각 위치에서 가장 긴 감소하는 부분수열의 길이를 저장할 dp

        // 모든 위치의 값을 1로 초기화
        for(int i =0; i<N; i++){ // 자기 자신만 으로도 길이가 1인 부분수열을 형성 할 수 있음
            dp[i] = 1;
        }

        // 각 위치에 대해 가장 긴 감소하는 부분 수열의 길이 계삭
        for(int now =1; now<N; now++){ // 1부터 N까지 arr[now]값을 가져와서
            for(int before=0; before<now; before++){
                if(arr[before]>arr[now] && dp[before]+1>dp[now]){ // 현재 위치 now의 값이 이전위치 값보다 작고, 더 긴 부분수열을 만들 수 있을 경우
                    dp[now] =dp[before]+1; // 현재 위치의 최대 길이를 업데이트
                }
            }
        }

        int max = 0;
        for(int i =0; i<N; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);



    }
}
