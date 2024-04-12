import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0 ; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start =Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i] = new int[]{start, end};
        }
        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0])); // 시작시간 오름차순정렬
        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[1])); 
        int end = arr[0][1];
        int count = 1;
        for(int i=1; i<N; i++){
            if(end <= arr[i][0]){ 
                count++; 
                end = arr[i][1]; 
            }
        }
        System.out.println(count);
    }
}

