package com.sangwoon.kim.programers;

import org.junit.jupiter.api.Test;

public class 카펫 {

	@Test
	public void solution() throws Exception {
		//brown	yellow	return
		//10	2	[4, 3]
		//8	1	[3, 3]
		//24	24	[8, 6]
		Solution solution = new Solution();
		solution.solution(10, 2);
		solution.solution(8, 1);
		solution.solution(24, 24);
	}

	class Solution {
		public int[] solution(int brown, int yellow) {
			int answerRow = -1;
			int answerCol = -1;

			for (int row = 1; row <= yellow; row++) {
				int col = -1;
				if (yellow % row == 0) {
					col = yellow / row;
				}
				if (col != -1) {
					int brownRow = row + 2;//3
					int brownCol = col + 2;//4

					int size = brownRow * brownCol;
					if (size - brown == yellow) {
						if (brownRow >= brownCol) {
							answerRow = brownRow;
							answerCol = brownCol;
						} else {
							answerRow = brownCol;
							answerCol = brownRow;
						}
					}
				}
			}
			return new int[]{answerRow, answerCol};
		}
	}

}
