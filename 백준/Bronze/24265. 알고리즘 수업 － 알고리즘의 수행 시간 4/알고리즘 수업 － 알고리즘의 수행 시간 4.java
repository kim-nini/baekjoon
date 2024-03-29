import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
* MenOfPassion(A[], n) {
    sum=0;
    for (1 to 6) //
        for (2 to 7) // (j=i+1)
            sum <- sum + A[i] × A[j]; # 코드1
    return sum;
}
* 코드 1이 실행되는 횟수
* n = 7 , i = 1 , j = i + 1
* A[1](A[2]+A[3]+...+A[7]) i=1 : n-1번 실행
* A[2](A[3]+A[4]+...+A[7]) i=2 : (n-2)번 실행
* A[3](A[4]+A[5]+...+A[7]) i=3 : (n-3)번 실행
* ...
* A[6]*A[7] i=6 : 1번 실행
* 실행 횟수의 총 합 = (n-1)+(n-2)+...+1 => 1 ~ (n-1)의 합
* 합의 공식 -> a(a+1)/2 : 1 ~ a 까지의 합
* a = (n-1) -> (n-1)(n-1+1)/2
* -> n^2-n/2 ------------- 출력 두번째 줄 다항식의 최고차항 차수 : 2
* -> n(n-1)/2 ---------- 출력 첫번째 줄
* */

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long n = Integer.parseInt(st.nextToken());
        bf.close();
        long a = n-1;
        long b = a*(a+1)/2;


        bw.write(b+"\n");
        bw.write("2");
        bw.flush();
        bw.close();

    }
}
