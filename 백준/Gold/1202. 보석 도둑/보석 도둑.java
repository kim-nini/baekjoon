import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(jewels, Comparator.comparingInt(j -> j.weight));

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long totalPrice = 0;
        int jewelIdx = 0;
        for( int bag : bags){
            while(jewelIdx < N && jewels[jewelIdx].weight <= bag){
                pq.add(jewels[jewelIdx].price);
                jewelIdx++;
            }

            if(!pq.isEmpty()){
                totalPrice += pq.poll();
            }
        }

        System.out.print(totalPrice);
    }

    static class Jewel{
        int weight;
        int price;

        public Jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

    }

}
