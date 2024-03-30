import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder result = new StringBuilder();
        
        int[] abc = new int[26]; // 알파벳 아스키 배열
        char center = 0;
        int odd = 0;

        for (int i = 0; i < sb.length(); i++) {
            abc[sb.charAt(i) - 'A'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if (abc[i] % 2 != 0) {
                for (int j = 0; j < abc[i] / 2; j++) {
                    result.append((char) (i + 'A'));
                }
                center = (char) (i + 'A');
                odd++;
                if (odd >= 2) {
                    System.out.println("I'm Sorry Hansoo");
                    return; // 종료
                }
            } else {
                for (int j = 0; j < abc[i] / 2; j++) {
                    result.append((char) (i + 'A'));
                }
            }
        }

        String answer = (center == 0) ? result.toString() + result.reverse() : result.toString() + center + result.reverse();
        System.out.print(answer);
    }
}
