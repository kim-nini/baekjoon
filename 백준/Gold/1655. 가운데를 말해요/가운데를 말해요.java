import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); // 정수의개수
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은값
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 값
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            if (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int num = Integer.parseInt(st.nextToken());
            if(maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
            
            if( maxHeap.size() > minHeap.size()+1) {
                minHeap.add(maxHeap.poll());
            }else if(minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
