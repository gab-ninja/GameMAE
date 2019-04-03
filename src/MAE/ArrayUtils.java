package MAE;

public class ArrayUtils {	
	public boolean contains(int[] arr, int target) {
		for (int i=0; i < arr.length; i++) {
			if (arr[i] == target) {
				return true;
			}
		}
		return false;
	}
	
	public int numberOfOccurences(boolean[] arr, boolean target) {
		int sum = 0;
		for (int i=0; i < arr.length; i++) {
			if (arr[i] == target) {
				sum++;
			}
		}
		return sum;
	}
	
	public int[] findPositions(boolean[] arr, boolean target, int numberToFind) {
		int[] res = new int[numberToFind];
		int j=0;
		for (int i=0; i < arr.length; i++) {
			if (arr[i] == target && j < numberToFind) {
				res[j] = i;
				j++;
			}
		}
		return res;
	}
	
	public int[] randomNonRepetitive(int nElements, int elMax) {
		int[] arr = new int[nElements];
		for (int i=0; i<nElements; i++) {
			arr[i] = -1;
		}
		int randNum;
		for (int i=0; i<nElements; i++) {
			randNum = (int) Math.floor(Math.random() * elMax);
			if(!this.contains(arr, randNum)) {
				arr[i] = randNum;
			} else {
				i--;
			}
		}
		return arr;
	}

}
