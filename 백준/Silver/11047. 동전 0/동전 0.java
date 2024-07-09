
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i <= n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if(coin <= m){
                stack.push(coin);
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            if(m==0){break;}
            sum += m/stack.peek();
            m = m%stack.pop();
        }
        System.out.println(sum);
    }
}
