package algorithm_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class Test_Graph {

	@Test
	public void test() throws IOException {
		/**
		 * 
		 * 4
		 * 0111
		 * 1000
		 * 1000
		 * 0010
		 * 3
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        int nodeCount = Integer.parseInt(input);
        
        boolean[][] graph = new boolean[nodeCount][nodeCount];
      
        for( int i = 0 ; i < nodeCount ; i++ ) {
          String line = br.readLine();
          
          for( int j = 0 ; j < nodeCount ; j++ ) {
            String val = String.valueOf( line.charAt(j) );
            if( "1".equals(val) ) {
              graph[i][j] = true;
            }else {
              graph[i][j] = false;
            }
          }
        }
        
        String lengthM = br.readLine();
        int m = Integer.parseInt(lengthM);
      
      
        System.out.println(findCycle( graph, m ));
	}

	public static int findCycle(boolean[][] graph, int m) {
		// assume graph is NxN adjacency matrix
		// TODO : Implement
		int foundCount = 0;

		int size = graph.length;

		int i = 0;
		int j = 0;
		int currentPosJ = 0;	// 첫번째 j 열의 진행 index 를 별도 관리해야 한다.......이게 포인트네..
		while (true) {

			boolean bFoundRowJ = false;

			for (; j < size; j++) {
				if (graph[i][j]) {
					foundCount++;
//					System.out.println("found i=" + i + ",j=" + j + ",foundCount=" + foundCount);
					bFoundRowJ = true;
					break;
				}
			}

			if (bFoundRowJ) {
				if (0 == j) {
//					System.out.println("0 == j.  j=" + j);
					if (foundCount == m) {
						return 1;
					} else {
						// graph returns to position 0 but not match count m.
						// try another.
						i = 0; // reset i;
						currentPosJ++; // increse position j to start next.
						j = currentPosJ;
						foundCount = 0; // reset foundCount;
//						System.out.println("reset i=0, j=" + j + ",foundCount=0");
						continue;
					}
				} else {
//					System.out.println("i = j.    i=" + i + ", j=" + j);
					i = j; // if found columnJ then find rowJ
					j = 0;
				}

			} else {
				// not found true in rowJ
//				System.out.println("not found true in rowJ   i=" + i + ", j=" + j);
				i = 0;
				j++;

				if (j < size) {
					return 0;
				}

			}

			if( size < currentPosJ ) {
				return 0;
			}
			
			if (m < foundCount) {
				// cycle size is longer then m;
				return 0;
			}
		}
	}

}
