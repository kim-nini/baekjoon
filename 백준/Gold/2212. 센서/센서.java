import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    /* 센서N : 1 3 6 6 7 9 
    * 집중국K : 2개
    * -> <1 3> <6 6 7 9>
    * 2개(K)로 나눠짐 -> 센서 사이의 거리 중 가장 큰 1개(K-1)의 값 빼고
    * 더해주기  */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 센서 개수
        int K = Integer.parseInt(br.readLine()); // 집중국 개수

        // 센서 개수 <= 집중국 개수 
        if(N <= K){     System.out.println(0); return;        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a); // 내림차순 queue
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            pq.add(Integer.parseInt(st.nextToken()));
        }

        int big,small = 0;
       
        PriorityQueue<Integer> result = new PriorityQueue<>(); // 오름차순 큐
        big = pq.poll(); // 큰 숫자(제일 오른쪽에 있는센서) 먼저 뽑기
        while (!pq.isEmpty()){
            // 오른쪽 센서 위치에서 다음(왼쪽) 센서위치 빼서 센서 사이 거리구하기
            small = pq.poll(); // 왼쪽값 뽑기
            result.add(big-small); // 센서 사이 거리
            big = small; // 큰값 업뎃 해주기
        }

        // 센서 사이 거리들의 값중에 가장 큰 집중국K 갯수 만큼 빼고 나머지를 더하면
        int sum =0;
        while (K-1 < result.size()){ 
            sum += result.poll();
        }
        System.out.println(sum);

    }
}
