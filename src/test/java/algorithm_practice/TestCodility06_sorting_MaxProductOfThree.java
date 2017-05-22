package algorithm_practice;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestCodility06_sorting_MaxProductOfThree {

	@Test
	public void test() {
		int[] A = new int[]{3,2,1,5,6};
		
		Solution solution = new Solution();
		System.out.println( solution.solution(A) );
		
	}
	
	/**
	 * 배열을 정렬하면, 
	 * 제일 큰 숫자가 우측에 위치함.
	 * A[0] 에는 제일 작은 숫자 혹은 제일 큰 마이너스가 위치함.
	 * 
	 * 숫자 3개를 곱하므로,  
	 * 
	 * A[0] * A[1] * A[N-1] 
	 * 또는
	 * 
	 * A[N-3] * A[N-2] * A[N-1]  
	 * 두가지 경우가 가장 큰 수임. 
	 * 
	 * 
	 * @author smlee
	 *
	 */
	class Solution {
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        Arrays.sort(A);
	        
	        int len = A.length;
	        
	        int last1 = A[len-1];
	        int last2 = A[len-2];
	        int last3 = A[len-3];
	        
	        int first0 = A[0];
	        int first1 = A[1];
	        
	        
	        int max = 0;
	        
	        max = last1 * last2 * last3;
	        
	        max = Math.max( first0 * first1 * last1 , max );
	        
	        return max;
	    }
	}
}
