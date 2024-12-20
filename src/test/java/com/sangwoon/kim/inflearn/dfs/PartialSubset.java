package com.sangwoon.kim.inflearn.dfs;

//부분 집합
public class PartialSubset {

	public void solution(int n) {
		DFS(1, "", n);
	}

	private void DFS(int L, String ch, int n) {
		if (L > n) {
			System.out.println(ch);
			return;
		} else {
			DFS(L + 1, ch + " " + L, n);
			DFS(L + 1, ch, n);
		}
	}

	public static void main(String[] args) {
		PartialSubset partialSubset = new PartialSubset();
		partialSubset.solution(3);
	}

}
