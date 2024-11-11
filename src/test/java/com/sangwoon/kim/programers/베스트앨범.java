package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 베스트앨범 {

	Solution solution = new Solution();

	@Test
	void solution() throws Exception {
		//["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
		Assertions.assertThat(solution.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})).isEqualTo(new int[]{4, 1, 3, 0});
	}

	class Solution {

		class Music {
			String genre;
			int play;
			int index;

			public Music(String genre, int play, int index) {
				this.genre = genre;
				this.play = play;
				this.index = index;
			}
		}

		public int[] solution(String[] genres, int[] plays) {
			Map<String, Integer> genreCountMap = new HashMap<>();
			List<Music> musicList = new ArrayList<>();
			for (int i = 0; i < genres.length; i++) {
				genreCountMap.put(genres[i], genreCountMap.getOrDefault(genres[i], 0) + plays[i]);
				musicList.add(new Music(genres[i], plays[i], i));
			}
			
			musicList.sort((o1, o2) -> {
				if (o1.genre.equals(o2.genre)) {
					if (o1.play == o2.play)
						return o1.index - o2.index;
					return o2.play - o1.play;
				}
				return genreCountMap.get(o2.genre) - genreCountMap.get(o1.genre);
			});

			List<Music> copy = new ArrayList<>();

			Map<String, Integer> countMap = new HashMap<>();
			for (Music music : musicList) {
				int count = countMap.getOrDefault(music.genre, 0);
				if (count >= 2) continue;
				countMap.put(music.genre, countMap.getOrDefault(music.genre, 0) + 1);

				copy.add(music);
			}

			int[] answer = copy.stream().mapToInt(music -> music.index).toArray();

			return answer;
		}
	}

}
