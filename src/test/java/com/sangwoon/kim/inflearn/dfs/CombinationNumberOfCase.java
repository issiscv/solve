package com.sangwoon.kim.inflearn.dfs;

import java.util.Scanner;

//조합
//nCr = n-1Cr-1 + n-1Cr
public class CombinationNumberOfCase {

	static int N;
	static int M;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		dp = new int[N + 1][M + 1];
		int dfs = DFS(N, M);
		System.out.println(dfs);
	}

	public static int DFS(int L, int R) {
		if (dp[L][R] > 0) return dp[L][R];
		if (R == L || R == 0) return dp[L][R] = 1;
		return dp[L][R] = DFS(L - 1, R - 1) + DFS(L - 1, R);
	}

}
