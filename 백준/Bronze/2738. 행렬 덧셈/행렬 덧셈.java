import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        matrix(st, arr, N, M, false);
        matrix(st, arr, N, M, true);
    }

    static void matrix(StringTokenizer st, int[][] arr, int N, int M, boolean run) throws IOException {
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] += Integer.parseInt(st.nextToken());
                if (run == true) System.out.print(arr[i][j] + " ");
            }
            if (run == true) System.out.println();
        }
    }

}

