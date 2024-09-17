import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = br.readLine();
        }

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(arr[i]==null || arr[j]==null) continue;
                if(arr[i].equals(arr[j])){
                    arr[j]=null;
                    continue;
                }
                if(arr[i].length() > arr[j].length()){
                    String temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }else if(arr[i].length() == arr[j].length()){
                    if(arr[i].compareTo(arr[j]) > 0){
                        String temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(arr[i]!=null) System.out.println(arr[i]);
        }

    }

}