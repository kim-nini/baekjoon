import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static int[] f;
    static int dp,rec =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        f = new int[n+1];

        fib(n);
        fibonacci(n);
        System.out.println(rec+" "+dp);

    }

    static int fib(int n){
        if(n==1 || n ==2){
            rec++;
            return 1;
        }else {
            return (fib(n-1)+fib(n-2));
        }
    }

    static int fibonacci(int n){
        f[1] = f[2] = 1;
        for(int i =3; i<=n; i++){
            f[i] = f[i-1]+f[i-2];
            dp++;
        }
        return f[n];
    }
}
