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
	
	public int[] randomNonRepetitive(int nElements, int elMax) {
		int[] arr = new int[nElements];
		for (int i=0; i<nElements; i++) {
			arr[i] = -1;
		}
		int randNum;
		for (int i=0; i<nElements; i++) {
			randNum = (int) Math.floor(Math.random() * Math.floor(elMax));
			if(!this.contains(arr, randNum)) {
				arr[i] = randNum;
			} else {
				i--;
			}
		}
		return arr;
	}

}
