package com.sangwoon.kim.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2775
 * 부녀회장이 퇼테야
 */
public class BJ2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[k + 1][n + 1];
			for (int j = 0; j <= n; j++) {
				arr[0][j] = j + 1;
			}
			for (int j = 0; j <= k; j++) {
				arr[j][0] = 1;
			}

			for (int j = 1; j <= k; j++) {
				for (int l = 1; l <= n; l++) {
					arr[j][l] = arr[j][l - 1] + arr[j - 1][l];
				}
			}

			System.out.println(arr[k][n-1]);

		}

	}

}
