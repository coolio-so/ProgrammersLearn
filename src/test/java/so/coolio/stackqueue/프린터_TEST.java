package so.coolio.stackqueue;

import java.util.LinkedList;

import org.junit.Test;

public class 프린터_TEST {

	@Test
	public void test() {
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		
		System.err.println(solutionOther(priorities, location));
	}

	/**
	 * 시간초과로 문제 실패
	 * @param priorities
	 * @param location
	 * @return
	 */
	public int solution(int[] priorities, int location) {
        int answer = 1;
        LinkedList<Print> data = new LinkedList<>();
        
        for(int i=0; i < priorities.length; i++){
        	data.add(new Print(i, priorities[i]));
        }
        
        while(!data.isEmpty()){
        	Print firstPrint = data.getFirst();
        	
        	for(int i=1; i < data.size(); i++){
        		// 대기목록 마지막으로 이동
        		if(firstPrint.value < data.get(i).value){
        			data.add(firstPrint);
        			data.removeFirst();
        			break;
        		}
        		
        		// 인쇄
        		if(i == data.size() - 1){
        			if(firstPrint.idx == location) return answer;
        			
        			data.removeFirst();
        			answer++;
        		}
        	}
        }
        
        return answer;
    }
	
	/**
	 * 필터링하는 부분을 스트림으로 처리하면 시관을 통과
	 * @param priorities
	 * @param location
	 * @return
	 */
	public int solutionOther(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Print> data = new LinkedList<>();
        
        for(int i=0; i < priorities.length; i++){
        	data.add(new Print(i, priorities[i]));
        }
        
        while(!data.isEmpty()){
        	Print firstPrint = data.getFirst();
        	data.removeFirst();
        	
        	int count = (int) data.stream().filter(item -> item.value > firstPrint.value).count();
        	if(count == 0){
        		answer++;
        	}else{
        		data.add(firstPrint);
        	}
        	
        	if(count == 0 && firstPrint.idx == location){
        		break;
        	}
        }
        
        return answer;
    }
}

class Print{
	int idx;
	int value;
	
	Print(int idx, int value){
		this.idx = idx;
		this.value = value;
	}
}
