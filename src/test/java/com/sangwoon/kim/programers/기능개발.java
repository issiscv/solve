package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
	Solution solution = new Solution();

	@Test
	 void solution() throws Exception {
		Assertions.assertThat(solution.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5})).isEqualTo(new int[]{2, 1});
		Assertions.assertThat(solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1})).isEqualTo(new int[]{1, 3, 2});
	}

	class Solution {

		public int[] solution(int[] progresses, int[] speeds) {
			ArrayList<Integer> answer = new ArrayList<>();
			Queue<Integer> queue = new LinkedList<>();

			for (int i = 0; i < progresses.length; i++) {
				queue.add((int) Math.ceil((100 - progresses[i]) / speeds[i]));
			}
			//5 10 1 1 20 1
			//1 3 2

			while (!queue.isEmpty()) {
				int day = queue.poll();
				int count = 1;

				while (!queue.isEmpty() && day >= queue.peek()) {
					queue.poll();
					count++;
				}
				answer.add(count);
			}

			return answer.stream().mapToInt(i -> i).toArray();
		}
	}

}
