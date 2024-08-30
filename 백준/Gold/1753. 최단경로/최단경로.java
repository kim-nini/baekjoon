import java.io.*;
import java.util.*;

public class Main {
    static int V,E,K;
    static ArrayList<ArrayList<Edge>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(V+1);
        for(int i =0; i<V+1; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=1;i<=E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Edge(v,w));
        }

        printAnswer(dijkstra(K));
    }

    static int[] dijkstra(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] weight = new int[V+1];
        Arrays.fill(weight, Integer.MAX_VALUE);
        weight[start] = 0;
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curV = cur.v;
            int curW = cur.w;

            if(curW > weight[curV]){ continue;}

            for(Edge edge : graph.get(curV)){
                int newW = weight[curV] + edge.w;

                if(newW < weight[edge.v]){
                    weight[edge.v] = newW;
                    pq.add(new Edge(edge.v, newW));
                }
            }
        }
        return weight;
    }

    static void printAnswer(int[] dist){
        StringBuilder sb =new StringBuilder();
        for(int i=1;i<=V;i++){
            if(i==K){
                sb.append("0\n");
            }else{
                sb.append(dist[i]==Integer.MAX_VALUE? "INF":dist[i]).append("\n");
            }
        }

        System.out.print(sb);
    }

    static class Edge implements Comparable<Edge>{
        int v,w;

        Edge(int v,int w){
            this.v=v;
            this.w=w;
        }


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.w,o.w);
        }
    }
}
