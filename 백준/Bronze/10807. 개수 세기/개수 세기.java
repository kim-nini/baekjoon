import java.util.*;
public class Main { 
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int find = sc.nextInt();

        for(int num : arr){
            if(num == find){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}