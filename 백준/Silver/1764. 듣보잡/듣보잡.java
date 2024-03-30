import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 길이 N
        int M = Integer.parseInt(st.nextToken()); // 길이 M
        HashSet<String> list = new HashSet<>(); // 듣도 못한 사람
        for(int i=0; i<N; i++){
            list.add(br.readLine());
        }


        // 듣보 담을 쎗
        TreeSet<String> set = new TreeSet<>();
//        StringBuilder sb = new StringBuilder();
//        int cnt=0;
        for( int i=0; i<M; i++){ // 보못 돌리기
            String s = br.readLine();
            if(list.contains(s)){ // 듣못에 있으면 담기
//                sb.append(s+"\n");
//                cnt++;
                set.add(s);
            }
        }
        br.close();

//        sb.deleteCharAt(sb.length()-1);
//        System.out.println(cnt);
//        System.out.println(sb);
        System.out.println(set.size());
        for(String s: set){
            System.out.println(s);
        }
    }
}



