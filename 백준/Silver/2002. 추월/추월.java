import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> enter = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            enter.add(br.readLine());
        }


        int cnt = 0;

        List<String> out = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int idx = enter.indexOf(s); // idx : enter 인덱스
            out.add(s);
            if (!check(enter, out, idx)) {//out리스트(내앞에 나온 차)에 enter(0부터 idx-1 까지)이 없으면 추월한 차임
                cnt++;

            }
        }
        System.out.println(cnt);
    }

    static boolean check(List<String> enter, List<String> out, int index) {
        return out.containsAll(enter.subList(0, index));
    }
}



