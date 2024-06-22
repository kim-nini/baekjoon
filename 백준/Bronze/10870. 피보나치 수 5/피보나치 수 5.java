
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n번째 피보나치 수

        System.out.println(fibonacci(n-1, 0, 1));
    }

    static int fibonacci(int n, int one, int two) {
        if (n == 0) {
            return two;
        } else if (n<0) {
            return 0;
        } else {
            return fibonacci(n - 1, two, one + two);
        }
    }
}
