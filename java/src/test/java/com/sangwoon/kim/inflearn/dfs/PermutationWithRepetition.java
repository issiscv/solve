package com.sangwoon.kim.inflearn.dfs;

//중복순열 구하기
public class PermutationWithRepetition {

	static int N;
	static int M;
	static int[] pm;

	public static void DFS(int L) {
		if (L == M) {
			for (int i : pm) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 1; i <= N; i++) {
				pm[L] = i;
				DFS(L + 1);
			}
		}
	}

	public static void main(String[] args) {
		N = 3;
		M = 2;
		pm = new int[M];
		DFS(0);
	}

}
