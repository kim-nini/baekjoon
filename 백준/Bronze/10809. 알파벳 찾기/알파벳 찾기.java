import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[26];
        Arrays.fill(arr,Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = Math.min(i, arr[s.charAt(i) - 'a']);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(arr[i] == Integer.MAX_VALUE){
                sb.append("-1");
            }else {
                sb.append(arr[i]);
            }
            sb.append(" ");
        }
        System.out.print(sb);



    }
}