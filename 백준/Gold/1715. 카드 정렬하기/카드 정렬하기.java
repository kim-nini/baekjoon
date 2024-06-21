import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //입력줄 갯수

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while (pq.size() > 1) {
            int card = pq.poll();
            if (!pq.isEmpty()) {
                card += pq.poll();
            }
            pq.add(card);
            count += card;
        }

        System.out.println(count);
        
    }
}
