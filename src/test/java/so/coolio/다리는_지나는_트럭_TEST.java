package so.coolio;

import org.junit.Test;

import java.util.Queue;
import java.util.LinkedList;

public class 다리는_지나는_트럭_TEST {
    /**
     * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
     * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
     *
     * 예를 들어, 길이가 2대까지, 무게 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
     *
     * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
     * 0	[]	[]	[7,4,5,6]
     * 1~2	[]	[7]	[4,5,6]
     * 3	[7]	[4]	[5,6]
     * 4	[7]	[4,5]	[6]
     * 5	[7,4]	[5]	[6]
     * 6~7	[7,4,5]	[6]	[]
     * 8	[7,4,5,6]	[]	[]
     * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
     *
     * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
     *
     * 제한 조건
     * bridge_length는 1 이상 10,000 이하입니다.
     * weight는 1 이상 10,000 이하입니다.
     * truck_weights의 길이는 1 이상 10,000 이하입니다.
     * 모든 트럭의 무게는 1 이상 weight 이하입니다.
     * 입출력 예
     * bridge_length	weight	truck_weights	return
     * 2	10	[7,4,5,6]	8
     * 100	100	[10]	101
     * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
     */
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
