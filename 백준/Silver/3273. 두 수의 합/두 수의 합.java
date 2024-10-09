import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        System.out.print(numberOfCases(arr,x));
    }

    static int numberOfCases(int[] arr, int x) {
        int left = 0, right = arr.length - 1, count = 0, sum;
        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum > x) {
                right--;
            } else if (sum < x) {
                left++;
            } else {
                count++;
                left++;
                right--;
            }
        }
        return count;
    }
}


