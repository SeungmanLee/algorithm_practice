package algorithm_practice;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCodility01_binaryGap {

	@Test
	public void test() {
		
		
		int N = 1053;
		System.out.println( "N=" + N + ", N >> 1 = " + (N >> 1) );
		
		Solution solution = new Solution();
		System.out.println( solution.solution(1041) );
		
	}


	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Solution {
	    public int solution(int N) {
	        // write your code in Java SE 8
	        int val = N;
	        final byte ONE = 0x01;
	        
	        int startPos = 0;
	        int endPos = 0;
	        
	        int maxResultValue = 0;
	        boolean bInZero = false;
	        boolean bFindFirstOne = false;
	        for( int i = 32 ; i >= 0 ; i-- ) { 

	            val = (val << 1);
	            int newVal = val & 0x10000000;
	            
	            boolean isOne = (newVal == 0x10000000);	            
	                        
	            System.out.println( i + " : " + bFindFirstOne + ", " + bInZero + ", " + startPos + "~" + endPos + ", " + isOne + " ,    " + maxResultValue);
	            
	            if( isOne ) {
	                
	                if( ! bFindFirstOne ) {
	                    bFindFirstOne = true;
	                }
	                
	                if( bInZero ) {
	                    bInZero = false;    
	                    int size = endPos - startPos + 1;
	                    maxResultValue = Math.max( size , maxResultValue );  
	                }
	                
	            } else {
	                
	                if( ! bFindFirstOne ) {
	                    continue;
	                }
	                
	                if( bInZero ) {
	                    endPos += 1;
	                } else {
	                    bInZero = true;
	                    startPos = i;
	                    endPos = i;
	                }
	            }
	        }
	        return maxResultValue;
	        
	    }
	}
	
	
}
