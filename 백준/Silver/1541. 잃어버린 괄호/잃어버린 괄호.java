
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] subtractions = br.readLine().split("-");

        int sum = 0;
        for(int i =0; i<subtractions.length; i++){
            int tempSum = Arrays.stream(subtractions[i].split("\\+"))
                    .mapToInt(Integer::parseInt)
                    .sum();
            if (i == 0) {
                sum += tempSum;
            } else {
                sum -= tempSum;
            }
        }


        System.out.println(sum);

    }

}