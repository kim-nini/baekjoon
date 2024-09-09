import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j = 0; j <= i; j++){ 
               if(i==0) { 
                   arr[i][j] = Integer.parseInt(st.nextToken());
               }else if(j==0) { 
                   arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i-1][j];
               } else {
                   arr[i][j] = Integer.parseInt(st.nextToken()) + Math.max(arr[i-1][j-1], arr[i-1][j]);
               }
           }
        }

        System.out.print(Arrays.stream(arr[n-1]).max().orElse(0));

    }

}
