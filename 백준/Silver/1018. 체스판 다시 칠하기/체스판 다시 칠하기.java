import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][M];

        for(int i=0; i<N; i++){
            sb.append(br.readLine());
            for(int j=0; j<M; j++){
                arr[i][j] =sb.charAt(j)=='W';
            }
            sb.setLength(0);
        }

        int chessRow = N-7;
        int chessColumn = M-7;

        int answer = 64; // 최소값인 경우 : 최악의 경우의 수를 가정해서 써줌
        for(int i=0; i<chessRow; i++){
            for(int j =0; j<chessColumn; j++){
                // 최솟값
                answer=Math.min(answer, solve(arr, i, j));
            }
        }

        System.out.println(answer);
        br.close();
    }

    public static int solve(boolean[][] matrix, int x, int y){
        int chessX = x+ 8; // 체스판의 최대 경계
        int chessY = y+ 8;
        int count = 0;

        boolean color = matrix[x][y]; // 첫번째 칸이 true인게 최선일 것이라 가정

        for(int i=x; i<chessX; i++){
            for(int j=y; j<chessY; j++){
                if(matrix[i][j] != color){
                    count++;
                }
                color = (!color); // 다음칸으로 넘어갔을 때 컬러반전
            }
            color = (!color); // 행이 끝났을 때 컬러반전
        }
        return Math.min(count, 64-count);
    }

}

