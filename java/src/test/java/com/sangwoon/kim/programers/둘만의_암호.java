package com.sangwoon.kim.programers;

import java.util.HashSet;
import java.util.Set;

public class 둘만의_암호 {

	class Solution {
		public String solution(String s, String skip, int index) {
			Set<Character> skipSet = new HashSet<>();
			for (char c : skip.toCharArray()) {
				skipSet.add(c);
			}

			StringBuilder answer = new StringBuilder();

			for (char c : s.toCharArray()) {

				char current = c;
				int count = 0;

				while (count < index) {
					current++;

					if (current > 'z') {
						current = 'a';
					}

					if (!skipSet.contains(current)) {
						count++;
					}

				}
				answer.append(current);
			}

			return answer.toString();
		}
	}


}
