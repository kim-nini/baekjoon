import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        System.out.print("0 "); // 첫번째는 무조건 0

        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek()[1] < height) { // 왼쪽 빌딩보다 높으면
                    stack.pop(); // 왼쪽 빌딩 버리기
                    System.out.print(stack.isEmpty() ? "0 " : "" ); // 빌딩이 없을 경우
                } else {// 왼쪽 빌딩보다 낮으면
                    System.out.print(stack.isEmpty() ? "0 " : stack.peek()[0] + " " ); // 왼쪽빌딩 높이 출력
                    break;
                }
            }
            // 위치, 높이 담기
            stack.push(new int[]{i, height});
        }

    }


}

