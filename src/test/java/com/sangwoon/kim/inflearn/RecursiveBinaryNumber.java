package com.sangwoon.kim.inflearn;

public class RecursiveBinaryNumber {

	public void solution(int n) {
		DFS(n, "");
	}

	private void DFS(int num, String str) {
		if (num == 0) {
			System.out.println(str);
			return;
		} else {
			DFS(num / 2, num % 2 + str);
		}
	}

	public static void main(String[] args) {
		RecursiveBinaryNumber recursiveBinaryNumber = new RecursiveBinaryNumber();
		recursiveBinaryNumber.solution(11);
	}

}
