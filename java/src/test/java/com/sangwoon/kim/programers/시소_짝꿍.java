package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 시소_짝꿍 {

	class Solution {
		public long solution(int[] weights) {
			long answer = 0;

			Arrays.sort(weights);

			Map<Double, Integer> map = new HashMap<>();
			for (int weight : weights) {
				double a = weight * 1.0;//1
				double b = (weight * 2) / 3.0;//2: 3
				double c = (weight * 1.0) / 2.0;//2: 1
				double d = (weight * 3.0) / 4.0;//3:4

				if (map.containsKey(a)) answer += map.get(a);
				if (map.containsKey(b)) answer += map.get(b);
				if (map.containsKey(c)) answer += map.get(c);
				if (map.containsKey(d)) answer += map.get(d);

				map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
			}

			return answer;
		}
	}

	@Test
	public void solution() throws Exception {
		//weights	result
		//[100,180,360,100,270]	4
		Solution solution = new Solution();
		long solution1 = solution.solution(new int[]{100, 180, 360, 100, 270});

	}

}
