/**
 *
 */
package so.coolio.lv0;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* <p>
*
* </p>
*
* @author CoolioSo
* @version 1.0
* <li>CoolioSo(2023. 8. 9.,최초 작성)</li>
*/
public class 주사위_게임3 {
	public static void main(String... args) {
		System.err.println(solution(2, 2, 2, 2));
		System.err.println(solution(4, 1, 4, 4));
		System.err.println(solution(6, 3, 3, 6));
		System.err.println(solution(2, 5, 2, 6));
		System.err.println(solution(6, 4, 2, 5));
	}

	public static int solution(int a, int b, int c, int d) {
		int answer = 0;
		Map<Integer, Integer> resultMap = new HashMap<>();
		if(isValidateNumber(a)
				&& isValidateNumber(b)
				&& isValidateNumber(c)
				&& isValidateNumber(d)) {
			computeNumber(resultMap, a);
			computeNumber(resultMap, b);
			computeNumber(resultMap, c);
			computeNumber(resultMap, d);

			int keySize = resultMap.keySet().size();
			List<Integer> keySets =
					resultMap.entrySet().stream()
						 	 .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
						 	 .map(item -> item.getKey())
							 .collect(Collectors.toList());

			if(keySize == 1) {
				answer = 1111 * keySets.get(0);
			}else if(keySize == 2) {
				int key1 = keySets.get(0);
				int key2 = keySets.get(1);

				int value1 = resultMap.get(key1);

				if(value1 == 3) {
					answer =  (int) Math.pow((10 * key1 + key2), 2);
				}else{
					answer = (key1 + key2) * Math.abs(key1 - key2);
				}
			}else if(keySize == 3) {
				int key2 = keySets.get(1);
				int key3 = keySets.get(2);

				answer = key2 * key3;
			}else {
				answer = keySets.stream().sorted().findFirst().get();
			}

			return answer;
		}

        return answer;
    }

	public static void computeNumber(Map<Integer, Integer> resultMap, Integer num) {
		Integer count = resultMap.computeIfAbsent(Integer.valueOf(num), k -> 0);
		resultMap.put(Integer.valueOf(num), ++count);
	}

	public static boolean isValidateNumber(int num) {
		return num > 0 && num < 7;
	}
}
