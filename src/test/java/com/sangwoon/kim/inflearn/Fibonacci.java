package com.sangwoon.kim.inflearn;

public class Fibonacci {

	public void solution(int n) {

		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 1;
		DFS(3, n, arr);
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private void DFS(int start, int end, int[] arr) {
		if (start > end) {
			System.out.println(arr[end]);
			return;
		}
		arr[start] = arr[start - 1] + arr[start - 2];
		DFS(start + 1, end, arr);
	}

	public static void main(String[] args) {
		int n = 7;

		Fibonacci fibonacci = new Fibonacci();
		fibonacci.solution(n);
	}

}
