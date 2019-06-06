package coding_solutions;

import java.util.*;

public class Arrays_and_Strings {
	/*
	 * Function to check whether a string's chars are all unique.
	 * Returns a boolean, True if the string contains all unique chars.
	 * False otherwise. Assumes an ASCII alphabet of 128 unique chars.
	 * Input:  (String)
	 * Output: Boolean
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 */
	public static boolean isUniqueChars(String s) {
		if(s.length()>128) {
			System.out.println("String is too big, can't be unique.");
			return false;
		}
		// an array of booleans one for each char in ASCII 
		boolean chars[] = new boolean[128];
		for(int i=0; i<s.length(); i++) {
			// value now represents the integer ASCII value of s[i]
			// we can use this as an index to the boolean array
			int value = s.charAt(i);
			if(chars[value]) {
				System.out.println("Not Unique");
				return false;
			}
			// We store true at the index of value 
			// in order to remember which chars we have seen
			chars[value] = true;
		}
		System.out.println("Unique");
		return true;
	}
	
	/*
	 * Function to check whether one string is a permutation of another.
	 * Returns a boolean, True if there is a permutation.
	 * False otherwise. Assumes an ASCII alphabet of 128 unique chars.
	 * Input:  (String, String)
	 * Output: Boolean
	 * Time Complexity: O(n+n) or O(n)
	 * Space Complexity: O(1)
	 */
	public static boolean permutation(String s1, String s2) {
		// if the lengths are != then there is no permutation
		if(s1.length()!=s2.length()) {
			System.out.println("Strings are != in length and thus, not a permutation");
			return false;
		}
		// array of integers to keep track of how many times a char appears
		int[] characters = new int[128];
		// increment the element of the array at the index of the char in the string
		for(int i=0;i<s1.length();i++) {
			characters[s1.charAt(i)]++;
		}
		// decrement the element in the characters array for each char in the second string 
		for(int i=0;i<s2.length();i++) {
			characters[s2.charAt(i)]--;
			// if any element in the array is ever negative there cannot be a permutation
			if(characters[s2.charAt(i)]<0) {
				System.out.println("Not a permutation");
				return false;
			}
		}
		System.out.println(s2+" is a permutation of "+s1);
		return true;
	}
	/*
	 * Function to replace all the spaces in a character array with "%20".
	 * Takes in the character array and the "true" length of the string
	 * Input:  (char[], int )
	 * Output: Boolean
	 * Time Complexity: O(n+n) or O(n)
	 * Space Complexity: O(1)
	 */
	public static void URLify(char[] string, int len) {
		int spaceCount = 0, index = 0;
		// count the number of spaces
		for(int i=0; i<len;i++) {
			if(string[i]==' ') {
				spaceCount++;
			}
		}
		index = len+spaceCount*2;
		if(len< string.length) {
			string[len]='\0';
		}
		for(int i=len-1;i>=0;i--) {
			if(string[i]==' ') {
				string[index-1]= '0';
				string[index-2]= '2';
				string[index-3]= '%';
				index=index-3;
			}else {
				string[index-1] = string[i];
				index--;
			}
		}
		System.out.println("URLified:\n"+Arrays.toString(string));
	}
}







