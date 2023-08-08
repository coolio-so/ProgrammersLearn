/**
 *
 */
package so.coolio.lv0;

import java.util.Scanner;
import java.util.stream.Stream;

/**
* <p>
*
* </p>
*
* @author CoolioSo
* @version 1.0
* <li>CoolioSo(2023. 8. 8.,최초 작성)</li>
*/
public class 문자열_돌리기 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        if(a.length() >= 1 && a.length() <= 10){
            Stream.of(a.split("")).forEach(System.out::println);
        }
    }
}
