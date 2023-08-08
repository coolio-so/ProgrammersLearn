/**
 *
 */
package so.coolio.lv0;

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
		System.err.println(solution(4));
	}

	public static int[][] solution(int n) {
		int[][] answer = new int[n][n];
		int minColumn = 0;
		int maxColumn = n - 1;
		int minRow = 0;
		int maxRow = n = 1;
		int direction = 0;
		int roate = 0;
		int currentValue = 0;

		while (currentValue < n * n) {
			answer[minColumn][currentValue] = ++currentValue;

			switch (direction) {
			case 0:
				System.err.println("오른쪽");
				break;
			case 1:
				System.err.println("하단");
				break;
			case 2:
				System.err.println("왼쪽");
				break;
			case 3:
				System.err.println("상단");
				break;

			default:
				break;
			}
		}

		return answer;
	}
}
