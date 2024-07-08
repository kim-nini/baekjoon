
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String functionString = br.readLine(); // 함수 ex) RDD
            int n = Integer.parseInt(br.readLine()); // 원소 개수

            String inputArr = br.readLine();
            String[] arr = new String[0];
            if (n > 0) { // 원소 0개일 경우 처리
                arr = inputArr.substring(1, inputArr.length() - 1).split(","); // 원소배열
            }

            System.out.println(findPointer(functionString, n, arr));
        }
    }

    static String findPointer(String s, int n, String[] arr) {
        int left = 0; //f
        int right = n - 1; //t
        boolean pointer = false;
        for (int k = 0; k < s.length(); k++) {
            char function = s.charAt(k);
            if (function == 'R') {
                pointer = !pointer;
            } else if (function == 'D') {
                if (left > right) {
                    return "error";
                }
                if (pointer) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return printer(left, right, pointer, arr);
    }

    static String printer(int left, int right, boolean pointer, String[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (pointer) {
            for (int j = right; j >= left; j--) {
                sb.append(arr[j]);
                if (j != left) sb.append(",");
            }
        } else {
            for (int j = left; j <= right; j++) {
                sb.append(arr[j]);
                if(j!=right) sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}


