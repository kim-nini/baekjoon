import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    /*1부터 N번 까지의 도시 들과, 도시 사이에 길이 있음(길이 없을 수도 있음)
    * 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래 도시로 돌아오는 순회
    * 단, 한번 갔던 도시로는 다시 갈 수 없음(맨 마지막에 출발했던 도시 예외)
    * 각 도시간 이동 비용은 행렬 W[i][j] 형태로 주어짐 : 도시i -> 도시j 이동 비용
    * 비용은 대칭적이지 않음: W[i][j] != W[j][i]
    * 모든 비용은 양의 정수이고 W[i][i]는 항상 0
    * 도시사이에 길이 없는 경우 W[i][j]= 0
    * 도시갯수(N)와 비용행렬(W[i][j])이 주어졌을 때 가장 적은 비용이 드는 순회방법
    * 2 <= N <= 10
    * 각 행렬의 원소는 1000000이하
    * 항상 순회 할 수 있는 경우만 입력으로 주어짐*/

    static int N;
    static int[][] cost;
    static boolean[] visited;
    static int minCost = 11000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N]; // 비용 배열
        for( int i =0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N]; // 방문 체크 배열

        for(int i=0; i<N; i++){ // 모든 위치에서 시작 하기위해 for문 돌리기~
            visited[i] = true;
            dfs(i,i,0,0);
            visited[i] =false; // 탐색 끝난 후 방문체크 되돌리기
        }
        System.out.println(minCost);



    }

    static void dfs(int now, int start, int cnt, int sum){
        // [i][j] 에서 시작했다면
        // 다음 인덱스는 [j][x] 여야 하고 
        // 마지막 인덱스는 [][i] 로 끝나야 함
        if(cnt == N-1){ // 마지막 차례일 때
            minCost = cost[now][start] != 0 ? Math.min(minCost, sum+cost[now][start]) : minCost;
            return;
        }

        for( int i=0; i<N; i++){
            if(!visited[i] && cost[now][i]!=0){ // 방문 한 적 없고 0이 아닐경우
                visited[i] = true; // 방문 체크
                dfs(i,start,cnt+1,sum+cost[now][i]); // 다음도시 탐색
                visited[i] = false; // 탐색 끝난 후 방문 false로 되돌리기
            }
        }


    }
}
