
public class SortingAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void bubbleSort(int[] a) {
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i = 0; i<a.length-1; i++) {
				if(a[i]>a[i+1]) {
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					hasSwapped = true;
				}
			}
		}
	}
	
	public static void mergeSort(int[] a) {
		int size = a.length;
		if(size<2)
			return;
		int midPoint = size/2;
		int leftSize = midPoint;
		int rightSize = size-midPoint;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
		for(int i = 0; i<midPoint; i++)
			left[i] = a[i];
		for(int i = midPoint; i<size; i++)
			right[i-midPoint] = a[i];
		mergeSort(left);
		mergeSort(right);
		merge(left, right, a);
	}
	
	public static void merge(int[] left, int[] right, int[] a) { //goes with merge sort
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0; //left index
		int j = 0; //right index
		int k = 0; //a index
		while(i<leftSize && j<rightSize) {
			if(left[i]<=right[j]) {
				a[k] = left[i];
				i++;
				k++;
			}
			else {
				a[k] = right[j];
				j++;
				k++;
			}
		}
		while(i<leftSize) {
			a[k] = left[i];
			i++;
			k++;
		}
		while(j<rightSize) {
			a[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void quickSort(int[] a, int leftIndex, int rightIndex)
	{
		int pIndex = partition(a,leftIndex,rightIndex);
		if(leftIndex < pIndex-1)
			quickSort(a,leftIndex,pIndex-1);
		if(rightIndex > pIndex)
			quickSort(a,pIndex,rightIndex);
	}
	public static int partition(int[] a, int leftIndex, int rightIndex)
	{
		int i = leftIndex; //starts on left side and goes right
		int j = rightIndex; //starts on right side and goes left
		int pivot = a[(leftIndex+rightIndex)/2]; //value, not index
		while(i<=j)
		{
			while(a[i] < pivot)
				i++;
			while(a[j] > pivot)
				j--;
			if(i <= j)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
	
	public static void selectionSort(int[] b) {
		for(int i = 0; i<b.length; i++) {
			int smallest  = i;
			for(int j = i+1; j<b.length; i++) {
				if(b[j]<b[smallest])
					smallest = j;
			}
			if(smallest!= i) {
				int temp = b[i];
				b[i] = b[smallest];
				b[smallest] = temp;
			}
		}
	}

}
