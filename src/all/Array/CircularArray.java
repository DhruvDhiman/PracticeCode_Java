package all.Array;

import java.util.Arrays;

public class CircularArray {

	//Q1. Given a circular, sorted array find the index of given element if found, -1 otherwise
	
	/**
	 * This method return the index of the element in an array passed as a parameter
	 * @param array array in which element has to be found
	 * @param element element to be found
	 * @return index of the element if found, -1 otherwise
	 */
	public static int findIndex(int[] array, int element) {
		int index = -1;
		int startIndex = 0;
		int endIndex = array.length - 1;
		int mid = (startIndex + endIndex)/2;

		while(startIndex <= endIndex) {
			mid = (startIndex + endIndex)/2;
			if(array[mid] == element) {
				index = mid;
				break;
			}
			// means left array is sorted and element in between that
			else if(array[startIndex] <= array[mid] ) {
				if( element >= array[startIndex] && element < array[mid])
					endIndex = mid - 1;
				else
					startIndex = mid + 1;
			}
			//right array is sorted and element is in between that
			else if(array[mid] <= array[endIndex]) {
				if( element > array[mid] && element <= array[endIndex])
					startIndex = mid + 1;
				else
					endIndex = mid - 1;
			}
		}
		return index;
	}
	
	/**
	 * This method finds the number of rotations in an array
	 * @param array circular sorted array
	 * @return number of rotations in given array.
	 */
	public static int getNumberOfRotation(int[] array) {
		int numberOfRotation = 0;
		if( array.length != 0) {
			// mistake is in here creating, it is not a primitive type array, hence reference would be copied
			// both array and arrayCopy are referencing to the same mem location
			//int[] arrayCopy = array;
			int[] arrayCopy = new int[array.length];
			for (int i = 0; i < array.length; i++) {
				arrayCopy[i] = array[i];
			}
			Arrays.sort(arrayCopy);
			int smallestElement = arrayCopy[0];
			
			//find the index of smallest element in original array
			int mid;
			int start = 0;
			int end = array.length - 1;
			
			while(start <= end) {
				mid = (start + end)/2;
				if(array[mid] == smallestElement) {
					numberOfRotation = mid;
					break;
				}
				else if(array[start] <= array[mid]) {
					if(smallestElement >= array[start] && smallestElement < array[mid]) {
						end = mid - 1;
					}
					else
						start = mid + 1;
				}
				else if(array[end] >= array[mid]) {
					if(smallestElement > array[mid] && smallestElement <= array[end]) {
						start = mid + 1;
					}
					else
						end = mid - 1;
				}
			}
		}
		return numberOfRotation;
	}
	
	public static void main(String[] args) {
		int[] circularSortedArray = new int[] {1,2,3,4,5,6,7,8,0};
		int elementToFind = 0;
		int index = findIndex(circularSortedArray, elementToFind);
		if(index != -1)
			System.out.println("Index for element "+elementToFind +" is :"+ index);
		else
			System.out.println("Element not present in circular sorted array.");
		
		System.out.println("Number of rotations:"+ getNumberOfRotation(circularSortedArray));
	}
}
