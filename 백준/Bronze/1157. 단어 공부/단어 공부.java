import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int aski = 63; // '?' 아스키값

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        sb.append(br.readLine().toUpperCase()); // 대문자로 변환

        // 아스키코드값('A'=65)을 인덱스로 계산후 배열에 카운트
        for (int n = 0; n < sb.length(); n++) {
            int idx = sb.charAt(n) - 65;
            alphabet[idx]++;
        }

        int max = max(alphabet); // 최대값 구하기

        int dup = 0; // 중복 체크
        for (int i = 0; i < alphabet.length; i++) {
            // 최대값 idx 값 aski에 담기 / 여러개인경우 '?'값(63)
            if (max == alphabet[i]) {
                aski = dup==0 ? (i + 65) : 63;
                dup++;
            }
        }

        System.out.println((char) (aski));

    }

    static public int max(int[] arr) {
        int[] clone = arr.clone(); // arr 정렬 보존 위해 클론
        Arrays.sort(clone);
        int max = clone[clone.length - 1];
        return max;
    }


}



