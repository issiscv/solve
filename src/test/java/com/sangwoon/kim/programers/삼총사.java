package com.sangwoon.kim.programers;

public class 삼총사 {

	class Solution {
		int answer = 0;

		public int solution(int[] number) {
			DFS(0, 0, 0, number);
			return answer;
		}

		private void DFS(int v, int start, int ch, int[] number) {
			if (v == 3) {
				if (ch == 0) {
					answer++;
				}
			} else {
				for (int i = start; i < number.length; i++) {
					DFS(v + 1, i + 1, ch + number[i], number);
				}
			}
		}
	}

}
