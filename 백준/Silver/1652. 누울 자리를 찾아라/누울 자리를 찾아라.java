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

        for (int i = 0; i < N; i++) {
            row.append(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = row.charAt(j) == '.';
            }
            row.setLength(0);
        }

        // X이전 두칸이 true면 count++
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 행 검사
                if (!arr[i][j]) { // X를 만났을 때
                    if (j - 2 >= 0 && arr[i][j - 2] && arr[i][j - 1]) { // X 이전 두칸이 true인지 확인
                        rowCnt++;
                    }
                } else if (j == N - 1) { // X를 만나지 못하고 열이 끝났을 때
                    if (j - 1 >= 0 && arr[i][j - 1] && arr[i][j]) {
                        rowCnt++;
                    }
                }
                // 열 검사
                if (!arr[j][i]) {
                    if (j - 2 >= 0 && arr[j - 2][i] && arr[j - 1][i]) {
                        columnCnt++;
                    }
                } else if (j == N - 1) {
                    if (j - 1 >= 0 && arr[j - 1][i] && arr[j][i]) {
                        columnCnt++;
                    }
                }
            }
        }

        System.out.println(rowCnt + " " + columnCnt);
        br.close();
    }

}

