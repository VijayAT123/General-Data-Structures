
public class SearchingAlgorithms {
	
	public static boolean linearSearchIterative(int[] a, int value) {
		for(int i =0 ; i<a.length; i++) 
			if(a[i] == value)
				return true;
		return false;
	}
	
	public static boolean linearSearchRecursive(int[] a, int value, int index) {
		if(a[index] == value)
			return true;
		else if(index>=a.length)
			return false;
		return linearSearchRecursive(a, value, index+1);
	}
	
	public static boolean binarySearchRecursive(int[] a, int value, int minIndex, int maxIndex) { //iterative not easy
		int midIndex = (maxIndex + minIndex)/2;
		if(minIndex>maxIndex)
			return false;
		else if(a[midIndex] == value)
			return true;
		else {
			if(value>a[midIndex]) //upper half
				return binarySearchRecursive(a, value, midIndex+1, maxIndex);
			else //lower half
				return binarySearchRecursive(a, value, minIndex, midIndex-1);
		}	
	}
}
