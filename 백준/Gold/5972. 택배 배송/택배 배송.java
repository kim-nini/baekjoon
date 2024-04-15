import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /* 택배배송
    *  다익스트라*/
    static int N,M;
    static int[] d;
    static boolean[] v;
    static List<List<int[]>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 출발 위치 : 1, 도착 위치 : N
        M = Integer.parseInt(st.nextToken()); // 간선 개수

        for(int i =0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for( int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost =Integer.parseInt(st.nextToken());
            list.get(x).add(new int[]{y,cost});
            list.get(y).add(new int[]{x,cost});
        }

        d = new int[N+1]; // 특정 노드까지의 최소비용
        v = new boolean[N+1]; // 방문체크 배열

        findBestCourse(1); // 시작점 1
        System.out.println(d[N]);
    }

    static void findBestCourse(int start){
        // 거리에 따라 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0}); // 시작 노드와 거리 추가

        Arrays.fill(d, Integer.MAX_VALUE); // 최소 비용 배열을 최대값으로 초기화
        d[start] = 0; // 시작 노드의 비용은 0

        while (!pq.isEmpty()){
            int[] now = pq.poll(); // 최소 비용 노드 poll
            int nowNode = now[0]; // 위치
            int nowCost = now[1]; // 비용

            if( d[nowNode] < nowCost) continue; // 이미 더 짧은 경로가 확인된경우 스킵

            for(int[] neighbor : list.get(nowNode)){
                int next = neighbor[0];
                int cost = neighbor[1];
                int newCost = nowCost + cost;
                if(newCost < d[next]){
                    d[next] = newCost; // 비용 갱신
                    pq.offer(new int[]{next,newCost}); // 변경된 비용 큐에 추가
                }
            }
        }
    }
}
