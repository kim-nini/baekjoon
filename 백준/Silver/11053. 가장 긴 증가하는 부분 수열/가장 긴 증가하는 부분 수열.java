import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int best=0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[N];
         Arrays.fill(check,1);
        // 10 100 20 30 40 50
        for(int i =0; i< N; i++){
            for(int j =i+1; j<N; j++){
                if(arr[i]<arr[j]){
                    check[j] = Math.max(check[i]+1, check[j]);
                }
            }
        }

        int count = 0;
        for(int i : check){
            count = Math.max(count,i);
        }
        System.out.print(count);

    }

}
