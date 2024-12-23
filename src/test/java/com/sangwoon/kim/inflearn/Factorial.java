package com.sangwoon.kim.inflearn;

import java.util.Arrays;
import java.util.Optional;

public class Factorial {

	public void solution(int n) {
		DFS(n, 1);
	}

	private void DFS(int n, int total) {
		if (n == 0) {
			System.out.println(total);
			return;
		} else {
			DFS(n - 1, total * n);
		}
	}

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		factorial.solution(5);

		Optional.of()
	}
	//



}
