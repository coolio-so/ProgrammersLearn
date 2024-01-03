/**
 *
 */
package so.coolio.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
* <p>
*
* </p>
*
* @author CoolioSo
* @version 1.0
* <li>CoolioSo(2023. 10. 4.,최초 작성)</li>
*/
public class 이중우선순위큐_TEST {

	@Test
	public void test() {
		List<String[]> test = new ArrayList<String[]>();
		test.add(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
		test.add(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
		test.add(new String[] {"I -45", "I 653", "D 1", "I -642", "I -45", "I 45", "I 97", "D 1", "D -1", "I 333", "D -45"});

		for(String[] tt : test) {
			System.err.println(solution(tt));
		}
	}

	public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> list = new ArrayList<>();

        for(String opr : operations){
            String[] method = opr.split(" ");
            String action = method[0];
            Integer value = Integer.valueOf(method[1]);

            if(action.equals("I")){
                System.out.println("I : " + value);
                que.offer(value);
                list.add(value);
            }else{
                if(value == 1){
                    System.out.println("D : 최대값 삭제 : " + que.size());
                    que.remove(getLastValue(que));
                    if(list.size() > 0){
                    	list.remove(0);
                    }
                }else if(value == -1){
                    System.out.println("D : 최소값 삭제 : " + que.size() + ", " + list.size());
                    if(que.size() > 0){
                        que.poll();
                    }

                    if(list.size() > 0){
                        System.out.println("D : GET 삭제 : " + list.get(list.size() - 1));

                        list.remove(list.get(list.size() - 1));
                    }

                }else{
                    System.out.println("D : " + value);
                    que.remove(value);
                    if(list.size() > 0){
                        System.out.println("D : GET 삭제 : " + list.get(list.size() - 1));

                        list.remove(list.get(list.size() - 1));
                    }
                }
            }

            Collections.sort(list, Collections.reverseOrder());

            System.out.println(que);
            System.out.println(list);
        }

        if(que.size() > 0){
            answer[1] = que.poll();
            answer[0] = getLastValue(que);
        }else{
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }

    private Integer getLastValue(PriorityQueue<Integer> que){
        Integer last = 0;
        for(Integer number : que){
            last = number;
        }

        return last;
    }

}
