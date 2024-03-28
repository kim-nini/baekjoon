import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();

        StringTokenizer st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken());

        HashMap<String,Integer> map = new HashMap<>();
        String[] tmp = new String[2];

        for(int i=0; i<num; i++){
            tmp = bf.readLine().split("\\.");
            if(map.containsKey(tmp[1])){
                map.replace(tmp[1], map.get(tmp[1])+1);
            }else {
                map.put(tmp[1],1);
            }
        }

        // 사전순서 정렬
        Map<String,Integer> map2 = new TreeMap<>(map);
        for(String key : map2.keySet()){
            bw.write(key+" "+map.get(key)+"\n");
        }



        bw.flush();
        bw.close();


    }
}
