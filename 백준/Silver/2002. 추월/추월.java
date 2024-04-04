import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<String> enter = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            enter.offer(br.readLine());
        }

        int cnt = 0; // 추월카운트

        Queue<Integer> out = new ArrayDeque<>(); // 나간 순서
        for (int i = 0; i < N; i++) {
            String outCar = br.readLine();
            // 나온차가 들어간 순서와 같으면
            if(!outCar.isEmpty()&&enter.peek().equals(outCar)){
                enter.poll(); // 들어간 차 빼기
            }else { // 같지않으면
                cnt++; // 카운트++
                enter.remove(outCar); // 리스트에서 삭제
            }

        }
        br.close();
        System.out.println(cnt);
    }


}



