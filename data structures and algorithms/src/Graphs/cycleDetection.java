package Graphs;

import java.util.Scanner;

public class cycleDetection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(compress(str));
	}

	public static String compress(String str) {
		if (str == null) {
			return null;
		}
		if (str.length() == 0) {
			return "";
		}
		String output = str.charAt(0) + "";
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == str.charAt(i - 1)) {
				count++;
				if (i == str.length() - 1) {
					output += count;
				}
			} else {
				if (count > 1) {
					output += count + "" + str.charAt(i);

				} else {
					output += str.charAt(i);
				}
				count = 1;
			}
		}

//		a5s4d4f2a3g3s2f3gzx
		return output;
	}

}
