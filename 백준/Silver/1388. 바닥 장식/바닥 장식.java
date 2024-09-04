import java.io.*;
import java.util.*;

public class Main{
    static char[][] arr;
    static int X, Y;
    static int count;
    static boolean v,h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken()); // 세로
        Y = Integer.parseInt(st.nextToken()); // 가로
        arr = new char[X][Y];
        for (int i = 0; i < X; i++) {
            String s = br.readLine();
            for (int j = 0; j < Y; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        countHorizontal(0,0);
        countVertical(0,0);
        System.out.println(count);
    }
    static void countHorizontal(int x, int y){
        if(x>=X) return;
        if(y>=Y){
            count = h ? count + 1 : count;
            h=false;
            countHorizontal(x+1,0);
            return;
        }
      if(arr[x][y] == '-'){
          h=true;
      } else if (h){
          h=false;
          count++;
      }
      countHorizontal(x,y+1);
    }
    static void countVertical(int x, int y){
        if(y>=Y) return;
        if(x>=X){
            count = v ? count + 1 : count;
            v=false;
            countVertical(0,y+1);
            return;
        }
        if(arr[x][y] == '|'){
            v=true;
        } else if (v){
            v=false;
            count++;
        }
        countVertical(x+1,y);
    }
}
