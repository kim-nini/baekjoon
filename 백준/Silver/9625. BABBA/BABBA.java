import java.io.*;

public class Main {

    static int A = 1;
    static int B = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        button(K);
        System.out.print(A+" "+B);
    }

    static void button(int K){
        for (int i = 0; i < K; i++) {
            int tempA = A;
            A = B;
            B += tempA;

        }
    }
}
