import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;
    static int count = 0;
    static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈위치
        K = Integer.parseInt(st.nextToken()); // 동생위치
        visited = new boolean[100001];

        queue.add(N); // 시작값
        visited[N] = true; // 방문체크
        hideAndSeek();
    }

    public static void hideAndSeek() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j <size; j++) { // 같은 시간이 걸린 애들은 한번만 카운트
                int now = queue.poll(); // 하나 꺼내고
//                System.out.println("now: " + now);
                if (now == K) { // 동생 찾으면 출력
                    System.out.println(count);
                    return;
                }
                int[] next = {now + 1, now - 1, now * 2}; // 다음위치
                for (Integer i : next) {
                    if (0 <= i && i <= 100000 && !visited[i]) {
                        visited[i] = true; // 큐에 담았다고 체크
                        queue.add(i); // 자식 노드를 하나씩 담아줌
                    }
                }
            }
            count++;
//            System.out.println("count++: " + count);

        }

    }
}

