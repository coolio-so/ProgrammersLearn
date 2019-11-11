package so.coolio.stackqueue;

import org.junit.Test;

import java.util.Stack;

public class 쇠막대기_TEST {

    @Test
    public void 쇠막대기(){
        String str = "()(((()())(())()))(())";

        System.out.println(solution(str));
    }

    public int solution(String str){
        int result = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0; i < str.length(); i++){
            // 주어진 문자열의 현재값을 확인
            if(str.charAt(i) == '('){
                stack.add(str.charAt(i));
            }else{
                // ()를 제거하기 위해서 statck의 값을 pop
                stack.pop();
                // 현재 ) 이전의 문자열을 확인하여 ()이라면 현재까지 저장된 stack의 길이만큼 추가
                if(str.charAt(i-1) == '('){
                    result += stack.size();
                }
                // 현재 ) 이전의 문자열을 확인하여 ()이 아니라면 +1을 추가
                // )는 자르고 난 다음의 마지막 막대
                else{
                    result++;
                }
            }
        }

        return result;
    }
}
