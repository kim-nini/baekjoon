import java.io.*;
import java.util.*;

public class Main {
   static int N,M,count=0;
   static List<List<Integer>> graph;
   static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                countConnected(i);
                count++;
            }
        }

        System.out.print(count);
    }

    static void countConnected(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i : graph.get(cur)) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
