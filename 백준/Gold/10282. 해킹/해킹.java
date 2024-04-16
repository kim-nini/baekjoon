import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /* 해킹
    * 1 : 컴갯수 n, 의존갯수(간선) d, 시작컴터 c
    * 이어서 d 개의줄에 a->b 의존 , s 초후 컴터감염 */
    static List<List<int[]>> list;
    static int n,m;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스

        while (T-- > 0) {
            list = new ArrayList<>();
                
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 정점 개수
            m = Integer.parseInt(st.nextToken()); // 간선 개수
            int start = Integer.parseInt(st.nextToken()); // 시작번호


            for(int i=0; i<=n; i++){
                list.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){ // 그래프 생성
                st = new StringTokenizer(br.readLine());
                int to =Integer.parseInt(st.nextToken());
                int from =Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                list.get(from).add(new int[]{to,time});
            }

            d = new int[n+1]; // 특정 노드까지의 최소 시간 배열

            hackingTime(start); // 다익스트라 호출
            
            // Integer.MAX_VALUE를 제외한 나머지 값 중 큰 값 = 최소시간
            int max = Arrays.stream(d).filter(c -> c!= Integer.MAX_VALUE).max().getAsInt();
            // 시작 노드로부터 인접한 노드들(감염된) 갯수
            long countCom = Arrays.stream(d).filter(c -> c!= Integer.MAX_VALUE).count();
            System.out.println(countCom+" "+max);
        }


    }
    static void hackingTime(int start){
        // pq사용 시간에따라 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start,0}); // 시작 노드와 시간

        Arrays.fill(d, Integer.MAX_VALUE); // 최대값으로 다 담아주기
        d[start] = 0; // 시작노드 비용은 0

        while (!pq.isEmpty()){
            int[] now = pq.poll();
            int nowCom = now[0]; // 위치
            int nowSec = now[1]; // 비용

            if(d[nowCom] < nowSec) continue; // 이미 최소값이 담겨있으면 스킵

            for(int[] neighbor : list.get(nowCom)){
                int next = neighbor[0]; // 의존하는 컴퓨터위치
                int time = neighbor[1]; // 의존하는 컴퓨터까지의 시간
                int newTime = time+nowSec;
                if(newTime<d[next]){
                    d[next] = newTime; // 최소시간 갱신
                    pq.offer(new int[]{next,newTime}); // 큐에 추가
                }
            }
        }
    }
}
