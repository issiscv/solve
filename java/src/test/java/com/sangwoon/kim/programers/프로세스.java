package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {

	Solution solution = new Solution();
	@Test
	void solution() throws Exception {
		//priorities	location	return
		//[2, 1, 3, 2]	2	1
		//[1, 1, 9, 1, 1, 1]	0	5
		Assertions.assertThat(solution.solution(new int[]{2, 1, 3, 2}, 2)).isEqualTo(1);
		Assertions.assertThat(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0)).isEqualTo(5);
	}

	class Solution {

		class Priority {
			int priorities;
			int location;

			public Priority(int priorities, int location) {
				this.priorities = priorities;
				this.location = location;
			}
		}

		public int solution(int[] priorities, int location) {
			int answer = 0;

			Queue<Priority> queue = new LinkedList<>();
			Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < priorities.length; i++) {
				Priority priority = new Priority(priorities[i], i);
				queue.offer(priority);//2 1 3 2
				priorityQueue.offer(priorities[i]);//3 2 2 1
			}

			while (!queue.isEmpty()) {
				Priority priority = queue.poll();

				if (priority.priorities == priorityQueue.peek()) {
					priorityQueue.poll();
					answer++;

					if (priority.location == location) {
						break;
					}

				} else {
					queue.offer(priority);
				}
			}


			return answer;
		}
	}

}
