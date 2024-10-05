import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> primeNum = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            if (getPrimeNum(i)) primeNum.add(i);
        }
        System.out.print(primeNum.isEmpty() ? 0 : numberOfCases());
    }

    static boolean getPrimeNum(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    static int numberOfCases() {
        int left = 0, right = 0, sum = primeNum.get(0), count = 0;
        while (left <= right) {
            if (sum < N) { // 합이 n보다 작으면
                if (right >= primeNum.size() - 1) break;
                sum += primeNum.get(++right);
            } else if (sum > N) { // 합이 n보다 크면
                sum -= primeNum.get(left++);
            } else { // 같은경우
                count++;
                sum -= primeNum.get(left++);
            }
        }
        return count;
    }
}