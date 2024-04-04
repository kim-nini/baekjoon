import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/* N개의 카드를 M번 합친 후 N장의 숫자를 모두 더한 값 출력*/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드개수
        int m = Integer.parseInt(st.nextToken()); // 합체개수

        // 오름차순 정렬
        PriorityQueue<Long> minHeap = new PriorityQueue<>();


        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            minHeap.add(Long.parseLong(st.nextToken()));
        }

        for(int i =0; i<m; i++){
            if(!minHeap.isEmpty()) {
                long a = minHeap.poll();
                if(!minHeap.isEmpty()) {
                    long b = minHeap.poll();
                    minHeap.offer(a+b);
                    minHeap.offer(a+b);
                }
            }
        }

        long sum = 0;
        while (!minHeap.isEmpty()){
            sum += minHeap.poll();
        }
        System.out.println(sum);


        br.close();
    }



}

