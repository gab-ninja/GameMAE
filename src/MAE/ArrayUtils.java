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

}
