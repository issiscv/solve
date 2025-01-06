package com.sangwoon.kim.inflearn.dfs;

import java.util.Scanner;

public class Permutation {
	static int N;
	static int M;
	static int[] arr;
	static int[] pm;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		arr = new int[N];
		pm = new int[M];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}

		DFS(0);

	}

	public static void DFS(int L) {
		if (L == M) {
			for (int i : pm) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					visited[i] = true;
					pm[L] = arr[i];
					DFS(L + 1);
					visited[i] = false;
				}
			}
		}
	}

}
