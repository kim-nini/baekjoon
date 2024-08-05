import java.io.*;
import java.util.*;


public class Main {
    static int N, M, start, end;
    static Map<Integer, Integer>[] island;
    static int maxWeight = Integer.MIN_VALUE; // 최대 중량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N: 섬의 개수, M: 간선 개수
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        island = new HashMap[N + 1];
        for (int i = 0; i <= N; i++) {
            island[i] = new HashMap<>();
        }

        int right = 0;
        int left = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            island[A].put(B, Math.max(island[A].getOrDefault(B, 0), C));
            island[B].put(A, Math.max(island[B].getOrDefault(A, 0), C));
            right = Math.max(right, C);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        while (left <= right) {
            int mid = (right + left) / 2;
            if (bfs(mid)) {
                maxWeight = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxWeight);
    }

    static boolean bfs(int mid) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Map.Entry<Integer, Integer> entry : island[current].entrySet()) {
                int next = entry.getKey();
                int weight = entry.getValue();
                if (weight >= mid && !visited[next]) {
                    if (next == end) {
                        return true;
                    }
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }
}