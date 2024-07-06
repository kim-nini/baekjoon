
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 입력값
        int[] arr = new int[21];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String calc = st.nextToken();

            switch (calc) {
                case "add":
                    int add = Integer.parseInt(st.nextToken());
                    arr[add] = 1;
                    break;
                case "remove":
                    int remove = Integer.parseInt(st.nextToken());
                    arr[remove] = 0;
                    break;
                case "check":
                    int check = Integer.parseInt(st.nextToken());
                    sb.append(arr[check] == 1 ? "1" : "0").append('\n');
                    break;
                case "toggle":
                    int toggle = Integer.parseInt(st.nextToken());
                    arr[toggle] = arr[toggle] == 1 ? 0 : 1;
                    break;
                case "all":
                    Arrays.fill(arr, 1);
                    break;
                case "empty":
                    Arrays.fill(arr, 0);
                    break;
            }
        }
        System.out.print(sb);

    }
}
