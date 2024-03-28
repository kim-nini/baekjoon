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
        int num = Integer.parseInt(st.nextToken()); // 파일개수

        TreeMap<String,Integer> map = new TreeMap<>(); // 확장자,갯수,정렬

        String[] tmp = new String[2]; // split 용 temp 배열
        for(int i=0; i<num; i++){
            tmp = bf.readLine().split("\\.");
            if(map.containsKey(tmp[1])){
                map.replace(tmp[1], map.get(tmp[1])+1);
            }else {
                map.put(tmp[1],1);
            }
        }

        for(String key : map.keySet()){
            bw.write(key+" "+map.get(key)+"\n");
        }


        bw.flush();
        bw.close();


    }
}
