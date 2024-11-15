package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Arrays;

public class 디스크_컨트롤러 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		Assertions.assertThat(solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})).isEqualTo(9);
	}

	class Solution {

		class Job {
			int request; // 작업 요청 시각
			int cost;    // 작업 소요 시간
			int idx;     // 작업 번호

			public Job(int request, int cost, int idx) {
				this.request = request;
				this.cost = cost;
				this.idx = idx;
			}
		}

		public int solution(int[][] jobs) {
			int answer = 0;           // 총 반환 시간
			int currentTime = 0;      // 현재 시간
			int jobIndex = 0;         // 작업 순서를 나타내는 인덱스
			int totalJobs = jobs.length;  // 총 작업 개수
			Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

			Queue<Job> processingQueue = new PriorityQueue<>((o1, o2) -> {
				if (o1.cost == o2.cost) {
					if (o1.request == o2.request) {
						return o1.idx - o2.idx;
					}
					return o1.request - o2.request;
				}
				return o1.cost - o2.cost;
			});


			while (jobIndex < totalJobs || !processingQueue.isEmpty()) {
				while (jobIndex < totalJobs && jobs[jobIndex][0] <= currentTime) {
					processingQueue.offer(new Job(jobs[jobIndex][0], jobs[jobIndex][1], jobIndex));
					jobIndex++;
				}

				if (processingQueue.isEmpty()) {
					currentTime = jobs[jobIndex][0];
					continue;
				}

				Job poll = processingQueue.poll();
				currentTime += poll.cost;
				answer += currentTime - poll.request;
			}

			// 평균 반환 시간 계산 후 반환
			return answer / totalJobs;
		}
	}
}
