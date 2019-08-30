package so.coolio.skill;

import java.util.Arrays;

import org.junit.Test;

public class Level02 {

	/**
	 * 〈 돌아가기 스킬 체크 테스트 Level.2 Java 레퍼런스 도움말 컴파일 옵션 테스트 종료
		문제1
		0 / (50.0)
		문제2
		0 / (50.0)
		문제 설명
		선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.
		
		예를 들어 선행 스킬 순서가 스파크 → 라이트닝 볼트 → 썬더일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.
		
		위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 스파크 → 힐링 → 라이트닝 볼트 → 썬더와 같은 스킬트리는 가능하지만, 썬더 → 스파크나 라이트닝 볼트 → 스파크 → 힐링 → 썬더와 같은 스킬트리는 불가능합니다.
		
		선행 스킬 순서 skill과 유저들이 만든 스킬트리1를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.
		
		제한 조건
		스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
		스킬 순서와 스킬트리는 문자열로 표기합니다.
		예를 들어, C → B → D 라면 CBD로 표기합니다
		선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
		skill_trees는 길이 1 이상 20 이하인 배열입니다.
		skill_trees의 원소는 스킬을 나타내는 문자열입니다.
		skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.
		입출력 예
		skill	skill_trees	return
		CBD	[BACDE, CBADF, AECB, BDA]	2
		입출력 예 설명
		BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
		CBADF: 가능한 스킬트리입니다.
		AECB: 가능한 스킬트리입니다.
		BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.
		스킬 트리: 유저가 스킬을 배울 순서 ↩
		
		Solution.java
		public int solution(String skill, String[] skill_trees) {
		        int answer = 0;
		        return answer;
		    }
		1
		class Solution {
		2
		    public int solution(String skill, String[] skill_trees) {
		3
		        int answer = 0;
		4
		        return answer;
		5
		    }
		6
		}
		실행 결과
		실행 결과가 여기에 표시됩니다.
		종료까지
		00:54:53
	 */
	@Test
	public void test01() {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		System.err.println(solution01(skill, skill_trees));
	}
	
	public int solution01(String skill, String[] skill_trees) {
        int answer = 0;
        char[] chars = skill.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append("[^");
        
        for(char c : chars){
        	sb.append(c).append("");
        }
        
        sb.append("]");
        
        for(String tree : skill_trees){
        	if(skill.indexOf(tree.replaceAll(sb.toString(), "")) == 0) answer++;
        }
        
        return answer;
    }
	
	/**
	 * · 문제 설명
		무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다. 예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다. 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다. 
		사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때, 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요. 
		 
		· 제한 사항
		무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다. 
		각 사람의 몸무게는 40kg 이상 240kg 이하입니다. 
		구명보트의 무게 제한은 40kg 이상 240kg 이하입니다. 
		구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
		
		· 입출력 예
		people	limit	return
		[70, 50, 80, 50]	100	3
		[70, 80, 50]	100	3
	 */
	@Test
	public void test02(){
		int[] people = {70, 80, 50, 50};
		int limit = 100;
		
		System.err.println(solution02(people, limit));
	}
	
	public int solution02(int[] people, int limit){
		Arrays.sort(people);
		
		int count = people.length;
		int i=0;
		
		for(int j = people.length - 1; j >= 0; j--){
			if(i == j) break;
			
			if(people[i] + people[j] <= limit){
				i++;
				count--;
			}
			
			if(i == j) break;
		}
		
		return count;
	}
}
