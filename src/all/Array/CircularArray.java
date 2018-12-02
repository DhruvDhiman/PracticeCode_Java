package all.Array;

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
			else if(array[startIndex] < array[mid] ) {
				if( element >= array[startIndex] && element < array[mid])
					endIndex = mid - 1;
				else
					startIndex = mid + 1;
			}
			//right array is sorted and element is in between that
			else if(array[mid] < array[endIndex]) {
				if( element > array[mid] && element <= array[endIndex])
					startIndex = mid + 1;
				else
					endIndex = mid - 1;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] circularSortedArray = new int[] {8, 1, 2, 3, 4,5 ,6 ,7 };
		int elementToFind = 2;
		int index = findIndex(circularSortedArray, elementToFind);
		if(index != -1)
			System.out.println("Index for element "+elementToFind +" is :"+ index);
		else
			System.out.println("Element not present in circular sorted array.");
	}
}
