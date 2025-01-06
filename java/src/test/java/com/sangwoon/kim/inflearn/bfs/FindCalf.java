package com.sangwoon.kim.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;

//송아지 찾기
public class FindCalf {

	public int solution(int s, int e) {
		int[] dx = {1, -1, 5};
		int bfs = BFS(s, e, dx);
		return bfs;
	}

	private int BFS(int s, int e, int[] dx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(s);

		int count = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int poll = queue.poll();
				for (int j = 0; j < dx.length; j++) {
					int tmp = poll + dx[j];
					if (tmp == e) {
						return count + 1;
					} else {
						queue.offer(tmp);
					}
				}
			}

			count++;
		}

		return -1;
	}

	public static void main(String[] args) {
		FindCalf findCalf = new FindCalf();
		int solution = findCalf.solution(8, 3);
		System.out.println(solution);
	}

}
