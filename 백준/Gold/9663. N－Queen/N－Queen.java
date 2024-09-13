import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int count = 0;
    static int[] queens;
    static boolean[] cols, d1, d2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 퀸 N 개
        queens = new int[N];
        cols = new boolean[N];
        d1 = new boolean[2*N-1]; // 왼쪽 대각선 row-col
        d2 = new boolean[2*N-1]; // 오른쪽 대각선 row+col

        placeQueen(0);
        System.out.println(count);

    }

    static void placeQueen(int row) {
           if(row == N){
               count++;
               return;
           }

           for(int col = 0; col < N; col++){
               if(!cols[col] && !d1[row-col +N-1] && !d2[row+col]){
                   queens[row] = col;
                   cols[col] = true;
                   d1[row-col+N-1] = true;
                   d2[row+col] = true;

                   placeQueen(row+1);
                   cols[col] = false;
                   d1[row-col+N-1] = false;
                   d2[row+col] = false;
               }
           }

    }
}