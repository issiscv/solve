package com.sangwoon.kim.inflearn.dfs;

import java.util.Scanner;

public class Combination {

	static int N;
	static int R;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		R = scanner.nextInt();

		DFS(0, 1, "");

	}

	public static void DFS(int L, int s, String combi) {
		if (L == R) {
			System.out.println(combi);
			return;
		} else {
			for (int i = s; i <= N; i++) {
				DFS(L + 1, i + 1, combi + i);
			}
		}
	}


}
