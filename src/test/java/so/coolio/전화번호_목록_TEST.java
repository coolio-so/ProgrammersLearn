package so.coolio;

import java.util.Arrays;

import org.junit.Test;

/**
 * 문제 설명
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 * 
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 * @author YOUNGMIN JUN
 *
 */

public class 전화번호_목록_TEST {

	@Test
	public void 전화번호_목록() {
		String[] phone_book = {"123", "456", "789"};
		
		boolean answer = false;
		for(int i=0; i < phone_book.length; i++){
			if(answer){
				break;
			}
			
			for(int j=(i+1); j < phone_book.length; j++){
				if(answer){
					break;
				}
				
				answer = phone_book[i].startsWith(phone_book[j]) || phone_book[j].startsWith(phone_book[i]);
				System.err.println(phone_book[i] + "::" + phone_book[j]);
				System.err.println(phone_book[i].startsWith(phone_book[j]));
				System.err.println(phone_book[j].startsWith(phone_book[i]));
			}
			
		}
		
		System.err.println(answer);
	}
	
	
	@Test
	public void 전화번호_목록_베스트(){
		String[] phone_book = {"119", "97674223", "1195524421"};
		Arrays.sort(phone_book);
		
		boolean answer = true;
		
		for(int i=0; i < phone_book.length - 1; i++){
			if(phone_book[i+1].startsWith(phone_book[i])){ 
				answer = false;
				break;
			}
		}
		
		System.err.println(answer);
		
		
	}

}
