
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    //  경우의 수 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());

            BigInteger n = factorial(east);

            BigInteger nToR = factorial(east - west);

            BigInteger r = factorial(west);

            System.out.println(n.divide(nToR.multiply(r)));

        }
        //  east! / (east-west) !
        // 1부터 east값까지의 수열에서 원소가 west개인 중복되지 않는 부분조합의 갯수

    }

    static BigInteger factorial(int num) {
        if (num <= 1) {
            return BigInteger.ONE;
        } else {
            return factorial(num - 1).multiply(new BigInteger("" + num));
        }

    }
}
