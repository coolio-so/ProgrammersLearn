/**
 *
 */
package so.coolio.lv0;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <p>
 *
 * </p>
 *
 * @author CoolioSo
 * @version 1.0
 *          <li>CoolioSo(2023. 8. 8.,최초 작성)</li>
 */
public class 정수를_나선형으로_배치하기 {
	public static void main(String[] args) {
		Integer[][] result = solution(5);

		Stream.of(result)
			  .flatMap(item -> Arrays.stream(item))
			  .peek(System.err::println)
			  .forEach(System.out::println);

	}

	public static Integer[][] solution(int n) {
		Integer[][] answer = new Integer[n][n];
		int minColumn = 0;
		int maxColumn = n - 1;
		int minRow = 0;
		int maxRow = n - 1;
		int direction = 0;
		int roate = 0;
		int currentValue = 0;

		int column = 0; int row = 0;

		while (currentValue <= (n * n)) {
			answer[row][column] = ++currentValue;

			if(direction == 0) {
				System.err.println("오른쪽");
				if(column == (maxColumn - roate)) {
					direction = 1;
					row++;
				}else {
					column++;
				}

			}else if(direction == 1) {
				System.err.println("하단");
				if(row == (maxRow - roate)) {
					direction = 2;
					column--;
				}else {
					row++;
				}

			}else if(direction == 2) {
				System.err.println("왼쪽");
				if(column == (minColumn + roate)) {
					direction = 3;
					row--;
					roate++;
				}else {
					column--;
				}

			}else if(direction == 3) {
				System.err.println("상단");
				if(row == (minRow + roate)) {
					direction = 0;
					column++;
				}else {
					row--;
				}
			}

			System.err.println(column + ", " + row + " = " + answer[column][row] );
			System.err.println(currentValue);
		}

		return answer;
	}
}
