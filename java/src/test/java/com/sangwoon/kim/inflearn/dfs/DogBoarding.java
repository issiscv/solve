package com.sangwoon.kim.inflearn.dfs;

import java.util.Scanner;

//바둑이 승차
public class DogBoarding {

	int answer = Integer.MIN_VALUE;

	public int solution(int C, int N, int[] arr) {
		DFS(0, 0, arr, C, N);
		System.out.println(answer);
		return answer;
	}

	private void DFS(int L, int sum, int[] arr, int C, int N) {
		if (sum > C) return;

		if (L == N) {
			answer = Math.max(answer, sum);
		} else {
			DFS(L + 1, sum + arr[L], arr, C, N);
			DFS(L + 1, sum, arr, C, N);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int C = scanner.nextInt();
		int N = scanner.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}

		DogBoarding dogBoarding = new DogBoarding();
		dogBoarding.solution(C, N, arr);

	}

}
