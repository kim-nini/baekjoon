import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count = 0;
    static int eachDigit[] = new int[4];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N>99){
            countHansu(N);
        }
        count = N>99? count+99 : N;
        System.out.print(count);

    }
    static void countHansu(int N){
        for(int i = 100; i <= N; i++){
            String s = Integer.toString(i);
            eachDigit = s.chars().toArray();
            ArrayDeque<Integer> dq = new ArrayDeque<>();
            for(int j= 0; j< eachDigit.length-1; j++){
                dq.add(eachDigit[j]-eachDigit[j+1]);
            }
            dq.remove(dq.poll());
            if(dq.isEmpty()){
                count++;
            }
        }

    }
}