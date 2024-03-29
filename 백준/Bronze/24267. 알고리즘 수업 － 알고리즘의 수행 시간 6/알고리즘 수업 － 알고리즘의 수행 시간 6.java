import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * 코드 1이 실행되는 횟수
 * n = 7 , i = 1 , j = i + 1 , k = j + 1
 * A[1](A[2](A[3]+...+A[7])      i=1 j=2: n-2번 실행 5
 * A[1](A[3](A[4]+...+A[7])      i=1 j=3: n-3번 실행 4
 * A[1](A[4](A[5]+A[6]+A[7])     i=1 j=4: n-4번 실행 3
 * A[1](A[5](A[6]+A[7])          i=1 j=5: n-5번 실행 2
 * A[1](A[6](A[7])               i=1 j=6:   1번 실행 1
 *
 * A[2](A[3](A[4]+...+A[7])      i=2 j=3: n-3번 실행 4
 * A[2](A[3](A[5]+...+A[7])      i=2 j=3: n-4번 실행 3
 * A[2](A[3](A[6]+A[7])          i=2 j=3: n-5번 실행 2
 * A[2](A[3](A[7])               i=2 j=3:   1번 실행 1
 *
 * A[3](A[4](A[5]+...+A[7])      i=3 j=4: n-4번 실행 3
 * ...
 * */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        long n = Integer.parseInt(st.nextToken());

        long a = 0;
        for(long i=1; i<n-1; i++){
            a += i*(i+1)/2;
        }



        bw.write(a+"\n");
        bw.write("3");


        bw.flush();
        bw.close();

    }

}
