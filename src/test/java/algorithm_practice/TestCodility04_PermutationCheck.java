package algorithm_practice;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class TestCodility04_PermutationCheck {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals( 0 , solution.solution(new int[]{1,4,1}));
        
        assertEquals( 1 , solution.solution(new int[]{1,2,4,3}));
        
                
    }
    
    class Solution {
        public int solution(int[] A) {
            // write your code in Java SE 8
            long sum = 0;
            long sumI = 0;
            int length = A.length;
            
            HashSet<Integer> set = new HashSet<Integer>();
            
            for( int i = 0 ; i < length ;  ) {
                int a = A[i];
                if( 0 >= a ) {
                    return 0;
                }
                
                if( set.contains( Integer.valueOf(a) )) {
                    return 0;
                } else {
                    set.add( Integer.valueOf(a));
                }
                
                sum += a;
                
                i++;
                sumI += i;
            }
            
//            System.out.println( "sum=" + sum );
//            System.out.println( "sumI=" + sumI );
            if( sum == sumI ) {
                return 1;
            } else { 
                return 0;
            }
        }
    }

}
