package so.coolio;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import java.util.Queue;
import java.util.LinkedList;

public class SolutionTest {
    @Test
    public void 날짜_확인_테스트(){
         int a = 5;
         int b = 24;
         String answer = "";

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("KO"));
        cal.set(2016, (a - 1), b);

        int week = cal.get(Calendar.DAY_OF_WEEK);

        switch (week){
            case 1:
                answer = "SUN";
                break;
            case 2:
                answer = "MON";
                break;
            case 3:
                answer = "TUE";
                break;
            case 4:
                answer = "WED";
                break;
            case 5:
                answer = "THU";
                break;
            case 6:
                answer = "FRI";
                break;
            case 7:
                answer = "SAT";
                break;
            default:
                answer = "";
                break;
        }

         System.out.println(answer);

    }

    @Test
    public void 탑_수신_테스트(){
        int[] heights = {6, 9, 5, 7, 4};
        int[] answer = new int[heights.length];

        int size = heights.length;
        System.out.println("ARRAY SIZE : " + size);

        for(int i = size; i > 0; i--){
            int height = heights[i-1];
            int result = 0;

            for(int j = i-1; j > 0; j--){
                int recive = heights[j-1];
                if(recive > height){
                    result = j;
                    break;
                }
            }

            answer[i-1] = result;
        }
    }

    @Test
    public void 주식가격_테스트(){
        int[] prices = {498, 501, 470, 489};
        int[] answer = new int[prices.length];

        for(int i = 0 ; i < prices.length; i++){
            int price = prices[i];
            int sec = 0;

            for(int j=i; j < (prices.length - 1); j++){
                int comparePrice = prices[j];

                if(price <= comparePrice){
                    System.out.println(price + ":" + comparePrice + "PASS");
                    sec += 1;
                }else{
                    System.out.println(price + ":" + comparePrice + "BREAK");
                    break;
                }
            }

            answer[i] = sec;
        }

        for(int i : answer){
            System.out.println(i);
        }
    }

    @Test
    public void 다리를_지나는_트럭(){
        int[] truck_weights = {7, 4, 5, 6};
        int bridge_length = 2;

        Queue<Integer> tmp_bridge_trucks = new LinkedList<Integer>();
        // 다리 길이만큼 초기화
        for(int i=0; i < bridge_length; i++){
            tmp_bridge_trucks.offer(0);
        }

        int answer = 0;
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

        while(!bridegeEmptyCheck(tmp_bridge_trucks)){
            answer += 1;
            tmp_bridge_trucks.poll();
            tmp_bridge_trucks.offer(0);
        }

        System.out.println(answer);
    }

    /**
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
