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
		
		// Run sorting iterations number of times
		System.out.println("\nSorting...\n\n");
		double quicksort = 0.,
				selectionSortIterative = 0.,
				selectionSortRecursive = 0.,
				mergesort = 0.,
				insertionSort = 0.,
				bubbleSort = 0.;
		for (int i = 0; i < iterations; i ++) {
			int[] array = fillArray(size);
			quicksort += Quicksort.sort(array);
			selectionSortIterative += SelectionSortIterative.sort(array);
			selectionSortRecursive += SelectionSortRecursive.sort(array);
			mergesort += Mergesort.sort(array);
			insertionSort += InsertionSort.sort(array);
			bubbleSort += BubbleSort.sort(array);
		}
		
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
		} while (entering);
		
		return Integer.parseInt(string);
	}

	public static void displayResults(double q, double si, double sr, double m, double i, double b, int iterations, int size) {
		
		System.out.println("Number of simulations: " + iterations);
		System.out.println("Array size: " + size + "\n");
		
		DecimalFormat d = new DecimalFormat("00.0000");
		System.out.printf("%-26s %8s seconds%n","Quicksort",d.format(q));
		System.out.printf("%-26s %8s seconds%n","Selection sort - iterative",d.format(si));
		System.out.printf("%-26s %8s seconds%n","Selection sort - recursive",d.format(sr));
		System.out.printf("%-26s %8s seconds%n","Mergesort",d.format(m));
		System.out.printf("%-26s %8s seconds%n","Insertion sort",d.format(i));
		System.out.printf("%-26s %8s seconds%n","Bubble sort",d.format(b));
	}
	
	public static int[] fillArray(int s) {
		int[] array = new int[s];
		
		for (int i = 0; i < s; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		
		return array;
	}
}
