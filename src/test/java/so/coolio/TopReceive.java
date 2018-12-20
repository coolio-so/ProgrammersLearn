package so.coolio;

import org.junit.Test;

public class TopReceive {
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
                int receive = heights[j-1];
                if(receive > height){
                    result = j;
                    break;
                }
            }

            answer[i-1] = result;
        }
    }
}
