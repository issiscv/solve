package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 미로_탈출 {

	@Test
	void solution() {
		//    maps    result
		// ["SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"]    16
		// ["LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"]    -1
		Solution solution = new Solution();

		Assertions.assertThat(solution.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"})).isEqualTo(16);
		Assertions.assertThat(solution.solution(new String[]{"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"})).isEqualTo(-1);
	}

	class Solution {

		class Point {
			int x;
			int y;

			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

		int[] MOVE_X = new int[]{-1, 0, 1, 0};
		int[] MOVE_Y = new int[]{0, 1, 0, -1};

		char S = 'S'; // 시작 지점
		char E = 'E'; // 출구
		char L = 'L'; // 레버
		char O = 'O'; // 통로
		char X = 'X'; // 벽

		char[][] miro;
		int width, height;
		boolean[][] visited;

		public int solution(String[] maps) {
			width = maps.length;
			height = maps[0].length();
			miro = new char[width][height];
			visited = new boolean[width][height];

			int startX = 0, startY = 0;

			// 맵 초기화
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					miro[x][y] = maps[x].charAt(y);
					if (miro[x][y] == S) {
						startX = x;
						startY = y;
					}
				}
			}

			int leverDistance = BFS(startX, startY, L);
			if (leverDistance == -1) return -1;

			Point leverPoint = findPoint(L);
			resetVisited();

			int exitDistance = BFS(leverPoint.x, leverPoint.y, E);
			if (exitDistance == -1) return -1;

			return leverDistance + exitDistance;
		}

		private int BFS(int startX, int startY, char dest) {
			Queue<Point> queue = new LinkedList<>();
			queue.offer(new Point(startX, startY));
			visited[startX][startY] = true;

			int distance = 0;

			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					Point point = queue.poll();
					int currentX = point.x;
					int currentY = point.y;

					// 목적지를 찾으면 거리 반환
					if (miro[currentX][currentY] == dest) {
						return distance;
					}

					for (int j = 0; j < 4; j++) {
						int nextX = currentX + MOVE_X[j];
						int nextY = currentY + MOVE_Y[j];

						if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < height && !visited[nextX][nextY]) {
							if (miro[nextX][nextY] != X) {
								visited[nextX][nextY] = true;
								queue.offer(new Point(nextX, nextY));
							}
						}
					}
				}
				distance++;
			}
			return -1; // 탐색 실패
		}


		private Point findPoint(char target) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					if (miro[x][y] == target) {
						return new Point(x, y);
					}
				}
			}
			return null;
		}

		private void resetVisited() {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					visited[x][y] = false;
				}
			}
		}
	}
}
