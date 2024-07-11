import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[41];
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 2; i<=40; i++){
            arr[i] = arr[i-2]+arr[i-1];
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // n번째 피보나치 수
            if (n==0) {
                sb.append(1).append(" ").append(0).append("\n");
                continue;
            }
            sb.append(arr[n-1]).append(" ").append(arr[n]).append("\n");
        }
        System.out.print(sb);
    }
}
