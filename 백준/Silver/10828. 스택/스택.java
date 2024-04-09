import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령의 수

        Stack<Integer> stack = new Stack<>();
        String s = "";
        int a = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            if (s.equals("push")) {
                a = Integer.parseInt(st.nextToken());
            }

            switch (s) {
                case "push":
                    stack.push(a);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    System.out.println(stack.isEmpty()? 1 : 0);
                    break;
                case "top" :
                    System.out.println(stack.isEmpty()? -1 : stack.peek());
            }

        }


    }

}


