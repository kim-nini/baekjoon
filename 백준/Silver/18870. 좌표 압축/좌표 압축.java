import java.io.*;
import java.util.*;

/* 좌표 압축
 * 좌표 배열 {2 4 -10 4 -9} 일 때
 * 현재 좌표 보다 값이 작은 좌표의 갯수를 넣는 것
 * ex ) 좌표값이 2 일경우 2보다 작은 숫자는 -10 -9 2개 이므로 2가됨
 * 압축 -> { 2 3 0 3 1 }
 * */
public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 좌표의 갯수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] x = new int[n]; // 좌표 담기
        int[] sortedX = new int[n]; // 정렬된 좌표를 담기

        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            sortedX[i] = x[i];
        }

        Arrays.sort(sortedX); // 좌표 정렬

        Map<Integer, Integer> map = new HashMap<>(); // 좌표 압축 결과 저장
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sortedX[i])) {
                map.put(sortedX[i], rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(x[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
