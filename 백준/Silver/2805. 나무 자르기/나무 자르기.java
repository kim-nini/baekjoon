import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        int m = Integer.parseInt(st.nextToken()); // 필요한 길이

        // 0 <= h < Max(arr)-m
        // F(h') >= m(7) -> O / X
        // O: 오른쪽->               <- X : 왼쪽
        // 땅-------------------------------하늘

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 뒤에서부터 체크하는걸로~

        long max = arr[n-1]-1; // h의 최대값 (최대10억) 항상 입력을 잘봐야함

        long start = 0; // h의 min값
        long end = max; // 
        while(start <= end){
            long mid = (start + end ) / 2;
            long sum = 0;
            for(int i=n-1; i>=0; i--){ // 자른 나무 길이의 합
                if ( mid > arr[i] ) continue;
                sum += (arr[i]-mid);
            }
            // 7인데 10이 나왓음 arr[i]15 라고쳤을때 - 5를 뺏더니
            // start = 6 됨
            // 그럼 6 + 10 18 9 가됨 15 -9 를 하면 6이 됨
            if(sum >= m) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        System.out.println(end);

    }
}
