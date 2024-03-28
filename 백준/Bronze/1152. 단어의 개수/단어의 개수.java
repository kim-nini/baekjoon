import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = bf.readLine();

        // 단어 카운트
        int cnt = 0;

        String[] answer = s.split(" ");

        for(String str : answer){
            // 공백 삭제
            str.replaceAll(" ","");
            // 단어인 경우 cnt++
            cnt += str.isEmpty() ? 0 : 1;
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();


    }
}
