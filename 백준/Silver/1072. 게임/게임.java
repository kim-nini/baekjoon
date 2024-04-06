
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken()); // 게임 횟수
        long y = Integer.parseInt(st.nextToken()); // 이긴 게임

        long current = (y* 100)/x; // 현재 승률

        // 현재 승률이 99% 이상일 경우 승률을 올릴 수 없음
        if(current >= 99){
            System.out.println(-1); // -1 출력 후 프로그램 종료
            return;
        }

        // 이진탐색용 변수
        long start = 1;
        long end =  1000000000L; // 최대 추가 게임 횟수

        while(start < end){
            // 중간값
            long mid = (start+end)/2;
            // 새로운 값
            long newX = x+mid;
            long newY = y+mid;
            // 새로운 승률 계산
            long newRate = (newY*100)/newX;

            if(newRate>current){ // 현재승률보다 크다면 게임횟수 줄이기
                end = mid; // 끝값을 중간값으로 업데이트
            }else {
                start = mid +1; // 시작값 업데이트
            }
        }
        System.out.println(start);


    }
}
