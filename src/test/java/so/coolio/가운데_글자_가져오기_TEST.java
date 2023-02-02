package so.coolio;

import org.junit.Test;

public class 가운데_글자_가져오기_TEST {
    /**
     * 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
     *
     * 재한사항
     * s는 길이가 1 이상, 100이하인 스트링입니다.
     * 입출력 예
     * s	return
     * abcde	c
     * qwer	we
     */
    @Test
    public void 가운데_글자_가져오기_TEST(){
        String s = "qwer";
        String answer = "";

        int stringSize = s.length();
        int 몫 = stringSize / 2;
        int 나머지 = stringSize % 2;

        if(나머지 == 0) {
            answer = s.substring(몫-1, 몫+1);
        }else{
            answer = s.substring(몫, 몫+1);
        }

        System.out.println(answer);
    }
}
