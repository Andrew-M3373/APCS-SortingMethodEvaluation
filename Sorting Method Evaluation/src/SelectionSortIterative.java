import java.util.*;

public class SelectionSortIterative {
	
	public static double sort(int[] s) {
		
		//// Sorting algorithm: https://docs.google.com/document/d/17e4HlaPXoe1FrtpTtWExY2Npg64YJFZKoW3K59fQru4/edit
		
		// Finds smallest int and swaps it with s[0], then the same thing with s[1]
		for (int j = 0; j < s.length - 1; j++) {
			int minIndex = j;
			for (int k = j+1; k < s.length; k++) {
				if (s[k] < s[minIndex]) {
					minIndex = k;
				}
			}
			
			// Swaps the smallest element with the index
			int temp = s[j];
			s[j] = s[minIndex];
			s[minIndex] = temp; 
		}

		
		return 2;
	}

}
