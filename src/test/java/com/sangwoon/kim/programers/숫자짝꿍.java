package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 숫자짝꿍 {

	@Test
	void 숫자짝꿍() {
		Solution solution = new Solution();
		//"100"	"2345"	"-1"
		//"100"	"203045"	"0"
		//"100"	"123450"	"10"
		//"12321"	"42531"	"321"
		//"5525"	"1255"	"552"
		solution.solution(	"100", "2345");
//		solution.solution(	"100", "203045");
//		solution.solution(	"100", "123450");
//		solution.solution(	"12321", "42531");
//		solution.solution(	"5525", "1255");
	}

	class Solution {
		public String solution(String X, String Y) {

			char[] xChars = X.toCharArray();
			char[] yChars = Y.toCharArray();
			Map<String, Integer> xMap = new HashMap<>();
			Map<String, Integer> yMap = new HashMap<>();

			for (char xChar : xChars) {
				String s = String.valueOf(xChar);
				xMap.put(s, xMap.getOrDefault(s, 0) + 1);
			}

			for (char yChar : yChars) {
				String s = String.valueOf(yChar);
				yMap.put(s, yMap.getOrDefault(s, 0) + 1);
			}

			List<Integer> list = new ArrayList<>();
			for (String s : xMap.keySet()) {
				int xCount = xMap.get(s);
				int yCount = yMap.getOrDefault(s, 0);

				for (int i = 0; i < Math.min(xCount, yCount); i++) {
					list.add(Integer.parseInt(s));
				}
			}

			list.sort(Collections.reverseOrder());

			if (list.isEmpty()) return "-1";
			if (list.get(0) == 0) return "0";

			StringBuilder sb = new StringBuilder();
			for (int a : list) {
				sb.append(a);
			}

			return sb.toString();
		}
	}

}
