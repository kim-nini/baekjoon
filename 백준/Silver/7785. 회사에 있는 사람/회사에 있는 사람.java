import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();

        StringTokenizer st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken()); // 로그 갯수

        TreeMap<String,String> map = new TreeMap<>(Collections.reverseOrder()); // 로그 맵 정렬

        String[] tmp = new String[2]; // split 용 temp 배열
        for(int i=0; i<num; i++){
            tmp = bf.readLine().split(" ");
           map.put(tmp[0],tmp[1]);            
        }


        for(String key : map.keySet()){
            if(map.get(key).equals("enter")) {
                bw.write(key + "\n");
            }
        }


        bw.flush();
        bw.close();


    }
}
