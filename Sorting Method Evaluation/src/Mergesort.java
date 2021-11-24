import java.util.*;
import java.time.*;

public class Mergesort {
	
	public static void sort(int[] s) {
		
		//// Sorting algorithm: https://docs.google.com/document/d/1pDK-Mvet6xD2I1Uv92LaGFqJivMtb8ddoyUfAiPdQJk/edit
		
		
		// Break the list of n length into n sublists, each a sorted sublist of size 1.
		// Recursively merge adjacent pairs of lists
		// Continue until the entire array is sorted
		// Stores sorted array in new temp array -- must return this when returning sorted array
		int[] temp = new int[s.length];
		mergeSortHelper(s,0,s.length-1,temp);
		
		
	}
	
	private static void mergeSortHelper(int[] s, int from, int to, int[] temp) { 
		if (from < to) {
			int middle = (from + to) / 2;
			mergeSortHelper(s, from, middle, temp);
			mergeSortHelper(s, middle + 1, to, temp);
			merge(s, from, middle, to, temp);
		}
	}

	private static void merge(int[] s, int from, int mid, int to, int[] temp)
	{
		int i = from;
		int j = mid + 1;
		int k = from;
		while (i <= mid && j <= to) {
			if (s[i] < s[j]) {
				temp[k] = s[i];
				i++;
			}
			else {
				temp[k] = s[j];
				j++;
			}
			k++;
		}
		
		while (i <= mid) {
			temp[k] = s[i];
			i++;
			k++;
		}
		
		while (j <= to) {
			temp[k] = s[j];
			j++;
			k++;
		}
		
		for (k = from; k <= to; k++) {
			s[k] = temp[k];
		}
	}

}
