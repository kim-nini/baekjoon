import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int countBlock = 0, N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i< N; i++){
            for(int j = 0; j< N; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    countApt(i,j);
                    countBlock++;
                }
            }
        }

        System.out.println(countBlock);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }
    static void countApt(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int curX = cur[0];
                int curY = cur[1];

                for(int j = 0; j < 4; j++){
                    int newX = curX + dx[j];
                    int newY = curY + dy[j];

                    if(newX>=0 && newY>=0 && newX<N && newY<N && map[newX][newY]==1 && !visited[newX][newY]){
                        q.add(new int[]{newX, newY});
                        count++;
                        visited[newX][newY] = true;
                    }
                }

            }

        }

        pq.add(count);
    }
}
