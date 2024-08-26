import java.io.*;
import java.util.*;

public class Main{
    static int[][] laboratory, arr;
    static boolean[][] visited;
    static int N, M, answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        laboratory = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        wall(0);
        System.out.print(answer);

    }

    static void wall(int depth) {
        if (depth == 3) { // 3개를 다 놨을 때
            arr = new int[N][M];
            for(int i = 0; i<N; i++){
                arr[i] = laboratory[i].clone();
            }
            findVirus(); // 바이러스 위치찾기
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (laboratory[i][j] == 1 || laboratory[i][j] == 2) {
                    continue;
                }
                laboratory[i][j] = 1;
                wall(depth + 1);
                laboratory[i][j] = 0;
            }
        }
    }

    static void findVirus() {
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 2) { // 바이러스찾을때마다
                    infect(i, j); // 퍼뜨려
                }
            }
        }
        answer = Math.max(answer, checkSafeArea());
    }

    private static int checkSafeArea() {
        int count = 0;
        for (int[] i : arr) {
            for (int j : i) {
                count = j == 0 ? count + 1 : count;
            }
        }
        return count;
    }

    static void infect(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + dx[k];
                int ny = cur[1] + dy[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    arr[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}