import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String a,b;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        b = st.nextToken();
        System.out.println(calc(false)+" "+calc(true));
    }

    public static int calc(boolean getMax){
        char oldC = getMax ? '5' : '6';
        char newC = getMax ? '6' : '5';

        return Integer.parseInt(a.replace(oldC, newC)) + Integer.parseInt(b.replace(oldC, newC));
    }

}