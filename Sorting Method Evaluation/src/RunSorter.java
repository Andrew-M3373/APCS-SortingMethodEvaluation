import java.io.*;
import java.util.*;
import java.text.*;

public class RunSorter {

	public static void main(String[] args) {		
		System.out.println("Welcome to the sorter method evaluation program!");
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of times to run the simulation.");
		int iterations = inputChecks(input);
		
		System.out.println("Enter the number of integers to be sorted.");
		int size = inputChecks(input);
				
		runSortingMethods(iterations,size);
	}
	
	public static void runSortingMethods(int iterations, int size) {
		// Run sorting iterations number of times
				System.out.println("\nSorting...\n\n");
				float quicksort = 0,
						selectionSortIterative = 0,
						selectionSortRecursive = 0,
						mergesort = 0,
						insertionSort = 0,
						bubbleSort = 0;
				
				// Test sorting Classes -- chance each .sort method to return an int[] in each class before running this
//				int[] s = fillArray(size);
//				System.out.println(Arrays.toString(s));
//				System.out.println(Arrays.toString(Quicksort.sort(s)));
//				System.out.println(Arrays.toString(SelectionSortIterative.sort(s)));
//				System.out.println(Arrays.toString(SelectionSortRecursive.sort(s)));
//				System.out.println(Arrays.toString(InsertionSort.sort(s)));
//				System.out.println(Arrays.toString(BubbleSort.sort(s)));
//				System.out.println(Arrays.toString(Mergesort.sort(s)));
				
				// Quicksort
				int[][] matrix = fillMatrix(iterations,size);
				float time1 = System.nanoTime();
				for (int[] a : matrix) {
					Quicksort.sort(a);
				}
				float time2 = System.nanoTime();
				quicksort = time2-time1;
				
				// Selection Sort Iterative
				matrix = fillMatrix(iterations,size);
				time1 = System.nanoTime();
				for (int[] a : matrix) {
					SelectionSortIterative.sort(a);
				}
				time2 = System.nanoTime();
				selectionSortIterative = time2-time1;
				
				// Selection Sort Recursive
				matrix = fillMatrix(iterations,size);
				time1 = System.nanoTime();
				for (int[] a : matrix) {
					SelectionSortRecursive.sort(a);
				}
				time2 = System.nanoTime();
				selectionSortRecursive = time2-time1;
				
				// Mergesort
				matrix = fillMatrix(iterations,size);
				time1 = System.nanoTime();
				for (int[] a : matrix) {
					Mergesort.sort(a);
				}
				time2 = System.nanoTime();
				mergesort = time2-time1;
				
				// Insertion sort
				matrix = fillMatrix(iterations,size);
				time1 = System.nanoTime();
				for (int[] a : matrix) {
					InsertionSort.sort(a);
				}
				time2 = System.nanoTime();
				insertionSort = time2-time1;
				
				// Bubble sort
				matrix = fillMatrix(iterations,size);
				time1 = System.nanoTime();
				for (int[] a : matrix) {
					BubbleSort.sort(a);
				}
				time2 = System.nanoTime();
				bubbleSort = time2-time1;
				
				
				
				displayResults(quicksort,selectionSortIterative,selectionSortRecursive,mergesort,insertionSort,bubbleSort,iterations,size);
	}
	
	public static int inputChecks(Scanner sc) {
		boolean entering = true;
		String string = "";
		do {
			string = sc.nextLine().toLowerCase().strip();
			for (int i = 0; i < string.length(); i++) {
				if (string.contains(".")) entering = true;
				else if (string.charAt(i) > 47 && string.charAt(i) < 58) {
					entering = false;
				}
			}
			if (entering) {
				System.out.println("Please enter a valid integer.");
			}
			else if (!entering && Float.parseFloat(string) > 2147483647) {
				entering = true;
				System.out.println("Please enter a valid integer.");
			}
		} while (entering);
		
		return Integer.parseInt(string);
	}

	public static int[][] fillMatrix(int i, int s) {
		int[][] matrix = new int[i][s];
		for (int j = 0; j < i; j ++) {
			matrix[j] = fillArray(s);
		}
		
		return matrix;
	}
	
	public static void displayResults(float q, float si, float sr, float m, float i, float b, int iterations, int size) {
		
		System.out.println("Number of simulations: " + iterations);
		System.out.println("Array size: " + size + "\n");
		
		DecimalFormat d = new DecimalFormat("0.0000000");
		System.out.printf("%-26s %9s seconds%n","Quicksort",d.format(q/1000000000/iterations));
		System.out.printf("%-26s %9s seconds%n","Selection sort (iterative)",d.format(si/1000000000/iterations));
		System.out.printf("%-26s %9s seconds%n","Selection sort (recursive)",d.format(sr/1000000000/iterations));
		System.out.printf("%-26s %9s seconds%n","Mergesort",d.format(m/1000000000/iterations));
		System.out.printf("%-26s %9s seconds%n","Insertion sort",d.format(i/1000000000/iterations));
		System.out.printf("%-26s %9s seconds%n","Bubble sort",d.format(b/1000000000/iterations));
		
	}
	
	public static int[] fillArray(int s) {
		int[] array = new int[s];
		
		for (int i = 0; i < s; i++) {
			array[i] = (int) (Math.random() * 90 + 10);
		}
		
		return array;
	}
}
