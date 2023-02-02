package so.coolio;

import org.junit.Test;

public class 주식가격_TEST {
    /**
     * 문제 설명
     * 초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 유지된 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
     *
     * 제한사항
     * prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
     * prices의 길이는 2 이상 100,000 이하입니다.
     * 입출력 예
     * prices	return
     * [498,501,470,489]	[2,1,1,0]
     * 입출력 예 설명
     * 1초 시점의 ₩498은 2초간 가격을 유지하고, 3초 시점에 ₩470으로 떨어졌습니다.
     * 2초 시점의 ₩501은 1초간 가격을 유지하고, 3초 시점에 ₩470으로 떨어졌습니다.
     * 3초 시점의 ₩470은 최종 시점까지 총 1초간 가격이 떨어지지 않았습니다.
     * 4초 시점의 ₩489은 최종 시점까지 총 0초간 가격이 떨어지지 않았습니다.
     */
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
                    sec += 1;
                }else{
                    break;
                }
            }

            answer[i] = sec;
        }

        for(int i : answer){
            System.out.print(i);
        }
    }
}
