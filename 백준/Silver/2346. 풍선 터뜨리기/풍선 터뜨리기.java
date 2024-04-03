import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    /* Deque 사용 */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 풍선 갯수
        Deque<Balloon> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }


        // deque을 이용해서 순서를 바꿈
        Balloon poll = deque.pollFirst();
       
        sb.append(poll.seq+" ");

        while(!deque.isEmpty()) {
             int next = poll.next;
            if (next > 0) {
                for (int i = 1; i < next; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                poll = deque.pollFirst();
                sb.append(poll.seq+" ");
            } else if(next<0){
                for (int i = 1; i < Math.abs(next); i++) {
                    deque.offerFirst(deque.pollLast());
                }
                poll = deque.pollLast();
                sb.append(poll.seq+" ");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);
        br.close();
    }

    static class Balloon {
        int seq, next;

        public Balloon(int seq, int next) {
            this.seq = seq;
            this.next = next;
        }
    }
}
