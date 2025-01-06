package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 줄_서는_방법 {

	@Test
	void solution() {
		//[1, 2, 3]
		//[1, 3, 2]

		//[2, 1, 3]
		//[2, 3, 1]

		//[3, 1, 2]
		//[3, 2, 1]

		//[1 2]

		//[2 1]

		//3! = 6, n = 3, 3! / 3 = 2 -> 2개 마다 앞자리가 바뀜
		//4! = 24, n = 4, 4! / 4 = 6 -> 3개 마다 앞자리가 바뀜

		Solution solution = new Solution();
		solution.solution(3, 5);

	}

	class Solution {
		public int[] solution(int n, long k) {
			int[] answer = new int[n];
			List<Integer> list = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				list.add(i);
			}

			//1 based 인덱스
			k--;

			int idx = 0;
			while (idx < n) {
				long fact = getFactorial(n - idx - 1);//(n-1)!

				int pos = list.get((int) (k / fact));//몇번째 그룹 인지
				answer[idx] = pos;
				list.remove((int) (k / fact));

				k = k % fact;//0
				idx++;
			}

			return answer;
		}

		private long getFactorial(int n) {
			long tmp = 1;

			for (int i = 1; i <= n; i++) {
				tmp = tmp * i;
			}

			return tmp;

		}

	}
}
