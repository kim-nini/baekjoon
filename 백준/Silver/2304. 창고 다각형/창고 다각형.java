
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // max기둥 값을 기준으로
        // 왼쪽 / 오른쪽 나누어서
        // 내림차순으로 큰 기둥을 이어서 지붕완성~!
        // 맨 왼쪽기둥과 맨오른쪽 기둥은 필수필수~
        // 왼쪽 : max기둥 > 2번째 큰 기둥(x)값  > 3번째 큰 기둥
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 기둥 수 1=<N=<1000

        Integer[] warehouse = new Integer[1001]; // 1 =< 위치와 기둥 =< 1000
        int maxHeight =0;
        int maxHeightlocate=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a); // 내림차순 queue


        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tmpLoca =Integer.parseInt(st.nextToken());
            int tmpHeigh =Integer.parseInt(st.nextToken());

            warehouse[tmpLoca] = tmpHeigh; // 위치에 높이 담기
            pq.add(tmpHeigh);

            if(tmpHeigh>=maxHeight){
                maxHeight = tmpHeigh; // 젤높은 기둥 높이
            }

        }

        maxHeightlocate = Arrays.asList(warehouse).lastIndexOf(pq.peek());

        // 우선순위 큐를 이용 한다고 쳤을때 높이만 담고
        // 첫번째값은 max 값이기떄문에 poll
        // max값의 인덱스를 기준으로
        // 두번째값의 인덱스가 크면 오른쪽 이고 오른쪽 끝 인덱스가 나올 때 까지 반복
        // 작으면 왼쪽이 됨 그리고 왼쪽 끝 인덱스가 나올때 까지 반복

        int area =maxHeight; // 최대기둥 넓이 넣기~
        pq.poll(); // 최대높이 버리기
        int rightStart = maxHeightlocate+1; // 오른쪽 넓이 계산용 시작값
        int leftStart = maxHeightlocate; // 왼쪽

        while(!pq.isEmpty()){

            int idx = Arrays.asList(warehouse).indexOf(pq.peek()); // 두번째로 높은 기둥의 인덱스
//            System.out.println("맥스기둥위치: "+maxHeightlocate);
//            System.out.println("idx: "+idx);

            if(idx>=maxHeightlocate && idx>=rightStart){ // 오른쪽
//                System.out.println("if문실행1");

                // 넓이 구하기
                area += ((idx+1)-rightStart)* pq.poll();
                rightStart = idx+1; // 넓이계산 위치 업데이트
                warehouse[idx] = 0; // 배열에서 삭제

                // 왼쪽
            }else if (idx<=maxHeightlocate && idx<=leftStart ){
                area += (leftStart-idx) * pq.poll();
                leftStart = idx;
                warehouse[idx] = 0; // 배열에서 삭제

            } else{ // 둘다 아닐 경우
                pq.poll();
                warehouse[idx] = 0; // 배열에서 삭제
            }
        }

        System.out.println(area);




    }
}
