package com.magic;

import java.util.Scanner;
import java.util.logging.Logger;

import com.magic.exception.BusinessException;

public class Main {

	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String instervalList = scanner.nextLine();
		
		int[] range = new int[0];
		range = CalcMagicNumber.parseArray(instervalList, range);
		try {
			CalcMagicNumber.calcPrimeNumbers(range);
		} catch (BusinessException e) {
			LOGGER.severe(e.getMessage());
		}

	}

}
