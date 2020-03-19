package Array;

public class optimimised_list_sum {

	int[] arr;

	public optimimised_list_sum(int[] arr) {
		this.arr = arr;
	}

	public int sum(int si, int ei) {

		int sum = 0;
		for (int i = si; i < ei; i++) {
			sum += this.arr[i];
		}
		return sum;
	}

}
