import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws Exception {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cnt = s.length() - s.replaceAll(" ","").length();
        if (s.charAt(0)==' ' && s.charAt(s.length()-1)==' '){
            System.out.print(cnt-1);
        }else if(s.charAt(0)==' ' || s.charAt(s.length()-1)==' '){
            System.out.print(cnt);
        }else {
            System.out.println(cnt+1);
        }

    }
}
