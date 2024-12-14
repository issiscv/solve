package com.sangwoon.kim.programers;

import java.util.ArrayList;
import java.util.List;

public class 하노이의탑 {

	public int[][] solution(int n) {
		List<int[]> answer = new ArrayList<>();

		DFS(n, 1, 2, 3, answer);

		int[][] a = new int[answer.size()][];

		for (int i = 0; i < answer.size(); i++) {
			a[i] = answer.get(i);
		}

		return a;
	}

	private void DFS(int n, int a, int b, int c, List<int[]> answer) {
		if (n == 0) return;

		DFS(n - 1, a, c, b, answer);
		answer.add(new int[]{a, c});
		DFS(n - 1, b, a, c, answer);
	}


}
