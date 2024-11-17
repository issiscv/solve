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
			int[] answer = {};

			Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Integer> min = new PriorityQueue<>();

			for (int i = 0; i < operations.length; i++) {
				String[] split = operations[i].split(" ");
				String operator = split[0];
				int value = Integer.parseInt(split[1]);

				if (operator.equals("I")) {
					max.offer(value);
					min.offer(value);
				} else if (operator.equals("D")) {
					if (max.isEmpty() || min.isEmpty()) {continue;}

					if (value == 1) {
						int maxVal = max.poll();
						min.remove(maxVal);
					} else if (value == -1) {
						int minVal = min.poll();
						max.remove(minVal);
					}
				}
			}

			if (max.isEmpty() || min.isEmpty()) {
				return new int[]{0, 0};
			}

			return new int[]{max.poll(), min.poll()};
		}
	}
}


