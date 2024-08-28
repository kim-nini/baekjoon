import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 1;
        for (int i = 2; i <= n; i++) {
            answer *= i;
        }
        System.out.print(answer);

    }
}