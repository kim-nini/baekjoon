import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/* N*N개의 숫자가 주어졌을 때 N번째 큰 수 찾기 */

public class Main {
    static final  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 갯수 최대100개

        for(int i =0; i<T; i++){
            int N =  Integer.parseInt(br.readLine()); // 의상 수
            fashionKing(N);
        }

        br.close();
    }
    static void fashionKing(int N) throws IOException {
        Map<String,Integer> map = new HashMap<>();
        for(int j=0; j<N; j++){
            StringTokenizer st=  new StringTokenizer(br.readLine());
            st.nextToken(); // 첫번째 값 버리기
            String key = st.nextToken();
            // key값 없으면 1, 있으면 +1
            map.put(key,map.getOrDefault(key,0)+1);
        }

//        int one = 0; // 하나만 입었을 때
        int look = 1; // 2개이상 입었을 때
        for(int val : map.values()){
            look *= val+1;
//            one += val;
        }
        System.out.println(look-1);
    }


}

