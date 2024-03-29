import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 방문 여부 체크 배열
    static private boolean[] visited;
    // 수열을 저장할 리스트
    private static ArrayList<Integer> answer = new ArrayList<>();

//    static private final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 1부터 n까지 자연수 중 중복없이 m개를 고른 수열
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 배열 크기설정
        visited = new boolean[n];

        calc(0,n,m);
        bf.close();
        bw.flush();
        bw.close();

    }

    // 백트래킹을 수행하는 재귀 함수
    // index: 현재 위치, n: 최대 숫자, m: 수열의 길이
    private static void calc(int idx, int n, int m) throws IOException {
        if (idx == m) { // m 개를 다 고르면 출력
            for(int num : answer){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) { // 방문하지 않은 경우 (false)
                visited[i] = true; // 방문표시
                answer.add(i + 1); // 수열에 추가
                // 다음 수 탐색 위해 재귀 호출
                calc(idx + 1, n, m);
                // 현재 위치에서 더이상 탐색 할 수 없을 때 상태를 원상 복구
                visited[i] = false;
                answer.remove(answer.size()-1); // 마지막 요소 제거
            }
        }


    }
}
