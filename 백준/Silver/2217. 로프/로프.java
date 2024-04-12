
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /* N개의 로프 (1 <= N <= 100,000)
    * k개의 로프를 사용해 중량이 w인 물체를 들어올릴 때
    * 각각의 로프에는 w/k 만큼의 중량이 걸림
    * 들어올릴 수 있는 최대 중량
    * 단, 임의로 몇개의 로프를 골라서 사용 가능*/
    // 100, 90 , 10, 15
    // 최대중량 = 180

    static int max = 0;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 로프의 개수

        arr = new Integer[N];
        for(int i = 0 ; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

//        Arrays.sort(arr, Collections.reverseOrder()); // 내림차순
        Arrays.sort(arr); // 오름차순

        maxWeight(0,N);

        System.out.println(max);

    }

    static void maxWeight(int start, int end){
        if(start < end){
        max = Math.max(arr[start]*(end-start),max);
        maxWeight(start+1,end);
        }
    }

}

