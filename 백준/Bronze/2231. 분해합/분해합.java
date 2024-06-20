import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 입력값
        int a = 0; // 분해합
        int toN = 0; // N과 비교하는 변수

        System.out.println(convertToN(a, toN, N));
    }

    public static int convertToN(int a, int toN, int N) {
        for (int i = 1; i <= N; i++) {
            int tmp = i;
            toN = i;
            while (tmp >= 10) {
                toN += tmp % 10;
                tmp /= 10;
            }
            toN += tmp;
            if (toN == N) {
                a = i;
                return a;
            }
        }
        return 0;
    }
}