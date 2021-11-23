import java.util.*;

public class Quicksort {
	
	public static double sort(int[] s) {
		
		//// Sorting algorithm: https://docs.google.com/document/d/1cV4hO8acY3Kw7muQd_PIsWnxjEk1HAAi0SVwF1NTrtg/edit
		
		// create left and right markers with the pivot between them
		// move the left marker until a value greater than the pivot is found
		// move the right marker until a value smaller than the pivot is found
		// when the markers intersect swap the old pivot with the new intersection pivot

		qs(s, 0, s.length - 1);

		
		return 1;
	}
	
	private static void qs(int[] s, int left, int right) {
		int i, j;
        int pivot, temp;
        i = left;
        j = right;
        pivot = s [(left + right) / 2];
        
        do
            {
            while ((s [i] < pivot) && (i < right))
                i++;
                    
            while ((pivot < s [j]) && (j > left))
                j--;
                
            if (i <= j)
                {
                temp = s [i];
                s [i] = s [j];
                s [j] = temp;
                i++;
                j--;
                }
            }
        while (i <= j);
        if (left < j)
            qs (s, left, j);
        
        if (i < right)
            qs (s, i, right);
	}

}
