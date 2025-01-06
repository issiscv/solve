package com.sangwoon.kim.programers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 길_찾기_게임 {

	@Test
	public void solution() throws Exception {

		//[[5,3],[11,5],[13,3],[3,5],[6,1],[1,3],[8,6],[7,2],[2,2]]
		int[][] arr = {
				{5, 3},
				{11, 5},
				{13, 3},
				{3, 5},
				{6, 1},
				{1, 3},
				{8, 6},
				{7, 2},
				{2, 2}
		};
		int[][] answer =
				{
						{7, 4, 6, 9, 1, 8, 5, 2, 3},
						{9, 6, 5, 8, 1, 4, 3, 2, 7}
				};

		Solution solution = new Solution();
		Assertions.assertThat(solution.solution(arr)).isEqualTo(answer);

	}


	class Solution {

		class Point {
			int x;
			int y;
			int idx;

			public Point(int x, int y, int idx) {
				this.x = x;
				this.y = y;
				this.idx = idx;
			}
		}

		class Node {
			Point point;
			int idx;

			Node left;
			Node right;

			public Node(Point point, int idx) {
				this.point = point;
				this.idx = idx;
			}

			void insert(Node node) {
				if (node.point.x < this.point.x) {
					if (left == null) {
						left = node;
					} else {
						left.insert(node);
					}
				} else {
					if (right == null) {
						right = node;
					} else {
						right.insert(node);
					}
				}
			}
		}

		public int[][] solution(int[][] nodeinfo) {
			int[][] answer = new int[2][];

			//레벨
			List<Point> points = new ArrayList<>();

			for (int i = 0; i < nodeinfo.length; i++) {
				int x = nodeinfo[i][0];
				int y = nodeinfo[i][1];
				Point point = new Point(x, y, i + 1);
				points.add(point);
			}

			points.sort((o1, o2) -> o2.y - o1.y);

			Node root = new Node(points.get(0), points.get(0).idx);

			for (int i = 1; i < points.size(); i++) {
				Point point = points.get(i);
				root.insert(new Node(point, point.idx));
			}

			ArrayList<Integer> preOrderList = new ArrayList<>();
			preOrder(root, preOrderList);
			ArrayList<Integer> postOrderList = new ArrayList<>();
			postOrder(root, postOrderList);

			int[] array1 = preOrderList.stream().mapToInt(i -> i).toArray();
			int[] array2 = postOrderList.stream().mapToInt(i -> i).toArray();
			answer[0] = array1;
			answer[1] = array2;
			return answer;
		}

		private void preOrder(Node node, ArrayList<Integer> preOrderList) {
			if (node != null) {
				preOrderList.add(node.idx);
				preOrder(node.left, preOrderList);
				preOrder(node.right, preOrderList);
			}
		}

		private void postOrder(Node node, ArrayList<Integer> postOrderList) {
			if (node != null) {
				postOrder(node.left, postOrderList);
				postOrder(node.right, postOrderList);
				postOrderList.add(node.idx);
			}
		}

	}

}
