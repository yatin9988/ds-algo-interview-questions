package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class AlphaCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String number = scn.next();
		System.out.println(recursive_approach(number));
		int[] arr = new int[number.length() + 1];
		Arrays.fill(arr, -1);
		System.out.println(dp1(number, arr));
//		System.out.println(dp2(number));
		scn.close();
	}

	public static int recursive_approach(String number) {

		// base case
		if (number.length() == 0)
			return 1;

		if (number.length() == 1 && Integer.parseInt(number) != 0)
			return 1;

		// beacuse there exists no code corrresponding to zero
		else if (number.length() == 1 && Integer.parseInt(number) == 0)
			return 0;

		int l1 = 0, l2 = 0;
		if (number.charAt(0) != '0')
			l1 = recursive_approach(number.substring(1));
		int num = Integer.parseInt(number.substring(0, 2));
		if (num >= 10 && num <= 26)
			l2 = recursive_approach(number.substring(2));

		return l1 + l2;
	}

	public static int dp1(String number, int[] map) {

		// base case
		if (number.length() == 0)
			return 1;

		if (number.length() == 1 && Integer.parseInt(number) != 0)
			return 1;

		// beacuse there exists no code corrresponding to zero
		else if (number.length() == 1 && Integer.parseInt(number) == 0)
			return 0;

		if (map[number.length()] != -1)
			return map[number.length()];

		int l1 = 0, l2 = 0;
		if (number.charAt(0) != '0')
			l1 = dp1(number.substring(1), map);
		int num = Integer.parseInt(number.substring(0, 2));
		if (num >= 10 && num <= 26)
			l2 = dp1(number.substring(2), map);

		int output = l1 + l2;
		map[number.length()] = output;
		return output;

	}

//	// iterative
//	public static int dp2(String number) {
//
//		int[] arr = new int[number.length() + 1];
//		arr[0] = 1;
//		
//	}

}
