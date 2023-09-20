/**
 *
 */
package so.coolio;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
* <p>
* https://school.programmers.co.kr/learn/courses/30/lessons/120876#
* 선분 3개가 평행하게 놓여 있습니다. 세 선분의 시작과 끝 좌표가 [[start, end], [start, end], [start, end]] 형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 두 개 이상의 선분이 겹치는 부분의 길이를 return 하도록 solution 함수를 완성해보세요.
* lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.
* </p>
*
* @author CoolioSo
* @version 1.0
* <li>CoolioSo(2023. 9. 20.,최초 작성)</li>
*/
public class 겹치는_선분의_길이 {

	@Test
	public void test() {
//		in
//		);
//
//		for(int[][] lines : samples) {
//			solution(lines);
//		};
	}

	public int solution(int[][] lines) {
        Set<Integer> answer = new HashSet<>();

        // S0
        for(int i = 0; i < lines.length; i++){
            // S1
            for(int j=i+1; j < lines.length; j++){
                int[] f = lines[i];
                int[] l = lines[j];

                // System.out.println(f[0] + " : "  + l[0]);
                if(f[0] <= l[0]){
                    // System.out.println(" > " + f[1] + " : "  + l[0]);
                    int count = f[1] - l[0] > 0 ? f[1] - l[0] : 0;
                    count += l[0] < f[1] ? 1 : 0;

                    plusLineSize(answer, (l[0] < f[1] ? l[0] - 1 : f[1]), count);
                }else{
                    // System.out.println(" >> " + (l[1] - f[1] > 0 ? f[1] : l[1]) + " : "  + f[0]);
                    int count = (l[1] - f[1] > 0 ? f[1] : l[1]) - f[0] > 0 ? (l[1] - f[1] > 0 ? f[1] : l[1]) - f[0] : 0;
                    count += l[0] < f[1] ? 1 : 0;

                    plusLineSize(answer, (l[0] < f[1] ? f[0] - 1 : f[1]), count);
                }

                // System.out.println(answer);
            }
        }

        return answer.size() > 0 ? answer.size() - 1 : 0;
    }

    private void plusLineSize(Set<Integer> answer, int first, int count){
        for(int i = 1; i <= count; i++){
            answer.add(first + i);
        }
    }

}
