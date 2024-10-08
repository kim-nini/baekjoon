import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        numberOfCases();


    }
    static void numberOfCases(){
        int left = 0, right = 0, count = 0, sum = 0;
        while (right < N) {
            sum += arr[right++];
            while (sum >= M) {
                if (sum == M) count++; 
                sum -= arr[left++];
            }
        }

        System.out.print(count);
    }
}
