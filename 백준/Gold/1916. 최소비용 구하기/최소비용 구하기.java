
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /* 최소비용 구하기
     * A-B 까지 가는데 드는 최소비용
     * 첫째줄 : 도시 개수 N (1 <= N <= 1000)
     * 둘째줄 : 버스 개수 M (1 <= M <= 100000)
     * 셋째줄 부터 M개의 줄: 버스정보 ( 출발도시, 도착도시, 비용)
     * 마지막 줄 : 출발도시 도착도시 */

    static int N, M;
    static List<List<int[]>> list = new ArrayList<>(); // 그래프
    static int[] costArray;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시개수
        M = Integer.parseInt(br.readLine()); // 버스
        StringTokenizer st;
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(from).add(new int[]{to, cost});
        }

        v = new boolean[N + 1]; // 방문 체크
        costArray = new int[N + 1]; // 최소 비용

        st = new StringTokenizer(br.readLine());
        int departure = Integer.parseInt(st.nextToken()); // 시작
        int arrive = Integer.parseInt(st.nextToken()); // 도착

        findMinCost(departure);
        System.out.println(costArray[arrive]);
    }
    static void findMinCost(int departure){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c[1]));
        pq.offer(new int[]{departure, 0});

        Arrays.fill(costArray, Integer.MAX_VALUE); // 최소비용 배열값 초기화
        costArray[departure] = 0; // 시작 비용 0

        while (!pq.isEmpty()){
            int[] now = pq.poll(); // 최소 비용 노드
            int nowCity = now[0]; // 위치
            int nowCost = now[1]; // 비용

            if(costArray[nowCity] < nowCost ) continue; // 이미 확인 된 경우 스킵

            for(int[] neighbor : list.get(nowCity)){
                int next = neighbor[0]; // 인접한 도시 위치
                int cost = neighbor[1]; // 인접한 도시 까지의 비용
                int newCost = nowCost+cost;
                if(newCost<costArray[next]){
                    costArray[next] = newCost; // 비용 갱신
                    pq.offer(new int[]{next,newCost}); // 변경된 비용 큐에 추가
                }
            }

        }


    }
}

