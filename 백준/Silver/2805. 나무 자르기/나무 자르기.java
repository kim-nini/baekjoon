import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 나무수
        int M = Integer.parseInt(st.nextToken()); // 필요한 길이

        int[] trees = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long start = 0;
        long end = trees[N - 1] - 1;

        while (start <= end) {
            long mid = (end + start) / 2;
            long sum = 0;

            for (int height : trees) {
                sum += Math.max(height - mid, 0);
            }
            // 나무 길이가 너무 많으면
            if (sum >= M) {
                start = mid + 1;
            } else { // 적으면
                end = mid - 1;
            }
        }

        System.out.println(end);


    }

}
