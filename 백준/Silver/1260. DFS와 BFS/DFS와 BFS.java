import java.io.*;
import java.util.*;

public class Main {
    static int n, m, v;
    static int[][] matrix;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        v = Integer.parseInt(st.nextToken()); 

        matrix = new int[n + 1][n + 1];

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }

        visited = new boolean[n + 1];
        dfs(v);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(v);
        System.out.println(sb);

    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && matrix[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();
            sb.append(start).append(" ");
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && matrix[start][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
