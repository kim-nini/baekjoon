
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static boolean[] arr = new boolean[10001];
    public static void main(String[] args) throws IOException {

        calc(1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10000; i++) {
            sb.append(arr[i] ? "" : i+"\n");
        }
        System.out.print(sb);

    }
    static void calc(int x){
        while(x<10000) {
            int tmp = x;
            String s = x + "";
            for (int i = 0; i < s.length(); i++) {
                tmp += s.charAt(i) - '0';
            }
            if (tmp < 10000) {
                arr[tmp] = true;
            }
            x++;
        }
    }
}


