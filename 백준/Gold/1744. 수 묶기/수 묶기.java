import java.io.*;
import java.util.*;

public class Main {
  static long total = 0;
      public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Long> positiveNumbers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Long> negativeNumbers = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if(num > 0) positiveNumbers.add(num);
            if(num <= 0) negativeNumbers.add(num);
        }

        tieUp(positiveNumbers);
        tieUp(negativeNumbers);
        System.out.print(total);
    }

    static void tieUp(PriorityQueue<Long> pq){
        while(pq.size() > 1){
            long a = pq.poll();
            total += pq.peek()!=1 ? a* pq.poll() : a+ pq.poll();
        }
        while(!pq.isEmpty()){
            total += pq.poll();
        }
    }
}


