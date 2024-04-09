import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1부터 n까지의 입력값을 스택에 push와 pop을 해서 오름차순으로 만들 수 있는지 없는지
        // push 는 + pop은 -로  불가능할경우 no
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); // 결과 저장용 sb

        int next = 1; // 다음 스택에 push할 숫자
        boolean isPossible = true; // 불가능할 경우 NO
        for(int i =0; i<n; i++){
            int target = Integer.parseInt(br.readLine());

            while(next <= target){ // 타겟값이 next보다 작으면
                stack.push(next++); // 타겟값 까지 스택에 담아주기
                sb.append("+\n"); // + 출력
            }

            if(stack.peek() == target){ // 타겟값이 stack의 top과 같으면
                stack.pop(); // pop 해주고
                sb.append("-\n"); // - 출력
            }else{ // 타겟값이 stack의 top과 다르면
                isPossible = false; // 수열을 만들 수 없음
                break;
            }
        }

        System.out.println(isPossible ? sb : "NO");

    }

}


