package com.magic;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String instervalList = scanner.nextLine();
		
		int[] range = new int[0];
		range = CalcMagicNumber.parseArray(instervalList, range);
		CalcMagicNumber.calcPrimeNumbers(range);

	}

}
