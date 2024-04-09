
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 두줄 데이터 K의 갯수

        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않고, y의 높이가 낮다면
            // -> 건물이 있다는 것
            // pop하고 count ++
            while (!stack.isEmpty() && stack.peek() > y) {
                    stack.pop(); // 빼주고
                    count++; // 카운트
            }
            // 높이가 같다면
            // 같은 건물이기때문에 넣을 필요 없음
            if(!stack.isEmpty() && stack.peek() == y){
                continue;
            }
            // 높이가 높거나, 스택이 비어있을 경우 
            stack.push(y); // 담기 
        }

        // 스택에 남은 건물이 있을 경우
        while (!stack.isEmpty()){
            if(stack.peek()>0){ // 높이가 0 인 경우를 제외 하고
                count++;
            }
            stack.pop();
        }

        System.out.println(count);

    }

}


