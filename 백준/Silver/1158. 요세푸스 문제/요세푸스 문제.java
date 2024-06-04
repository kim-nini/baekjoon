import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int all = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i<=all; i++){
            queue.add(i);
        }

        sb.append("<");
        int dup = 0;
        int tmp =0;
        while(!queue.isEmpty()){
            tmp = queue.poll();

            if(++dup%count!=0){
                queue.add(tmp);
            }else {
                sb.append(tmp + ", ");
            }
        }

        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);

        sb.append(">");
        System.out.println(sb);

        }


    }
