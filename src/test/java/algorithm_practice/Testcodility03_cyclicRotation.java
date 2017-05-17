package algorithm_practice;

import java.util.Arrays;

import org.junit.Test;

public class Testcodility03_cyclicRotation {

	@Test
	public void test() {
		Solution solution = new Solution();
		int[] input = { 3, 8, 9, 7, 6 };
		int[] ret = solution.solution(input, 3);
		System.out.println( Arrays.toString(ret) );
	}

	class Solution {
		public int[] solution(int[] A, int K) {
			// write your code in Java SE 8
			if (null == A) {
				return null;
			}

			int len = A.length;
			if (len == K || 0 == len) {
				return A;
			}

			int shiftPosition = K % len;

			int[] retArr = new int[len];

			for (int i = 0; i < len; i++) {
				int val = A[i];
				int dstPos = ((i + shiftPosition) % len);

				retArr[dstPos] = val;
			}
			return retArr;
		}
	}

}
