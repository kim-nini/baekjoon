import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    /*후보 추천하기
     * 전체학생의 추천에 의해 정해진 수만큼 선정
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 액자 개수
        int totalReco = Integer.parseInt(br.readLine()); // 총 추천 횟수

        Map<Integer, Integer> map = new LinkedHashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < totalReco; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.size()!=N){ // 액자가 다 채워지지 않았을 경우
            map.put(num, map.getOrDefault(num, 0) + 1);}
            else { // 액자가 꽉 찼을 경우
                if(map.containsKey(num)){ // 이미 있는 번호면 +1
                    map.put(num, map.get(num)+1);
                }else{ // 액차꽉참 + 맵에 없는번호
                    // 맵에 있는 value 들중 가장 작은값을 가진 key 중 오래된 값을 삭제
                    int minValue = map.values().stream().min(Integer::compareTo).orElse(0);
                    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                        if(entry.getValue()==minValue){
                            map.remove(entry.getKey());
                            break;
                        }
                    }
                    map.put(num,1);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        map.keySet().stream().sorted().forEach(n -> sb.append(n).append(" "));

        System.out.println(sb);
    }
}
