package com.sangwoon.kim.baekjoon;

import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/2292
 * 벌집
 */
public class BJ2292 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int tmp = 1;
		int count = 1;
		while (num > tmp) {
			tmp += (6 * count++);
		}
		System.out.println(count);

	}
}
