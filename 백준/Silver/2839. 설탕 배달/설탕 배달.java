
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        calc(N);

    }

    static void calc(int N) {
        for (int a = 0; a * 3 <= N; a++) {
            for (int b = 0; b * 5 <= N; b++) {
                int number = 3 * a + 5 * b;
                if (number == N) {
                    System.out.println(a + b);
                    return;
                }
            }
        }
        System.out.print(-1);
    }

}
