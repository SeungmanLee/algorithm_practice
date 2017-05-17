package algorithm_practice;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class Testcodility04_PermMissingElem {

	@Test
	public void test() {
		Solution solution = new Solution();
		int ret = solution.solution(new int[]{2,3,1,5});
		System.out.println(ret);
	}

	class Solution {
		public int solution(int[] A) {

			int len = A.length;
			
			int[] checkArr = new int[len + 1];
			
			for (int val : A) {
				checkArr[val - 1] = 1;
			}

			int pos = 0;
			for (int val : checkArr) {
				if (0 == val) {
					return pos + 1;
				}
				pos++;
			}
			return pos;
		}
	}
}
