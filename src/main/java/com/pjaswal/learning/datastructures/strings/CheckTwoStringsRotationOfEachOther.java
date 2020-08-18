package com.pjaswal.learning.datastructures.strings;

public class CheckTwoStringsRotationOfEachOther {
	public static void main(String[] args) {
		String actualString = "ABCD";
		String rotationString = "CDAB";
		int index = isRotationOfEachOther(actualString, rotationString);
		System.out.println(index);
	}
	
	/**
	 * Approach is to concatenate one of the string itself, if we do like actualString=actualString+actualString and search s2 into the concatenated string,if s2 is present
	 * then we say s2 is the rotation of actualString,because we have some characters matching at the end & then some rotated characters, then we bring by
	 * concatenating to actualString itself. So if it's a rotation, s2 must be present in actualString.
	 */
	private static int isRotationOfEachOther(String actualString,String rotationString) {
		String concatenatedString = actualString + actualString;
		return concatenatedString.indexOf(rotationString);
	}

}
