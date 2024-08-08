
import java.io.*;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer subSt = new StringTokenizer(br.readLine(),"-");

        boolean firstToken = true;
        int sum = 0;
        while (subSt.hasMoreTokens()) {
            StringTokenizer addSt = new StringTokenizer(subSt.nextToken(),"\\+");
            int tmp = 0;
            while (addSt.hasMoreTokens()) {
                tmp += Integer.parseInt(addSt.nextToken());
            }
            if (firstToken) {
                sum += tmp;
                firstToken = false;
            }else{
                sum -= tmp;
            }
        }

        System.out.println(sum);


    }

}