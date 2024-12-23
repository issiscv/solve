package com.sangwoon.kim.inflearn;

class Recursive {

	public void solution(int n) {
		DFS(n);
	}

	private void DFS(int L) {
		if (L == 0) return;
		DFS(L - 1);
		System.out.println(L);
	}

	public static void main(String[] args) {
		Recursive recursive = new Recursive();
		recursive.solution(3);
	}

}