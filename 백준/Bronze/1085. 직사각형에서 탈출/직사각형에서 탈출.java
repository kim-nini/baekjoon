
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Math.min(Math.min(arr[0],Math.abs(arr[0]-arr[2])), Math.min(arr[1],Math.abs(arr[1]-arr[3])));
        System.out.print(min);
    }
}


