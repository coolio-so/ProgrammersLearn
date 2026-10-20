package so.coolio.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

/**
문제 설명
라면 공장에서는 하루에 밀가루를 1톤씩 사용합니다. 원래 밀가루를 공급받던 공장의 고장으로 앞으로 k일 이후에야 밀가루를 공급받을 수 있기 때문에 해외 공장에서 밀가루를 수입해야 합니다.

해외 공장에서는 향후 밀가루를 공급할 수 있는 날짜와 수량을 알려주었고, 라면 공장에서는 운송비를 줄이기 위해 최소한의 횟수로 밀가루를 공급받고 싶습니다.

현재 공장에 남아있는 밀가루 수량 stock, 밀가루 공급 일정(dates)과 해당 시점에 공급 가능한 밀가루 수량(supplies), 원래 공장으로부터 공급받을 수 있는 시점 k가 주어질 때, 밀가루가 떨어지지 않고 공장을 운영하기 위해서 최소한 몇 번 해외 공장으로부터 밀가루를 공급받아야 하는지를 return 하도록 solution 함수를 완성하세요.

dates[i]에는 i번째 공급 가능일이 들어있으며, supplies[i]에는 dates[i] 날짜에 공급 가능한 밀가루 수량이 들어 있습니다.

제한사항
stock에 있는 밀가루는 오늘(0일 이후)부터 사용됩니다.
stock과 k는 2 이상 100,000 이하입니다.
dates의 각 원소는 1 이상 k 이하입니다.
supplies의 각 원소는 1 이상 1,000 이하입니다.
dates와 supplies의 길이는 1 이상 20,000 이하입니다.
k일 째에는 밀가루가 충분히 공급되기 때문에 k-1일에 사용할 수량까지만 확보하면 됩니다.
dates에 들어있는 날짜는 오름차순 정렬되어 있습니다.
dates에 들어있는 날짜에 공급되는 밀가루는 작업 시작 전 새벽에 공급되는 것을 기준으로 합니다. 예를 들어 9일째에 밀가루가 바닥나더라도, 10일째에 공급받으면 10일째에는 공장을 운영할 수 있습니다.
밀가루가 바닥나는 경우는 주어지지 않습니다.
입출력 예
stock	dates	supplies	k	result
4	[4,10,15]	[20,5,10]	30	2
입출력 예 설명
현재 밀가루가 4톤 남아 있기 때문에 오늘과 1일 후~3일 후까지 사용하고 나면 모든 밀가루를 다 사용합니다. 따라서 4일 후에는 반드시 밀가루를 공급받아야 합니다.
4일째 공급받고 나면 15일 이후 아침에는 9톤의 밀가루가 남아있게 되고, 이때 10톤을 더 공급받으면 19톤이 남아있게 됩니다. 15일 이후부터 29일 이후까지 필요한 밀가루는 15톤이므로 더 이상의 공급은 필요 없습니다.
따라서 총 2회의 밀가루를 공급받으면 됩니다.
※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.
 */
public class 라면공장_TEST {

	@Test
	public void test() {
		int stock = 4;
		int[] dates = {4,10,15};
		int[] supplies = {20,5,10};
		int k = 30;
		
		System.err.println(solution(stock, dates, supplies, k));
	}

	public int solution(int stock, int[] dates, int[] supplies, int k) {
		int answer = 0;
		PriorityQueue<SupplyVo> supplyQueue = new PriorityQueue<>();
		List<SupplyVo> list = new ArrayList<>();
		
		// 정렬이 되어도 PriorityQueue 내부적 idx 값은 변하지 않음
		for(int i=0; i < dates.length; i++){
			supplyQueue.add(new SupplyVo(dates[i], supplies[i]));
		}
		
		// 정렬된 순서대로 다시 List로 삽입
        for(int i=0; i < dates.length; i++){
        	list.add(supplyQueue.poll());
        }
        
        // stock 값이 k보다 작으면 반복
        while (stock < k) {
        	for(int i=0; i < list.size(); i++){
        		// date가 stock 보다 크다면 stock의 충전
        		if(stock >= list.get(i).date){
        			stock += list.get(i).supply;
        			list.remove(i);
        			answer++;
        			break;
        		}
        	}
		}
        
        return answer;
    }
}

class SupplyVo implements Comparable<SupplyVo>{
	int date;
	int supply;
	
	public SupplyVo(int date, int supply){
		this.date = date;
		this.supply = supply;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 공급량을 기준으로 내림차순으로 정렬을 하고, 공급량이 동일할 경우에는 날짜 순으로 오름차순 정렬을 한다.
	 */
	@Override
	public int compareTo(SupplyVo o) {
		// A보다 B가 더 크면 true(1)는 오름 차순
		// A보다 B가 더 크면 false(-1)는 내림차순
		if(this.supply > o.supply){
			return -1;
		}else if(this.supply == o.supply){
			if(this.date < o.date) return -1;
			else return 1;
		}else return 1;
	}
}
