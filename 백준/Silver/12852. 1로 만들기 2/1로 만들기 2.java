
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());
        arr = new int[X+1];
        for(int i = 2; i <= X; i++){
            arr[i] = arr[i-1]+1;
            if(i%2 == 0){
                arr[i] = Math.min(arr[i/2]+1, arr[i]);
            }
            if(i%3 == 0){
                arr[i] = Math.min(arr[i/3]+1, arr[i]);
            }

        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[X]).append("\n").append(X).append(" ");

        while(X>1){
            if(X%3==0 && arr[X/3] == arr[X]-1){
                sb.append(X/3).append(" ");
                X = X/3;
            } else if (X%2==0 && arr[X/2] == arr[X]-1) {
                sb.append(X/2).append(" ");
                X =X/2;
            } else if (arr[X-1] == arr[X]-1){
                sb.append(X-1).append(" ");
                X=X-1;
            }
        }
        System.out.print(sb);
    }


}
