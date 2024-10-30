import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer = 0;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static Queue<int[]> riped = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    riped.add(new int[]{i, j});
                }
            }
        }
        // 처음 1이 담긴위치를 전부 담아서 동시에돌리기~

        bfs();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                answer = box[i][j]==0 ? -1 : answer;
            }
        }

        System.out.print(answer);

    }

    static void bfs() {
        int count = 0;

        while (!riped.isEmpty()) {
            int size = riped.size();
            for(int j = 0; j<size; j++) {
                int[] cur = riped.poll();

                int curX = cur[0];
                int curY = cur[1];

                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < M && ny < N && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        riped.add(new int[]{nx, ny});
                    }
                }
            }
            count++;
        }

              answer = Math.max(answer,count-1);
    }


}


