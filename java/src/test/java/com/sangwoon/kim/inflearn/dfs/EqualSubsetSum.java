package com.sangwoon.kim.inflearn.dfs;

import java.util.Arrays;
import java.util.Scanner;

//합이 같은 부분 집합
public class EqualSubsetSum {

	String answer = "NO";
	int total = 0;
	boolean flag = false;

	public String solution(int N, int[] arr) {
		total = Arrays.stream(arr).sum();
		if (total % 2 != 0) return "NO";

		DFS(0, 0, N, arr);

		return answer;
	}

	private void DFS(int L, int sum, int N, int[] arr) {
		if (flag) return;
		if (sum > total / 2) return;

		if (L == N) {
			if (total - sum == sum) {
				flag = true;
				answer = "YES";
				return;
			}
		} else {
			DFS(L + 1, sum + arr[L], N, arr);
			DFS(L + 1, sum, N, arr);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			int num = scanner.nextInt();
			arr[i] = num;
		}

		EqualSubsetSum equalSubsetSum = new EqualSubsetSum();
		String solution = equalSubsetSum.solution(N, arr);
		System.out.println(solution);
	}

}
