package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class 이중우선순위큐 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		//["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
		solution.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"});
	}

	class Solution {
		public int[] solution(String[] operations) {

			final String INSERT = "I";
			final String DELETE = "D";

			Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Integer> min = new PriorityQueue<>();


			for (int i = 0; i < operations.length; i++) {
				String[] command = operations[i].split(" ");
				String operator = command[0];
				int num = Integer.parseInt(command[1]);

				if (operator.equals(INSERT)) {
					max.offer(num);
					min.offer(num);
				} else if (operator.equals(DELETE)) {
					if (num == 1) {
						if (!max.isEmpty()) {
							int maxVal = max.poll();
							min.remove(maxVal);
						}
					} else if (num == -1) {
						if (!min.isEmpty()) {
							int minVal = min.poll();
							max.remove(minVal);
						}

					}
				}

			}

			// 큐가 비었으면 [0, 0] 반환
			if (max.isEmpty() || min.isEmpty()) {
				return new int[]{0, 0};
			}

			// 최대값, 최소값 반환
			return new int[]{max.peek(), min.peek()};
		}
	}
}


