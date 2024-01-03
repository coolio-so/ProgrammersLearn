package so.coolio.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class 위장_TEST {

	@Test
	public void test(){
		String[][] clothesA = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothesB = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

		System.err.println(solution(clothesA));
		System.err.println(solution(clothesB));

		throw new RuntimeException("aaa");
	}

	public int solution(String[][] clothes) {
		int answer = 1;
		Map<String, Integer> setMap = new HashMap<>();

		for(String[] clothe : clothes){
			String keyName = clothe[1];
			if(setMap.containsKey(keyName)){
				Integer value = setMap.get(keyName);
				setMap.put(keyName, value+1);
			}else{
				setMap.put(keyName, 1);
			}
		}

		for(int value : setMap.values()){
			answer *= (value+1);
		}

		answer -= 1;

		Set<Integer> tt = new HashSet<>();

        return answer;
    }

}
