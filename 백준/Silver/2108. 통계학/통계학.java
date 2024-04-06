import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] twoFour = new int[N];
        double one = 0;
        Map<Integer,Integer> three = new HashMap<>();
        for(int i =0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            twoFour[i] = tmp;
            one += tmp;
            three.put(tmp,three.getOrDefault(tmp,0)+1);
        }
        one =  Math.round(one/N);
        Arrays.sort(twoFour);

        int max = -4001; // 최빈값
        for (int key: three.keySet()) {
            if(three.get(key)>max){
                max = three.get(key);
            }
        }
        // 여러개인지 확인
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 최빈값 담을 힙
        for(int key: three.keySet()){
            if(three.get(key)==max){
                pq.add(key);
            }
        }
        int thirdAnswer = pq.poll(); // 최빈값
        if(!pq.isEmpty()){ // 최빈값이 하나 더 있을경우 두번째로 작은 값 넣기
            thirdAnswer = pq.poll();
        }


        System.out.printf("%.0f\n", one);
        System.out.println(twoFour[N/2]);
        
        System.out.println(thirdAnswer);
        System.out.println(twoFour[N-1]-twoFour[0]);

    }
}
