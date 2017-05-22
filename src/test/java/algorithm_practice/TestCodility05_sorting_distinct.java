package algorithm_practice;

import java.util.HashSet;

import org.junit.Test;

public class TestCodility05_sorting_distinct {

	@Test
	public void test() {
		Solution solution = new Solution();
		int size = solution.solution(new int[]{2,1,1,2,3,1});
		assert size == 3;
	}

	class Solution {
		public int solution(int[] A) {
			// write your code in Java SE 8
			HashSet<Integer> hashSet = new HashSet<Integer>();

			for (int val : A) {
				hashSet.add(val);
			}

			int size = hashSet.size();
			return size;
		}
	}

}
