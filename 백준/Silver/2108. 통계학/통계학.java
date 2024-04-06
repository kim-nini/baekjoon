

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //수의 갯수

        int[] twoFour = new int[N]; // 2) 중앙값 4) 범위
        double one = 0; // 1) 산술평균
        Map<Integer,Integer> map = new HashMap<>(); // 3) 최빈값

        for(int i =0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            twoFour[i] = tmp;
            one += tmp; // 1) 총합
            map.put(tmp,map.getOrDefault(tmp,0)+1); // 3) 빈도수 value++
        }

        one = Math.round(one/N); // 1) 반올림
        Arrays.sort(twoFour); // 2,4) 오름차순
        int three = mostFrequent(map); // 3) 최빈값

//        System.out.printf("%.0f\n", one); //1)
        System.out.println((int) one); //1) 정수출력
        System.out.println(twoFour[N/2]); //2) 중앙값
        System.out.println(three); //3) 최빈값
        System.out.println(twoFour[N-1]-twoFour[0]); //4) 최댓값-최솟값
    }

    static int mostFrequent(Map<Integer,Integer> map){
        int max = -4001; // 입력 최솟값 -4000
        for (int key: map.keySet()) {
            if(map.get(key)>max){
                max = map.get(key); // 제일 많이 나온 숫자의 빈도수 담기
            }
        }
        // 3) 여러개일 경우 대비
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최빈값 담을 힙(오름차순)
        for(int key: map.keySet()){
            if(map.get(key)==max){ // 제일 많이 나온 숫자가 여러개일경우 전부 pq에 담음
                pq.add(key);
            }
        }
        int three = pq.poll(); // 최빈값
        if(!pq.isEmpty()){ // 여러개 일 경우 두번 째 작은 값
            three = pq.poll();
        }
        return three;
    }
}
