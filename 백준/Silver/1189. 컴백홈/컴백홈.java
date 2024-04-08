
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K;
    static char[][] map;
    static boolean[][] visited;
    static int answer = 0;

    static int[] moveR = {1, -1, 0, 0}; // 아래, 위
    static int[] moveC = {0, 0, 1, -1}; // 오, 왼

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 행 갯수
        C = Integer.parseInt(st.nextToken()); // 열 갯수
        K = Integer.parseInt(st.nextToken()); // 거리

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = sb.charAt(j);
            }
        }

        visited = new boolean[R][C]; // 방문체크
        visited[R - 1][0] = true; // 시작점
        dfs(R - 1, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int r, int c, int move) {
        if(r == 0 && c == C-1){ // 도착지에 도착한 경우
            if (move == K){ // K만큼 움직인 경우
                answer++;
            }
            return;
        }
        for(int i=0; i<4; i++){
            // 한 칸씩 움직이는 인덱스 만들기
            int nextR = r + moveR[i];
            int nextC = c + moveC[i];
            if (nextR<0 || nextC<0 || nextR>=R || nextC>=C){ continue; } // 경계에 도착하면 continue
            if (visited[nextR][nextC]|| map[nextR][nextC] == 'T'){ continue; } // 방문한 적 있거나, T를 만나면

            visited[nextR][nextC] = true; // 방문체크
            dfs(nextR,nextC,move+1);
            visited[nextR][nextC] = false; // 경로 탐색이 끝난 후 다른경로를 탐색하기위해 체크 변경

        }

    }
}

