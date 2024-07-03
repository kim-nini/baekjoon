import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 2번 규칙 먼저 실행
    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ip = br.readLine();
        String ip2 = ip;
        StringBuilder sb = new StringBuilder();
        if(ip2.contains("::")){
            ip2 = ip2.replace("::",":"); // :: 없애주고
            String[] arr2 = ip2.split(":"); // : 로 나눴을때 몇개인지 세보고
            int i = arr2[0].equals("")||arr2[arr2.length-1].equals("") ? 9-arr2.length : 8 - arr2.length;
//            if(arr2[0].equals("")||arr2[arr2.length-1].equals("")){
//                int i = 9-arr2.length;
//            }else {
//                int i = 8 - arr2.length;
//            }
            ip= ip.replace("::",":0000:".repeat(i));
        }

        String[] arr = ip.split(":");


        for(String st : arr){
            if (st.length()==1) {
                sb.append("000"+st+":");
            } else if (st.length()==2) {
                sb.append("00"+st+":");
            } else if (st.length()==3) {
                sb.append("0"+st+":");
            }else if (st.length()==4) {
                sb.append(st+":");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}