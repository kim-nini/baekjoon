import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int sum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        numberOfCases();
    }
    static void numberOfCases() {
        int left = 0, right = N - 1, tmp = 0;
        String answer = "";
        while (left < right) {
            tmp = arr[left] + arr[right];
           if(Math.abs(sum)>=Math.abs(tmp)) {
               sum = tmp;
               answer = arr[left]+" "+arr[right];
           }
           if(tmp>0){
               right--;
           }else {
               left++;
           }
        }
        System.out.print(answer);
    }
}