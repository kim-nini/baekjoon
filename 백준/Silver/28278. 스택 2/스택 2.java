
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine()); // 명령줄
        Deque<Integer> stack = new ArrayDeque<Integer>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    } else {
                        sb.append("-1");
                    }
                    sb.append("\n");
                    break;
                case 3:
                    sb.append(stack.size());
                    sb.append("\n");
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                case 5:
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek());
                    } else {
                        sb.append("-1");
                    }
                    sb.append("\n");
                    break;
            }
        }
        System.out.print(sb);

    }
}
