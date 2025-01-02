package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

public class 바탕화면_정리 {

	class Solution {
		public int[] solution(String[] wallpaper) {
			int[] answer = new int[4];
			int col = wallpaper[0].length();
			int minX = Integer.MAX_VALUE;
			int minY = Integer.MAX_VALUE;
			int maxX = Integer.MIN_VALUE;
			int maxY = Integer.MIN_VALUE;

			for (int i = 0; i < wallpaper.length; i++) {
				String walls = wallpaper[i];
				for (int j = 0; j < col; j++) {
					char c = walls.charAt(j);

					if (c == '#') {
						answer[0] = minX = Math.min(minX, i);
						answer[1] = minY = Math.min(minY, j);
						answer[2] = maxX = Math.max(maxX, i + 1);
						answer[3] = maxY = Math.max(maxY, j + 1);
					}
				}
			}

			return answer;
		}
	}

	@Test
	public void solution() throws Exception {
		Solution solution = new Solution();
		solution.solution(new String[]{".#...", "..#..", "...#."});
	}

}
