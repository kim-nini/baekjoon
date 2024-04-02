import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int button = Integer.parseInt(st.nextToken()); // 1. 스위치 개수
        boolean[] status = new boolean[button]; // 2. 스위치 상태 배열
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<button; i++){
            status[i] = Integer.parseInt(st.nextToken())==1;
        }

        st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(st.nextToken()); // 3. 학생수
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken()); // 4-1. 성별 1: 배수 상태변경 2: 대칭이면서 가장 많은 스위치를 포함하는 구간 변경 (홀수)
            int num = Integer.parseInt(st.nextToken()); // 4-2. 학생이 받은 수
            status = statusChange(status,sex,num);
        }

         int count = 0;
        for (int i = 0; i < status.length; i++) {
            System.out.print(status[i] ? 1 : 0);
            count++;
            if (count == 20) {
                System.out.println();
                count = 0;
            } else if (i != status.length - 1) {
                System.out.print(" ");
            }
        }
    }

    static boolean[] statusChange(boolean[] status, int sex, int num) {
        if (sex == 1) { // 남학생
            for (int i = num-1; i < status.length; i += num) {
                status[i] = !status[i];
            }
        } else if (sex == 2) { // 여학생
            int idx = num-1;
            for (int i = idx; i < status.length; i++) {
                if (2 * idx - i < 0) break;
                if (status[i] == status[2*idx-i]) {
                    if( i == 2*idx-i ) {status[i] = !status[i]; continue;} // 같은 idx 를 가리킬 경우
                    status[i] = !status[i];
                    status[2*idx-i] = !status[2*idx-i];
                } else  {
                    break;
                }
            }
        }
        return status;
    }
}

