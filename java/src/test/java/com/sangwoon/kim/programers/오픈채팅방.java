package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

	class Solution {
		public String[] solution(String[] record) {
			Map<String, String> map = new HashMap<>();

			for (String s : record) {
				String[] contents = s.split(" ");
				String action = contents[0];
				String uid = contents[1];

				//Enter, Change
				if (!action.equals("Leave")) {
					map.put(uid, contents[2]);
				}
			}
			List<String> list = new ArrayList<>();
			for (String s : record) {
				String[] contents = s.split(" ");
				String action = contents[0];
				String uid = contents[1];

				String nickname = map.get(uid);

				if (action.equals("Enter")) {
					list.add(String.format("%s님이 들어왔습니다.", nickname));
				} else if (action.equals("Leave")) {
					list.add(String.format("%s님이 나갔습니다.", nickname));
				}
			}

			return list.toArray(new String[0]);
		}
	}

	@Test
	public void solution() throws Exception {
		Solution solution = new Solution();
		//["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
		solution.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
	}

}
