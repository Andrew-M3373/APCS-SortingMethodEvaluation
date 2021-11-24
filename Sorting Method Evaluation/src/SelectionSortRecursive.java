import java.util.*;
import java.time.*;

public class SelectionSortRecursive {
	
	public static void sort(int[] s) {
		
		selectionSort(s,0,s.length);
	}
	
	public static void selectionSort(int[] s, int i, int maxIndex) {
		int minIndex = i;
		for (int k = i+1; k < s.length; k++) {
			if (s[k] < s[minIndex]) {
				minIndex = k;
			}
		}
		
		// Swaps the smallest element with the index
		int temp = s[i];
		s[i] = s[minIndex];
		s[minIndex] = temp;
		
		if (i + 1 < maxIndex) {
            selectionSort(s, i + 1, maxIndex);
		}
	}

}
