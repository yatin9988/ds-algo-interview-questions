package String_Algorithms;

import java.util.Scanner;

public class Naive_approach_pattern_matching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String string = scn.next();
		String pattern = scn.next();
		System.out.println(naive(string, pattern));
	}

	// O(n*m)
	// naive approach
	public static boolean naive(String string, String pattern) {

		int n = string.length();
		int m = pattern.length();
		for (int i = 0; i <= n - m; i++) {
			boolean isMatch = true;
			for (int j = 0; j < m; j++) {
				if (string.charAt(i + j) != pattern.charAt(j)) {
					isMatch = false;
					break;
				}
			}
			if (isMatch)
				return true;
		}
		return false;
	}

}
