package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 공원_산책 {

	@Test
	void solution() {

		//park	routes	result
		//["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
		//["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
		//["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]

		Solution solution = new Solution();
		int[] solution1 = solution.solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"});
		int[] solution2 = solution.solution(new String[]{"SOO", "OXX", "OOO"}, new String[]{"E 2", "S 2", "W 1"});
		int[] solution3 = solution.solution(new String[]{"OSO", "OOO", "OXO", "OOO"}, new String[]{"E 2", "S 3", "W 1"});

		Assertions.assertThat(solution1).isEqualTo(new int[]{2, 1});
		Assertions.assertThat(solution2).isEqualTo(new int[]{0, 1});
		Assertions.assertThat(solution3).isEqualTo(new int[]{0, 0});
	}

	class Solution {
		public int[] solution(String[] park, String[] routes) {
			int row = park.length;
			int col = park[0].length();
			char[][] map = new char[row][col];

			int x = 0, y = 0;

			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					map[i][j] = park[i].charAt(j);
					if (map[i][j] == 'S') {
						x = i;
						y = j;
					}
				}
			}

			for (String route : routes) {
				char direction = route.charAt(0);
				int distance = route.charAt(2) - '0';
				int tmpX = x, tmpY = y;
				boolean available = true;
				//각 현재 위치에서 방향에 따라 움직임
				if (direction == 'E') {
					if (y + distance < col) {
						for (int i = 1; i <= distance; i++) {
							if (map[x][y + i] == 'X') {
								available = false;
								break;
							}
						}
						if (available) {
							tmpY = y + distance;
						}
					}
				} else if (direction == 'W') {
					if (y - distance >= 0) {
						for (int i = 1; i <= distance; i++) {
							if (map[x][y - i] == 'X') {
								available = false;
								break;
							}
						}
						if (available) {
							tmpY = y - distance;
						}
					}
				} else if (direction == 'S') {
					if (x + distance < row) {
						for (int i = 1; i <= distance; i++) {
							if (map[x + i][y] == 'X') {
								available = false;
								break;
							}
						}
						if (available) {
							tmpX = tmpX + distance;
						}
					}
				} else if (direction == 'N') {
					if (x - distance >= 0) {
						for (int i = 1; i <= distance; i++) {
							if (map[x - i][y] == 'X') {
								available = false;
								break;
							}
						}
						if (available) {
							tmpX = tmpX - distance;
						}
					}
				}
				x = tmpX;
				y = tmpY;
			}
			return new int[]{x, y};
		}
	}


}

