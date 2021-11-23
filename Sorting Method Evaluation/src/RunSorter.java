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
		
		// Run sorting
		System.out.println("Sorting...\n\n");
		double quicksort = Quicksort.sort(iterations,size);
		double selectionSortIterative = SelectionSortIterative.sort(iterations,size);
		double selectionSortRecursive = SelectionSortRecursive.sort(iterations,size);
		double mergesort = Mergesort.sort(iterations,size);
		double insertionSort = InsertionSort.sort(iterations,size);
		double bubbleSort = BubbleSort.sort(iterations,size);
		
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
		
		DecimalFormat d = new DecimalFormat("0.0000");
		System.out.printf("%-26s %6f seconds%n","Quicksort",q);
		System.out.printf("%-26s %6f seconds%n","Selection sort - iterative",si);
		System.out.printf("%-26s %6f seconds%n","Selection sort - recursive",sr);
		System.out.printf("%-26s %6f seconds%n","Mergesort",m);
		System.out.printf("%-26s %6f seconds%n","Insertion sort",i);
		System.out.printf("%-26s %6f seconds%n","Bubble sort",b);
	}
	
	public static int[] fillArray(int s) {
		int[] array = new int[s];
		
		for (int i = 0; i < s; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		
		return array;
	}
}
