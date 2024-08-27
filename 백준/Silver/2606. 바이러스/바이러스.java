import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[][] computer;
    static boolean[] visited ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        computer = new int[n+1][n+1];
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i <m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computer[a][b] = 1;
            computer[b][a] = 1;
        }
        System.out.print(virus());

    }
    static int virus(){
        int count = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= n ; i++) {
                if(computer[cur][i] == 1 && !visited[i]){
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }
        return count;
    }

}


