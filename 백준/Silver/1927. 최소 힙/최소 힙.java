
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                    if(pq.isEmpty()){
                        sb.append("0");
                    }else{
                        sb.append(pq.poll());
                    }
                    sb.append("\n");
            }else{
                pq.add(x);
            }
        }
        System.out.print(sb);
    }

}
