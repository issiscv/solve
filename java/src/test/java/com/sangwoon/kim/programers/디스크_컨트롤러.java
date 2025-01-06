package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

//[recap]
public class 디스크_컨트롤러 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		Assertions.assertThat(solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})).isEqualTo(9);
	}

	class Solution {
		
		class Job {
			int cost;//작업 소요 시간
			int idx;//작업 번호
			int requestTime;//작업 요청 시간

			public Job(int cost, int requestTime, int idx) {
				this.cost = cost;
				this.requestTime = requestTime;
				this.idx = idx;
			}
		}
		
		public int solution(int[][] jobs) {
			int answer = 0;

			int cursor = 0;
			int length = jobs.length;
			
			int currentTime = 0;
			
			//요청시간 별 정렬
			Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

			Queue<Job> queue = new PriorityQueue<>(
					(o1, o2) -> {
						if (o1.cost == o2.cost) {
							if (o1.requestTime == o2.requestTime) {
								return o1.idx - o2.idx;
							}

							return o1.requestTime - o2.requestTime;
						}
						return o1.cost - o2.cost;
					}
			);
			//이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.

			while (cursor < length || !queue.isEmpty()) {
				//현재 시간안에 작업이 들어온게 있으면 큐에 넣기
				//작업의 개수 || 현재시간안에 들어오는 작업의 요청 시간
				while (cursor < length && jobs[cursor][0] <= currentTime) {
					queue.offer(new Job(jobs[cursor][1], jobs[cursor][0], cursor));
					cursor++;
				}

				if (queue.isEmpty()) {
					currentTime = jobs[cursor][0];
					continue;
				}

				Job poll = queue.poll();
				currentTime += poll.cost;
				answer += currentTime - poll.requestTime;
			}

			return answer / length;
		}
	}

}
