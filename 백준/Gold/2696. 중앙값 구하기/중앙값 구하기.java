
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int M = Integer.parseInt(br.readLine()); // 수열 크기
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            System.out.println((M + 1) / 2);
            StringBuilder sb = new StringBuilder();
            int centerNum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0; // 출력 형식을 위한 변수
            for (int i = 1; i <= M; i++) {
                if(!st.hasMoreTokens()){
                    st = new StringTokenizer(br.readLine());
                }
                pq.add(Integer.parseInt(st.nextToken())); // 오름차순 정렬
                if (i % 2 != 0) {
                    PriorityQueue<Integer> temp = new PriorityQueue<>(pq);
                    for (int j = 1; j <= (i + 1) / 2; j++) {
                        centerNum = temp.poll();
                    }

                    sb.append(centerNum).append(" ");
                    count++;
                    if (count%10 == 0) {
                        sb.append("\n");
                    }

                }
            }

            System.out.println(sb);

        }
    }
}
