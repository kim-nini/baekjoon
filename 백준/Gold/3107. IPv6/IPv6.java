import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();

        String expandedIp = expandIp(ip);
        fullIp(expandedIp);

    }

    private static void fullIp(String ip) {
        StringBuilder sb = new StringBuilder();
        String[] arr = ip.split(":");
        for (String st : arr) {
            if (st.isEmpty()) continue;
            sb.append("0".repeat(4 - st.length())).append(st).append(":");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static String expandIp(String ip) {
        if (ip.contains("::")) {
            String tmp = ip.replace("::", ":"); // :: 없애주고
            String[] arr = tmp.split(":"); // : 로 나눴을때 몇개인지 세보고
            int i = arr[0].isEmpty() || arr[arr.length - 1].isEmpty() ? 9 - arr.length : 8 - arr.length;
            ip = ip.replace("::", ":0000".repeat(i) + ":");
        }
        return ip;
    }
}