import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 두줄 데이터 K의 갯수

        for (int i = 0; i < T; i++) {
            PriorityQueue<Long> pq = new PriorityQueue<>(); // 오름차순 queue
            int K = Integer.parseInt(br.readLine()); // K

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++){
                pq.add(Long.parseLong(st.nextToken())); // 파일크기 pq에 담아주기
            }
            long sum =0;
            while (!pq.isEmpty()){
                if(pq.size()==1){ // pq에 한개 남았을 경우
//                    System.out.println(pq.poll());
                    System.out.println(sum);
                    break;
                }
                long tmp = pq.poll();
//                System.out.println("tmp1: "+tmp);
                if(!pq.isEmpty()){
                    tmp = tmp+ pq.poll();
                }
                sum += tmp;
//                System.out.println("tmp2: "+tmp);
                pq.add(tmp);
            }

        }




    }
}

