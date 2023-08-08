/**
 *
 */
package so.coolio.lv0;

import java.util.Scanner;

/**
* <p>
*
* </p>
*
* @author CoolioSo
* @version 1.0
* <li>CoolioSo(2023. 8. 8.,최초 작성)</li>
*/
public class 대소문자_바꿔서_출력하기 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int length = a.length();

        if(length >=1 && length <= 20){
        	for(char chr : a.toCharArray()) {
        		System.out.print(Character.isLowerCase(chr) ? Character.toUpperCase(chr) : Character.toLowerCase(chr));
        	}
        }
    }
}
