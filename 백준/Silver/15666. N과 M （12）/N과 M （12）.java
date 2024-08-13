import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int N,M;
    static int[] origin,sequence;
    static HashSet<String> set = new LinkedHashSet<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        origin = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        sequence = new int[M];
        Arrays.sort(origin);


        makeArray(0,0);

        for(String s : set){
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }

    static void makeArray(int start, int depth) {
        if (depth == M) {
            for(int i = 0; i < M; i++) {
                sb.append(sequence[i]).append(" ");
            }
            set.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for(int i = start; i < N; i++) {
            sequence[depth] = origin[i];
            makeArray(i, depth+1);
        }
    }

}