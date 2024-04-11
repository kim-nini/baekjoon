import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    /*첫째줄 : queuestack을 구성하는 자료구조의 개수 N (1 <= N <=100,000)
     * 둘째줄 : 길이 N의 수열 A (0 = 스택 , 1 = 큐)
     * 셋째줄 : 길이 N의 수열 B (i번 자료 구조에 들어있는 원소)
     * 넷째줄 : 삽입할 수열의 길이 M
     * 다섯째 : 길이 M의 수열 C */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 자료구조의 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] A = new boolean[N]; // true: queue / false: stack
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken()) == 0;
        }

//        int[] B = new int[N];
        Deque<Integer> deque = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num =Integer.parseInt(st.nextToken());
            if (A[i]) { // queue 일때만 값 받기 // stack은 필요없음
                deque.addLast(num); // 이미 들어가 있는 원소
            }
        }


        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            // 첫번째에 넣고 마지막에 뺀다
            // 만약 스택으로만 이루어졌다고 해도 pollLast이기 때문에 문제가 되지 않음
            deque.addFirst(tmp);
            sb.append(deque.pollLast()).append(" ");
        }

        System.out.print(sb);


    }
}

