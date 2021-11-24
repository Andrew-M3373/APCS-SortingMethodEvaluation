import java.util.*;
import java.time.*;

public class BubbleSort {
	
	public static void sort(int[] s) {
		
		
		for (int i = 0; i < s.length - 1; i++) {
			for (int j = 0; j < s.length - i - 1; j++) {
				if (s[j] > s[j+1]) {
					// Swap s[j+1] and s[j]
					int temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
	}

}
