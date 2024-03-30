import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 길이 N
        List<String> list = new ArrayList<>(); // 끝말잇기 기록

        for (int i = 0; i < N; i++) {
            list.add(br.readLine()); // 기록담기
        }

        int idx = list.indexOf("?"); // ? 찾기

        int M = Integer.parseInt(br.readLine()); // 후보

        String s = "정답";
        for (int i = 0; i < M; i++) {
            s = br.readLine();
            if (list.contains(s)) {
                continue;
            }
            // ? 가 첫번째
            if (idx == 0 && list.size() <= 1) {
                break;
            } else if (idx == 0 && list.get(idx + 1).charAt(0) == s.charAt(s.length() - 1)) {
                break;
            // ? 가 마지막
            } else if (idx == list.size() - 1 && list.get(idx - 1).charAt(list.get(idx - 1).length() - 1) == s.charAt(0)) {
                break;
            // 그 외
            } else if (idx > 0 && idx < list.size() - 1 && list.get(idx - 1).charAt(list.get(idx - 1).length() - 1) == s.charAt(0) && list.get(idx + 1).charAt(0) == s.charAt(s.length() - 1)) {
                break;
            }
        }
        br.close();
        System.out.println(s);


    }
}



