
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

       public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 보석의 개수 N, 가방의 개수 K 입력
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 보석 배열 (무게, 가격)
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt(); // 보석의 무게
            int V = sc.nextInt(); // 보석의 가격
            jewels[i] = new Jewel(M, V);
        }

        // 가방 배열 (최대 무게)
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = sc.nextInt();
        }

        // 보석을 무게 순으로 정렬
        Arrays.sort(jewels, Comparator.comparingInt(j -> j.weight));

        // 가방을 무게 순으로 정렬
        Arrays.sort(bags);

        // 우선순위 큐: 가격이 높은 순으로 보석을 저장
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long maxTotalValue = 0;
        int jewelIndex = 0;

        // 가방을 하나씩 처리
        for (int bag : bags) {
            // 현재 가방에 넣을 수 있는 모든 보석을 pq에 넣음
            while (jewelIndex < N && jewels[jewelIndex].weight <= bag) {
                pq.add(jewels[jewelIndex].value);
                jewelIndex++;
            }

            // pq에서 가장 비싼 보석을 가방에 넣음
            if (!pq.isEmpty()) {
                maxTotalValue += pq.poll();
            }
        }

        // 상덕이가 훔칠 수 있는 보석의 최대 가격 출력
        System.out.println(maxTotalValue);
    }

    // 보석 클래스 정의
    static class Jewel {
        int weight;
        int value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

}
