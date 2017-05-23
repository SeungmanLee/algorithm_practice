package algorithm_practice;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

public class TestCodility07_Brackets {

    @Test
    public void test() {

        Solution solution = new Solution();
        assertEquals( 1 , solution.solution("{()()}") );
        assertEquals( 1 , solution.solution("{(())({})}") );
        assertEquals( 1 , solution.solution("{()({})}") );
        assertEquals( 0 , solution.solution("{]()({})}") );
        assertEquals( 0 , solution.solution("]]]]))]()({})}") );
    }

    class Solution {
        public int solution(String S) {
            // write your code in Java SE 8

            int len = S.length();

            Stack<String> s = new Stack<String>();

            HashMap<String, String> map = new HashMap<String, String>();

            map.put("{", "}");
            map.put("[", "]");
            map.put("(", ")");

            char[] charArray = S.toCharArray();

            for (int i = 0; i < len; i++) {

                char c = charArray[i];

                if ('{' == c || '[' == c || '(' == c) {
                    s.push(String.valueOf(c));
                } else if ('}' == c || ')' == c || ']' == c ) {
                    // stack 이 비어있는데, 빼내야하는 상황이면 에러
                    if( s.isEmpty() ) {
                        return 0;
                    }
                    
                    String popped = s.pop();
                    
                    String expected = map.get(popped);
                    if( null == expected ) {
                        return 0;
                    }
                    
                    // 입력값과 기대값이 다르면 에러
                    if( ! checkResultValid(expected, String.valueOf( c  ))){
                        return 0;
                    }
                }
            }
            
            // stack 에 무언가 남아있으면 안됨. 
            if( 0 != s.size() ) {
                return 0;
            }
            
            return 1;
        }
        
        private boolean checkResultValid( String expected, String input ) {
            return expected.equals( String.valueOf( input ));
        }
        
    }

}
