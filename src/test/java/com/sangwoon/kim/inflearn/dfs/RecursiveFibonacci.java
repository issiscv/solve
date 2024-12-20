package com.sangwoon.kim.inflearn.dfs;

//피보나치
public class RecursiveFibonacci {

	public void solution(int n) {
		int[] dp = new int[n + 1];
		DFS(n, dp);

		for (int i : dp) {
			System.out.print(i + " ");
		}
	}

	private int DFS(int n, int[] dp) {
		if (dp[n] > 0) return dp[n];
		if (n == 1) return dp[1] = 1;
		if (n == 2) return dp[2] = 1;

		return dp[n] = DFS(n - 2, dp) + DFS(n - 1, dp);

	}

	public static void main(String[] args) {
		RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci();
		recursiveFibonacci.solution(45);
	}

}
