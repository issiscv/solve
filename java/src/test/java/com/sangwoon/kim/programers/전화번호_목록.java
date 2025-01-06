package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class 전화번호_목록 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		solution.solution(new String[]{"119", "97674223", "1195524421"});
		solution.solution(new String[]{"123", "456", "789"});
		solution.solution(new String[]{"12", "123", "1235", "567", "88"});
	}

	class Solution {
		public boolean solution(String[] phone_book) {
			boolean answer = true;

			HashMap<String, Integer> map = new HashMap<>();

			for (int i = 0; i < phone_book.length; i++) {
				map.put(phone_book[i], i);
			}

			for (int i = 0; i < phone_book.length; i++) {
				String number = "";
				for (int j = 0; j < phone_book[i].length(); j++) {
					number += phone_book[i].charAt(j);
				}

				if (map.containsKey(number) && map.get(number) != i) {
					answer = false;
					break;
				}

			}

			return answer;
		}
	}

}
