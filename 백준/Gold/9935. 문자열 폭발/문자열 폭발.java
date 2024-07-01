import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// 문자열 폭발
/*첫째 줄에 문자열이 주어진다. 문자열의 길이는 1보다 크거나 같고, 1,000,000보다 작거나 같다.
둘째 줄에 폭발 문자열이 주어진다. 길이는 1보다 크거나 같고, 36보다 작거나 같다.
두 문자열은 모두 알파벳 소문자와 대문자, 숫자 0, 1, ..., 9로만 이루어져 있다.*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String original = br.readLine();
        String compare = br.readLine();

        StringBuilder sb = new StringBuilder();

        int compareLength = compare.length();
        char lastChar = compare.charAt(compareLength - 1);

        for (int i = 0; i < original.length(); i++) {
            sb.append(original.charAt(i));
            if (sb.length() >= compareLength && sb.charAt(sb.length() - 1) == lastChar) {
                boolean match = true;
                for (int j = 0; j < compareLength; j++) {
                    if (sb.charAt(sb.length() - compareLength + j) != compare.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.setLength(sb.length() - compareLength);
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }

    }


}

