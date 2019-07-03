package so.coolio;

import static org.junit.Assert.*;

import org.junit.Test;

public class 전화번호_목록_TEST {

	@Test
	public void 전화번호_목록() {
		String[] phone_book = {"119", "97674223", "1195524421"};
		
		boolean answer = true;
		for(int i=0; i < phone_book.length; i++){
			for(int j=(i+1); j < phone_book.length; j++){
				
				
				answer = (!phone_book[i].contains(phone_book[j]) && !phone_book[j].contains(phone_book[i]));
				System.err.println(phone_book[i] + "::" + phone_book[j]);
				System.err.println(phone_book[i].contains(phone_book[j]));
				System.err.println(phone_book[j].contains(phone_book[i]));
			}
			
		}
		
		System.err.println(!answer);
	}

}
