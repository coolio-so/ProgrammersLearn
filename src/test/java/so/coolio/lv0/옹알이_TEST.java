/**
 *
 */
package so.coolio.lv0;

import java.util.stream.Stream;

import org.junit.Test;

/**
* <p>
*
* </p>
*
* @author CoolioSo
* @version 1.0
* <li>CoolioSo(2024. 12. 30.,최초 작성)</li>
*/
public class 옹알이_TEST {

	@Test
	public void 테스트() {
		String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"};
		solution(babbling);
	}

	public int solution(String[] babbling) {
        return Stream.of(babbling).map(talk -> getTalkableCount(talk)).reduce((a, b) -> a + b).get().intValue();
    }

    private int getTalkableCount(String talk){
        String[] talks = {"aya", "ye", "ma", "woo"};
        for(String say : talks){
            talk = talk.replace(say, "_");
        }

        talk = talk.replace("_", "");

        if(talk.length() == 0){
            return 1;
        }

        return 0;
    }
}
