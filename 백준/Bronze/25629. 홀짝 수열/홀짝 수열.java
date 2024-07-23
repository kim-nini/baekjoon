
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
     
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isOdd = n % 2 == 1;
        int oddCount = 0;
        int evenCount = 0;
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());
            if(x % 2 == 0) {
                evenCount++;
            }else{
                oddCount++;
            }
        }

        if (isOdd){
            System.out.println(oddCount==evenCount+1?"1":"0");
        }else{
            System.out.println(oddCount==evenCount?"1":"0");
        }
    }

}
