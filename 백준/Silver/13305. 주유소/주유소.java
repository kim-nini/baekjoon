
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    /* 주유소
    * 왼쪽 - 오른쪽 까지 가는데 드는 최소비용
    * 첫째줄 : 도시 개수 N (2 <= N <= 100000)
    * 둘째줄 : 도로 길이 N-1개 (1 <= 도로길이 <= 1,000,000,000)
    * 셋째줄 : 주유소 가격 N개의 자연수 (1 <= 가격 <= 1,000,000,000) */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시개수
        int[] way = new int[N-1];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            way[i] = Integer.parseInt(st.nextToken());
        }

        long minCost = Integer.MAX_VALUE;
        long totalCost = 0;
        int[] oil = new int[N-1]; // 마지막은 필요없음
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            minCost = Math.min(minCost,Integer.parseInt(st.nextToken()));
            totalCost += minCost*way[i];
        }

        System.out.println(totalCost);
    }

}

