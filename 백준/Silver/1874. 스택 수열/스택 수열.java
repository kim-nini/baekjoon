import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        ArrayList<String> operations = new ArrayList<>();
        boolean isPossible = true; 
        int start = 0; 

        for(int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());

            if (start < value) {
                for (int j = start + 1; j <= value; j++) {
                    stack.push(j);
                    operations.add("+");
                }
                start = value;
            } else if (stack.peek() != value) {
                isPossible = false;
                break;
            }
            stack.pop();
            operations.add("-");
        }

        if (isPossible) {
            for (String op : operations) {
                System.out.println(op);
            }
        } else {
     
            System.out.println("NO");
        }
    }
}
