
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String functionString = br.readLine(); // 함수 RDD
            int n = Integer.parseInt(br.readLine()); // 원소 개수

            StringBuilder sb = new StringBuilder();
            String inputArr = br.readLine();
            String[] arr = new String[0];
            if (n > 0) {
                arr = inputArr.substring(1, inputArr.length() - 1).split(","); // 원소배열
            }

            System.out.println(findPointer(functionString, n, arr));
        }
    }

    static String findPointer(String s, int n, String[] arr) {
        int left = 0;
        int right = n - 1;
        int pointer = 0;
        for (int k = 0; k < s.length(); k++) {
            char function = s.charAt(k);
            if (function == 'R') {
                pointer = pointer == 0 ? 1 : 0;
            } else if (function == 'D') {
                if (left > right) {
                    return "error";
                }
                left = pointer == 0 ? left + 1 : left;
                right = pointer == 1 ? right - 1 : right;
            }
        }
        return printer(left, right, pointer, arr);
    }

    static String printer(int left, int right, int pointer, String[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (pointer == 0) {
            for (int j = left; j <= right; j++) {
                if(j==right){ sb.append(arr[j]); break;}
                sb.append(arr[j]).append(",");
            }
        } else {
            for (int j = right; j >= left; j--) {
                if(j==left){ sb.append(arr[j]); break;}
                sb.append(arr[j]).append(",");
            }
        }

        sb.append("]");
        return sb.toString();

    }
}


