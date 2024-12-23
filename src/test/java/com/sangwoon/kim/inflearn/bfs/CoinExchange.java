package com.sangwoon.kim.inflearn.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//동전 교환하기
public class CoinExchange {

	int N;
	int[] arr;

	public int solution(int N, int M, int[] arr) {
		this.N = N;
		this.arr = arr;

		return BFS(M);
	}

	private int BFS(int M) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(M);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				int poll = queue.poll();
				for (int j = 0; j < N; j++) {
					int tmp = poll - arr[j];

					if (tmp == 0) return count + 1;

					if (tmp >= 0) {
						queue.offer(tmp);
					}
				}
			}
			count++;
		}

		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}

		int M = scanner.nextInt();

		CoinExchange coinExchange = new CoinExchange();
		int solution = coinExchange.solution(N, M, arr);
		System.out.println(solution);

	}

}
