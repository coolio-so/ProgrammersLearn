/**
 *
 */
package so.coolio.skill;

import java.util.Arrays;

import org.junit.Test;

/**
* <p>
* 단어 퍼즐은 주어진 단어 조각들을 이용해서 주어진 문장을 완성하는 퍼즐입니다. 이때, 주어진 각 단어 조각들은 각각 무한개씩 있다고 가정합니다. 예를 들어 주어진 단어 조각이 [“ba”, “na”, “n”, “a”]인 경우 "ba", "na", "n", "a" 단어 조각이 각각 무한개씩 있습니다. 이때, 만들어야 하는 문장이 “banana”라면 “ba”, “na”, “n”, “a”의 4개를 사용하여 문장을 완성할 수 있지만, “ba”, “na”, “na”의 3개만을 사용해도 “banana”를 완성할 수 있습니다. 사용 가능한 단어 조각들을 담고 있는 배열 strs와 완성해야 하는 문자열 t가 매개변수로 주어질 때, 주어진 문장을 완성하기 위해 사용해야 하는 단어조각 개수의 최솟값을 return 하도록 solution 함수를 완성해 주세요. 만약 주어진 문장을 완성하는 것이 불가능하면 -1을 return 하세요.
*
* 제한사항
* strs는 사용 가능한 단어 조각들이 들어있는 배열로, 길이는 1 이상 100 이하입니다.
*strs의 각 원소는 사용 가능한 단어조각들이 중복 없이 들어있습니다.
*사용 가능한 단어 조각들은 문자열 형태이며, 모든 단어 조각의 길이는 1 이상 5 이하입니다.
*t는 완성해야 하는 문자열이며 길이는 1 이상 20,000 이하입니다.
* 모든 문자열은 알파벳 소문자로만 이루어져 있습니다.
* </p>
*
* @author CoolioSo
* @version 1.0
* <li>CoolioSo(2023. 3. 29.,최초 작성)</li>
*/
public class Level04 {

	@Test
	public void 최소의_경우() {
		String[] strs = {"ba", "an", "nan", "ban", "n"};
		String t = "banana";

		System.err.println(solution(strs, t));
	}

	public int solution(String[] strs, String t) {
		Arrays.sort(strs, (o1, o2) -> o2.length() - o1.length());

		int idx = 0;
		for(String item : strs) {
			while (t.indexOf(item) > -1) {
				int offSet = t.indexOf(item);
				if(offSet > -1) {
					t = t.replaceFirst(item, "");
					System.err.println(item + ", " + offSet);
					System.err.println(t);

					idx++;
				}
			}


			if(t.length() == 0) {
				break;
			}
		}

		return idx > 0 ? idx : -1;
	}

}
