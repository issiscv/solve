package com.sangwoon.kim.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/15829
 * Hashing
 */
public class BJ15829 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String str = br.readLine();

		int mod = 1234567891;
		int r = 31;
		long answer = 0;
		long pow = 1;
		for (int i = 0; i < str.length(); i++) {
			answer = (answer + (((str.charAt(i) - 'a' + 1) * pow) % mod)) % mod;
			pow = (pow * r) % mod;
		}
		System.out.println(answer % mod);

	}

}
