import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static private final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static private final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 수열을 저장할 리스트
    private static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 1부터 n까지 자연수 중 중복없이 m개를 고른 수열
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        calc(0, 0, n, m);
        bf.close();
        bw.flush();
        bw.close();

    }

    // 백트래킹을 수행하는 재귀 함수
    // index: 현재 위치, n: 최대 숫자, m: 수열의 길이, start: 시작값, 호출값
    private static void calc(int start, int idx, int n, int m) throws IOException {
        if (idx == m) { // m 개를 다 고르면 출력
            for (int num : answer) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i < n; i++) {
            answer.add(i + 1); // 수열에 추가
            calc(i + 1, idx + 1, n, m); // 다음 호출에서는 현재 선택한 수의 다음 수 부터시작 i+1
            answer.remove(answer.size() - 1); // 마지막 요소 제거
        }


    }
}