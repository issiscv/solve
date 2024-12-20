package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class 개인정보_수집_유효기간 {

	@Test
	public void solution() throws Exception {
		Solution solution = new Solution();
		solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
		System.out.println();
		solution.solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"});
	}

	class Solution {
		public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
			List<Integer> list = new ArrayList<>();

			Calendar calendar = Calendar.getInstance();

			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
			Date todayDate = format.parse(today);

			Map<String, Integer> map = new HashMap<>();
			for (String term : terms) {
				String[] set = term.split(" ");
				map.put(set[0], Integer.parseInt(set[1]));
			}

			for (String privacy : privacies) {
				String[] set = privacy.split(" ");
				int month = map.get(set[1]);

				Date contact = format.parse(set[0]);

				calendar.setTime(contact);
				calendar.add(Calendar.MONTH, month);

				format.format(calendar.getTime());
			}

			for (int i = 0; i < privacies.length; i++) {
				String[] set = privacies[i].split(" ");
				int month = map.get(set[1]);

				Date contact = format.parse(set[0]);

				calendar.setTime(contact);
				calendar.add(Calendar.MONTH, month);

				Date date = calendar.getTime();

				if (todayDate.after(date) || todayDate.equals(date)) {
					list.add(i + 1);
				}
			}

			return list.stream().mapToInt(i -> i).toArray();
		}
	}

}
