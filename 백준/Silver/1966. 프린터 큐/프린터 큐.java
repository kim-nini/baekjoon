import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{
    /* 순서먼저 확인 -> 중요도에 따라
     *  M 번째에 위치한 문서가 몇번째로 출력되는지 ? */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수 N
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서 M(idx)

            Queue<Doc> queue = new LinkedList<>(); // queue 생성

            st = new StringTokenizer(br.readLine()); // queue에 위치와 중요도 담기
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                queue.offer(new Doc(j, tmp));
            }

            int cnt = 0; // 몇번째로 인쇄 되는지 확인

            while (!queue.isEmpty()) {
                Doc now = queue.poll();
                boolean print = true;

                for (Doc waiting : queue) {
                    if (waiting.importance > now.importance) { // 대기중인 문서의 중요도가 더 크다면
                        print = false;
                        break;
                    }
                }

                if (print) {
                    cnt++; // 인쇄하고 카운트++
                    if (now.idx == M) { // 궁금한 문서 idx 찾았으면
                        System.out.println(cnt); // 출력 하고 반복문 탈출
                        break;
                    }
                } else {
                    queue.offer(now); // 다시넣기
                }
            }

        }
        br.close();
    }

    static class Doc {
        int idx, importance;
        public Doc(int idx, int importance) {
            this.idx = idx;
            this.importance = importance;
        }
    }
}
