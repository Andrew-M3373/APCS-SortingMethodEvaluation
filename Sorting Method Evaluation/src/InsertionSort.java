
public class InsertionSort {
	
	public static void sort(int[] s) {
		
		//// Sorting algorithm: https://docs.google.com/document/d/10Z-rjExa9nheKyX93kImcy-4DKzGyvIhbW0m2-vqW5g/edit
		
		// Takes first index as pre-sorted array, and inserts each next number into the proper spot one-by-one
		for (int i = 1; i < s.length; i++) {
				int temp = s[i];
				int possibleIndex = i;
				while (possibleIndex > 0 && temp < s[possibleIndex - 1]) {
					s[possibleIndex] = s[possibleIndex - 1];
					possibleIndex--;
				}
				s[possibleIndex] = temp;
		}
	}

}
