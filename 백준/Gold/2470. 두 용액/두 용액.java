import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(arr);
        
        // 투 포인터 초기화
        int left = 0;
        int right = n - 1;
        
        // 결과값을 저장할 변수들
        int minLeft = 0;
        int minRight = n - 1;
        int closestSum = Integer.MAX_VALUE;
        
        // 투 포인터 탐색
        while (left < right) {
            int sum = arr[left] + arr[right];
            
            // 현재 합이 더 0에 가깝다면 갱신
            if (Math.abs(sum) < closestSum) {
                closestSum = Math.abs(sum);
                minLeft = left;
                minRight = right;
            }
            
            // 합이 0보다 크면 right를 왼쪽으로 이동
            if (sum > 0) {
                right--;
            } 
            // 합이 0보다 작으면 left를 오른쪽으로 이동
            else {
                left++;
            }
        }
        
        // 결과 출력 (오름차순으로)
        System.out.println(arr[minLeft] + " " + arr[minRight]);
    }
}
