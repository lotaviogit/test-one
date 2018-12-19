import java.util.*;

class LCSDynamic {

	/**
	 * TODO: This is bad. No memoization once or ever....
	 */
	public static String getLCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return "";
		}
		// If both last items match, it can be part of a substring
		else if (s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)) {
			// return s1[s1.length()-1] + max()
			// TODO: Improve this. Computing on the result of a recursion is not so good
			// Substring method does not include the last char (end is not inclusive)
			// String res1 = getLCS(s1, s2.substring(0, s2.length()-1));
			// String res2 = getLCS(s1.substring(0, s1.length()-1), s1);
			return getLCS(s1.substring(0, s1.length()-1), s2.substring(0, s2.length()-1))
				+ s1.charAt(s1.length()-1);

			// if (res1.length() > res2.length())
				// return s1.charAt(s1.length()-1) + res1;
			// else
				// return s2.charAt(s2.length()-1) + res2;
		}
		// Move on to the next characters in both of them
		else {
			String res1 = getLCS(s1, s2.substring(0, s2.length()-1));
			String res2 = getLCS(s1.substring(0, s1.length()-1), s1);

			if (res1.length() > res2.length())
				return res1;
			else
				return res2;
		}
	}

	public static void main(String[] args) {
		String res = getLCS("ABCBDAB", "BDCABA");
		System.out.println(res);
	}
}