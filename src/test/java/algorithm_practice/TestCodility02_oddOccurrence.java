package algorithm_practice;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Test;

public class TestCodility02_oddOccurrence {

	@Test
	public void test() {
		Solution solution = new Solution();
		int ret = solution.solution(new int[]{ 10, 11, 10, 20, 20 });
		System.out.println( ret );
	}
	
	class Solution {
		
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        
	    	HashSet<Integer> hashSet = new HashSet<Integer>();
	    	
	        for( int val : A ) {
	        	Integer valueOfVal = Integer.valueOf(val);
	        	if( hashSet.contains( valueOfVal) ) {

	        		hashSet.remove(valueOfVal);
	        	}else {
	        		hashSet.add(valueOfVal);
	        	}
	        }
	        
	        Iterator<Integer> iterator = hashSet.iterator();
	        if( iterator.hasNext() ) {
	        	Integer val = iterator.next();
	        	return val;
	        }
	        
	        return 0;
	    }
	}
	

}
