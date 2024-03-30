import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        StringBuilder result = new StringBuilder();
        // 홀수 알파뱃이 1개 이상이면 만들 수 없음
        // 전부 짝수 이거나 짝수개+홀수개1개 여야함
        int[] abc = new int[26]; // 알파벳 아스키 배열
        for (int i = 0; i < sb.length(); i++) {
            abc[sb.charAt(i) - 'A'] += 1;
        }

        char center = 0;
        int odd = 0;
        // 배열 돌리기
        for (int i = 0; i < 26; i++) {

            if (abc[i] % 2 != 0) { // 갯수가 홀수개 인 경우
                for(int j= 0; j<abc[i]/2; j++){ // 갯수/2 만큼 반복해서 넣어줌
                    result.append((char)(i+65));
                }
                center = (char)(i+65); // 홀수일경우 가운데에 들어가야함
                odd++;
                if (odd >= 2) { // 갯수가 홀수인 알파벳이 2개 이상인 경우
                    System.out.println("I'm Sorry Hansoo");
                    result.setLength(0);
                    center=0;
                    break;
                }
            }
            if (abc[i] % 2 == 0) { // 만약 짝수 일 경우
                for(int j= 0; j<abc[i]/2; j++){ // 갯수/2 만큼 반복해서 넣어줌
                result.append((char)(i+65));
                }
            }
        }

        String answer ="";
        if(center==0){
            answer = result.toString()+result.reverse();
        }else {
            answer = result.toString() +center+ result.reverse();
        }

        System.out.print(answer);
    }
}



