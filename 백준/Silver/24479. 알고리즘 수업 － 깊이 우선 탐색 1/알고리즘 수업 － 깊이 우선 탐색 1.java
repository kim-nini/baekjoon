
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    /* N개의 정점과 M개의 간선으로 된 무방향 그래프
    * 정점은 1번부터 시작
    * 모든 간선의 가중치는 1
    * DFS로 방문할 경우 노드의 방문 순서 출력*/

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int count =1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[N+1]; // 양방향 그래프 배열
        visited = new boolean[N+1]; // 방문 체크
        order = new int[N+1]; // 방문 순서 배열

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 정점
            int v = Integer.parseInt(st.nextToken()); // 간선

            graph[u].add(v); // 양방향 그래프 생성
            graph[v].add(u);
        }

        dfs(R);
        for(int i =1; i<order.length; i++){
            System.out.println(order[i]);
        }

    }

    // 시작값 꺼냄 -> 자식이있으면 출력하고 방문체크 -> 자식담기 -> 담은거 꺼냄 -> 자식이있으면 출력하고 -> 자식담기 -> 꺼냄 -> 자식없으면 그냥 출력
    public static void dfs(int start){
        order[start] = count; // 순서 저장
        visited[start] =true;
        // 인접 정점 집합
        Collections.sort(graph[start]); // 오름차순 정렬
        for (Integer i : graph[start]) {
            if(!visited[i]){ // 방문 한 적 없을때
                count++; // 순서 카운트
                dfs(i); // 다음 순서 진행
            }

        }

    }
}

