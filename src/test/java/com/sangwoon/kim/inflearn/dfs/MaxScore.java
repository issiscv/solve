package com.sangwoon.kim.inflearn.dfs;

import java.util.Scanner;

//최대점수 구하기
public class MaxScore {

	int[] scores;
	int[] times;
	int N;
	int M;
	int max = Integer.MIN_VALUE;

	public int solution(int n, int m, int[] scores, int[] times) {
		this.scores = scores;
		this.times = times;
		this.N = n;
		this.M = m;
		DFS(0, 0, 0);

		return max;
	}

	private void DFS(int L, int score, int time) {
		if (time > M) return;
		if (L == N) {
			max = Math.max(max, score);
			return;
		} else {
			DFS(L + 1, score + scores[L], time + times[L]);
			DFS(L + 1, score, time);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int N = scanner.nextInt();
		int M = scanner.nextInt();

		int[] scores = new int[N];
		int[] times = new int[N];

		for (int i = 0; i < N; i++) {
			scores[i] = scanner.nextInt();
			times[i] = scanner.nextInt();
		}

		MaxScore maxScore = new MaxScore();
		int solution = maxScore.solution(N, M, scores, times);

		System.out.println(solution);

	}

}
