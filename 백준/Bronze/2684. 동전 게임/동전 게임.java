
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int[] count = new int[8];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String s = br.readLine();
            checkArray(s);
            for(int n : count){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            Arrays.fill(count, 0);
        }

        System.out.print(sb);
    }

    static void checkArray(String s) {
        for(int i = 0; i < s.length()-2; i++) {
            String tmp = s.substring(i,i+3);
            switch(tmp){
                case "TTT" : count[0]++;break;
                case "TTH" : count[1]++;break;
                case "THT" : count[2]++;break;
                case "THH" : count[3]++;break;
                case "HTT" : count[4]++;break;
                case "HTH" : count[5]++;break;
                case "HHT" : count[6]++;break;
                case "HHH" : count[7]++;break;
            }
        }
    }
}