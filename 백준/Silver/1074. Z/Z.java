
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        System.out.print(solve(size,0));

    }

    static int solve(int size, int count) {
        if (size == 1) {
            return count;
        }

        int newSize = size / 2;

        if (r < newSize && c < newSize) {
            return solve(newSize, count);
        }else if (r < newSize) {
            c = c-newSize;
            return solve(newSize, count + newSize * newSize);
        }
        else if (c < newSize) {
            r = r-newSize;
            return solve(newSize, count + 2 * newSize * newSize);
        }
        else {
            c= c-newSize;
            r= r-newSize;
            return solve(newSize, count + 3 * newSize * newSize);
        }
    }

}


