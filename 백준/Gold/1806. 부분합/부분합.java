import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static int N,S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr= new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        find(arr);
        System.out.print(answer==Integer.MAX_VALUE?0:answer);
    }
    static void find(int[] arr){
        int left = 0, right = 0;
        int tmp = arr[left];
        while(left<=right) {
            if(tmp>=S){
                answer = Math.min(right-left+1,answer);
                tmp -= arr[left];
                left++;
            }else {
                right++;
                if (right>=N) break;
                tmp += arr[right];
            }
        }
    }
}
