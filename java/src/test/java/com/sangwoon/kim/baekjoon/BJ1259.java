package com.sangwoon.kim.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1259
 * 팰린드롬수
 */
public class BJ1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String str = br.readLine();
			if (str.equals("0")) {
				break;
			}
			String reverse = new StringBuffer(str).reverse().toString();

			if (str.equals(reverse)) System.out.println("yes");
			else System.out.println("no");

		}

	}

}
