package so.coolio.skill;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;

public class Level03 {

	@Test
	public void test1() {
		int[][] jobs = {{0,3}, {1,9}, {2,6}};
		System.err.println(solutionTask1(jobs));
	}
	
	public int solutionTask1(int[][] jobs){
		PriorityQueue<JobTaskVo> taskQueue = new PriorityQueue<>();
		List<JobTaskVo> taskList = new ArrayList<>();
		int length = jobs.length;
		
		for(int i=0; i < length; i++){
			taskQueue.add(new JobTaskVo(jobs[i][0], jobs[i][1]));
		}
		
		for(int i=0; i < length; i++){
			taskList.add(taskQueue.poll());
		}

		int currentTime=0;
		int sumTime = 0;
		
		while(taskList.size() > 0){
			for(int i=0; i < taskList.size(); i++){
				// 시작시간이 현재 시작보다 이전이라면 시작
				if(currentTime >= taskList.get(i).s){
					currentTime += taskList.get(i).e;
					sumTime += currentTime - taskList.get(i).s;
					
					taskList.remove(i);
					break;
				}
				
				// 시작시간이 현재 시간보다 이전인 것이 없다면 현재 시간 1초 증가
				if(i == (taskList.size() - 1)) currentTime++;
			}
		}
		
		return (int) Math.floor(sumTime/length);
	}

}


class JobTaskVo implements Comparable<JobTaskVo>{
	int s;
	int e;
	
	public JobTaskVo(int start, int end) {
		this.s = start;
		this.e = end;
	}

	@Override
	public int compareTo(JobTaskVo o) {
		// 작업시간에 대한 내림차순 정렬
		if(this.e < o.e){
			return -1;
		}else if(this.e == o.e){
			// 시작 시간에 대한 오름차순 정렬
			if(this.s < o.s) return 1;
			else return -1;
		} else return 1;
	}
}