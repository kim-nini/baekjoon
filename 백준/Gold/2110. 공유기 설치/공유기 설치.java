import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] house = new int[N];

        for(int i = 0; i < N; i++) {
           house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int left = 1;
        int right = house[N - 1] - house[0];
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceRouters(house, N, C, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }
    static boolean canPlaceRouters(int[] house, int N, int C, int distance) {
        int count = 1;
        int lastPlacedRouter = house[0];

        for (int i = 1; i < N; i++) {
            if (house[i] - lastPlacedRouter >= distance) {
                count++;
                lastPlacedRouter = house[i];
                if (count >= C) {
                    return true;
                }
            }
        }

        return false;
    }
}
