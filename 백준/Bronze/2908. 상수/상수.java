import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // 입력문자 뒤집기
        int a = Integer.parseInt(String.valueOf(sb.append(sc.next()).reverse()));
        // sb 초기화
        sb.setLength(0);
        // 반복
        int b = Integer.parseInt(String.valueOf(sb.append(sc.next()).reverse()));

        // 최대값
        System.out.println(Math.max(a,b));
    }
}
