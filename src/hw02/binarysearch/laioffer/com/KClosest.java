package hw02.binarysearch.laioffer.com;

public class KClosest {
	public int[] kClosest(int[] input, int target, int k) {
		if (input == null || input.length == 0) {
			return input;
		}
		if (k == 0) {
			return new int[0];
		}
		int start = largestSmallerEqual(input, target);
		int end = start + 1;
		int[] res = new int[k];

		for (int i = 0; i < k; i++) {
			if (end >= input.length || start >= 0 && target - input[start] <= input[end] - target) {
				res[i] = input[start--];
			} else {
				res[i] = input[end++];
			}
		}

		return res;
	}

	private int largestSmallerEqual(int[] input, int target) {
		int start = 0;
		int end = input.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (input[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (input[end] <= target) {
			return end;
		}

		if (input[start] <= target) {
			return start;
		}

		return -1;
	}
}