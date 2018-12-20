package so.coolio;

import org.junit.Test;

public class 주식가격_TEST {
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
