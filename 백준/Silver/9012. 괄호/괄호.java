import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 몇줄

        
        Boolean yOrN = false; // 출력값 
        
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            for (int j = 0; j< line.length(); j++) {
                char c = line.charAt(j);
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        yOrN = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
                yOrN = stack.isEmpty();
            }
            System.out.println( yOrN ? "YES" : "NO");
        }


    }
}
