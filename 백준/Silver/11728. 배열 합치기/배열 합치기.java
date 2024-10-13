import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N+M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            st = i==N-1?new StringTokenizer(br.readLine()):st;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }
}


