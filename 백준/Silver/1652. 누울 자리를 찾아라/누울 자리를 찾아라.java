import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder row = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int rowCnt = 0;
        int columnCnt = 0;
        boolean[][] arr = new boolean[N][N];

        for (int i=0; i < N; i++) {
            row.append(br.readLine());
            for (int j=0; j<N; j++){
                arr[i][j] = row.charAt(j) == '.';
            }
            row.setLength(0);
        }

        // 다음 x 가 나올때 까지 true가 2개 이상이면 카운투++
        for (int i=0; i < N; i++) {
            for (int j=0; j<N; j++){
                if(!arr[i][j]){
                    if (j - 2 >= 0 && arr[i][j-2] && arr[i][j-1]) {
                        rowCnt ++;
                    }
                } else if (j == N-1){
                    if (j - 1 >= 0 && arr[i][j-1] && arr[i][j]) {
                        rowCnt ++;
                    }
                }
            }
        }

        for (int i=0; i < N; i++) {
            for (int j=0; j<N; j++){
                if(!arr[j][i]){
                    if(j - 2 >= 0 && arr[j-2][i] && arr[j-1][i]){
                        columnCnt++;
                    }
                }else if (j == N-1){
                    if (j - 1 >= 0 && arr[j-1][i] && arr[j][i]) {
                        columnCnt++;
                    }
                }
            }
        }



        System.out.println(rowCnt + " " + columnCnt);
        br.close();
    }

}

