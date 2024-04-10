import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] W;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            tsp(i, i, 0, 0);
            visited[i] = false;
        }

        System.out.println(minCost);
    }

    static void tsp(int current, int start, int count, int cost) {
        if (count == N - 1) {
            if (W[current][start] != 0) {
                minCost = Math.min(minCost, cost + W[current][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && W[current][i] != 0) {
                visited[i] = true;
                tsp(i, start, count + 1, cost + W[current][i]);
                visited[i] = false;
            }
        }
    }
}
