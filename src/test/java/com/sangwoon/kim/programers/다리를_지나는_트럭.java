package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

	@Test
	void solution() {

		//bridge_length	weight	truck_weights	return
		//2	10	[7,4,5,6]	8
		//100	100	[10]	101
		//100	100	[10,10,10,10,10,10,10,10,10,10]	110

		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(2, 10, new int[]{7, 4, 5, 6})).isEqualTo(8);
		Assertions.assertThat(solution.solution(100, 100, new int[]{10})).isEqualTo(101);
		Assertions.assertThat(solution.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10})).isEqualTo(110);

	}

	class Solution {

		class Truck {
			int weight;
			int time;

			public Truck(int weight, int time) {
				this.weight = weight;
				this.time = time;
			}
		}

		public int solution(int bridge_length, int limit, int[] truck_weights) {
			int time = 0;
			int sum = 0;
			int index = 0;

			Queue<Truck> queue = new LinkedList<>();

			while (!queue.isEmpty() || index < truck_weights.length) {
				time++;

				if (index < truck_weights.length && queue.isEmpty()) {
					queue.offer(new Truck(truck_weights[index], time));
					sum += truck_weights[index];
					index++;
					continue;
				}
				
				//다리에서 도착지로 나오는 트럭
				if (!queue.isEmpty() && time - queue.peek().time >= bridge_length) {
					sum -= queue.poll().weight;
				}

				//다리로 지나가는건 1초 사이에 같이 이뤄져야함
				if (index < truck_weights.length && truck_weights[index] + sum <= limit) {
					queue.offer(new Truck(truck_weights[index], time));
					sum += truck_weights[index];
					index++;
				}

			}

			return time;
		}
	}

}
