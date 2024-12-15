package com.sangwoon.kim.programers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 단어변환 {

	class Solution {
		Set<String> visited = new HashSet<>();
		int answer = Integer.MAX_VALUE;

		public int solution(String begin, String target, String[] words) {
			Set<String> set = new HashSet<>(Arrays.asList(words));

			if (!set.contains(target)) {
				return 0;
			}

			DFS(begin, target, 0, words);

			return answer == Integer.MAX_VALUE ? 0 : answer;
		}

		private void DFS(String begin, String target, int v, String[] words) {

			if (begin.equals(target)) {
				answer = Math.min(answer, v);
				return;
			}

			char[] beginCharArr = begin.toCharArray();

			for (int i = 0; i < words.length; i++) {
				String word = words[i];

				if (!visited.contains(word)) {
					char[] wordCharArr = word.toCharArray();

					int tmp = 0;
					for (int j = 0; j < wordCharArr.length; j++) {
						if (beginCharArr[j] != wordCharArr[j]) {
							tmp++;
						}
					}

					if (tmp == 1) {
						visited.add(word);
						DFS(word, target, v + 1, words);
						visited.remove(word);
					}
				}
			}
		}
	}

}
