import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken()); // 입력 개수

        // 각 숫자의 중복 횟수를 저장할 HashMap
        Map<String, Integer> take = new HashMap<>();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            String num = st.nextToken();
            take.put(num, take.getOrDefault(num, 0) + 1); // 이미 있는 숫자인 경우 기존 값에 1을 더하고, 없는 경우 1로 초기화
        }

        st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken()); // 입력 개수

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            String given = st.nextToken();
            sb.append(take.getOrDefault(given,0) + " ");
        }

        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());

        bf.close();
        bw.flush();
        bw.close();
    }
}
