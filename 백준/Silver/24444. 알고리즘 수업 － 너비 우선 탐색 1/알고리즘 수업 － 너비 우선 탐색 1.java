
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /* N개의 정점과 M개의 간선으로 된 무방향 그래프
    * 정점은 1번부터 시작
    * 모든 간선의 가중치는 1
    * BFS로 방문할 경우 노드의 방문 순서 출력*/

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int count =1;
    static Queue<Integer> queue = new ArrayDeque<>();

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

        queue.add(R);
        visited[R] = true;
        bfs(R);
        for(int i =1; i<order.length; i++){
            System.out.println(order[i]);
        }

    }

    // 시작값 꺼냄 -> 방문 한 적 없는 자식들을 큐에 담아줌 -> 또 꺼내고 -> 자식들을 큐에 담아줌
    public static void bfs(int start){
//        queue.add(start); // 처음값 담아주고
        while (!queue.isEmpty()){
            start = queue.poll(); // 하나 꺼내고
//            System.out.println("꺼낸값: "+start);
            Collections.sort(graph[start]);
            for(Integer i : graph[start]){
                if(!visited[i]){
                    visited[i] = true; // 큐에 담았다고 체크
//                    System.out.println("담아주는값: "+i);
                    queue.add(i); // 자식 노드를 하나씩 담아줌
                }
            }
            order[start] = count;
//            System.out.println("count: "+count+" = start: "+start);
            count++;
            if(!queue.isEmpty()) {
//                System.out.println("다음값: "+queue.peek());
                bfs(queue.peek());
            }
        }

    }
}

