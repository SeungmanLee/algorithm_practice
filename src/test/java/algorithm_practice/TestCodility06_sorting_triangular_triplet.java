package algorithm_practice;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.HashSet;

import org.junit.Test;

public class TestCodility06_sorting_triangular_triplet {

	@Test
	public void test() {
		Solution solution = new Solution();
		int ret1 = solution.solution(new int[]{10, 2, 5, 1, 8, 20});
		System.out.println(ret1);
		int ret2 = solution.solution(new int[]{10, 50, 5, 1});
		System.out.println(ret2);
		
		int ret3 = solution.solution(new int[]{1, 1, 1, 1, 5, 5, 5});
		System.out.println(ret3);
		
		int ret4 = solution.solution(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});
		System.out.println(ret4);
	}

	class Solution {
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        int p, q, r = 0;
	        int len = A.length;
	        
	        
	        for( p = 0 ; p < len - 2 ; p++ ) {
	        	int P = A[p];
            	if( P <= 0 ) continue;	// 값이 음수이면 더했을때 값이 작아짐.
	        	
	        	q = p+1;
	            
	            for( ; q < len - 1 ; q++ ) {
	            	
	            	int Q = A[q];
                	if( Q <= 0 ) continue;
                	
	                r = q+1;
	                for(  ; r  < len ; r++ ) {
	                	
	                	int R = A[r];
	                	if( R <= 0 ) continue;
	                	
	                	// 3개 값이 모두 동일하면 정삼각형
	                	if( P == Q ) { 
	                		if( Q == R ) {
	                			if( R == P ) {
	                				return 1;
	                			}
	                		}
	                	}
	                	
	                    if( (P + Q ) > R ) {
	                    	if( (Q + R ) > P ) {
	                    		if( (R + P ) > Q ) {
	        	                    //    System.out.println( "found : " + p + "," + q + "," + q );
	    	                        return 1;	                    			
	                    		}
	                    	}
	                    }
	                }
	            }
	        }
	        
	        //System.out.println(" calcCount : " + calcCount);
	        return 0;
	    }
	}
	
}
