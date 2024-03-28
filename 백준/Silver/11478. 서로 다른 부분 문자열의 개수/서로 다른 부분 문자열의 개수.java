import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder(br.readLine());
        br.close();

        Set<String> set = new HashSet<>();

        int length = sb.length()-1;

        for(int i=0; i<sb.length(); i++){
            for(int j=i+1; j<=sb.length(); j++ ){
                set.add(sb.substring(i,j));
            }
        }

        bw.write(set.size()+"");
        bw.flush();
        bw.close();

    }
}
