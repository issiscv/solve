package com.sangwoon.kim.programers;

public class 음양_더하기 {

	class Solution {
		public int solution(int[] absolutes, boolean[] signs) {
			int answer = 0;

			for (int i = 0; i < signs.length; i++) {
				int n = absolutes[i];
				answer += (signs[i] ? n : -n);
			}


			return answer;
		}
	}

}
