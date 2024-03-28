import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        double sum = 0; // 평균 계산용 합계 변수

        int sub = sc.nextInt(); // 과목수
        int[] arr = new int[sub]; // 점수 담을 배열

        for (int i = 0; i < sub; i++) { // 배열에 점수담기
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        double max = arr[arr.length-1]; // 최대값

        if(max!=0.0) {
            for (int score : arr) {
                sum += score / max * 100;
            }
            System.out.println( sum / sub);
        }
        else {
            System.out.println(0.0);
        }

    }
}
