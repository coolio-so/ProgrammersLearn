package so.coolio;

import org.junit.Test;

import java.util.Queue;
import java.util.LinkedList;

public class 다리는_지나는_트럭_TEST {
    @Test
    public void 다리를_지나는_트럭(){
        // 지나갈 트럭
        int[] truck_weights = {7, 4, 5, 6};
        // 다리 길이
        int bridge_length = 2;

        // 다리 길이만큼 초기화
        Queue<Integer> tmp_bridge_trucks = new LinkedList<Integer>();
        for(int i=0; i < bridge_length; i++){
            tmp_bridge_trucks.offer(0);
        }

        // 결과 시간
        int answer = 0;
        // 다리의 무게
        int weight = 10;

        for(int truck : truck_weights){
            tmp_bridge_trucks.poll();

            while (!trucksSum(weight, tmp_bridge_trucks, truck)){
                // 공간확보를 위한 쉬프트
                answer += 1;
                tmp_bridge_trucks.poll();
                tmp_bridge_trucks.offer(0);
            }

            answer += 1;

            // 다리 쉬프트를 구현
            tmp_bridge_trucks.offer(new Integer(truck));
        }

        // 다리에 남아 있는 트럭이 있다면 모두 이동
        while(!bridegeEmptyCheck(tmp_bridge_trucks)){
            answer += 1;
            tmp_bridge_trucks.poll();
            tmp_bridge_trucks.offer(0);
        }

        System.out.println(answer);
    }

    /**
     * 생성된 길이 만큼 Queue를 생성하고 값을 0으로 채워서 Quque의 값이 들어 있는지를 확인
     * 비어 있으면 TRUE, 값이 있으면 FALSE
     * @param tmp_bridge_trucks
     * @return
     */
    public boolean bridegeEmptyCheck(Queue<Integer> tmp_bridge_trucks){
        int sum = 0;

        for(Integer item : tmp_bridge_trucks){
            sum += item.intValue();
        }

        if(sum == 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 입력되는 값을 Queue에 넣어서 크기를 넘는지 안넘는지 확인
     * 들어간 Queue 값이 문제 없으면 True, 문제 있으면 False
     * @param weight
     * @param tmp_bridge_trucks
     * @return
     */
    public boolean trucksSum(int weight, Queue<Integer> tmp_bridge_trucks, int nextWeight){
        int sum = 0;

        for(Integer item : tmp_bridge_trucks){
            sum += item.intValue();
        }

        sum += nextWeight;

        if(weight >= sum){
            return true;
        }else{
            return false;
        }
    }
}
