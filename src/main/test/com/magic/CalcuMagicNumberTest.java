package com.magic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.magic.exception.BusinessException;

public class CalcuMagicNumberTest {

	@Test(expected=BusinessException.class)
	public void aMaioQueB() throws BusinessException {
		String input = "[76,3]";
		int[] range = new int[0];
		range = CalcMagicNumber.parseArray(input, range);
		CalcMagicNumber.calcPrimeNumbers(range);
	}
	
	@Test
	public void aMaioQueBMensagem() {
		String input = "[76,3]";
		int[] range = new int[0];
		range = CalcMagicNumber.parseArray(input, range);
		try {
			CalcMagicNumber.calcPrimeNumbers(range);
		} catch (BusinessException e) {
			assertEquals("Número inicial maior que número final!", e.getMessage());
		}
	}
	
	@Test
	public void apenasUmNumeroMensagem() {
		String input = "[7]";
		int[] range = new int[0];
		range = CalcMagicNumber.parseArray(input, range);
		try {
			CalcMagicNumber.calcPrimeNumbers(range);
		} catch (BusinessException e) {
			assertEquals("A lista não contem dois números!", e.getMessage());
		}
	}
	
	@Test
	public void tresNumerosPrimos() {
		String input = "[[8,27], [49,49]]";
		int[] range = new int[0];
		range = CalcMagicNumber.parseArray(input, range);
		try {
			assertEquals(3, CalcMagicNumber.calcPrimeNumbers(range));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void seisNumerosPrimos() {
		String input = "[[8,27], [49,49], [5,25], [9,9]]";
		int[] range = new int[0];
		range = CalcMagicNumber.parseArray(input, range);
		try {
			assertEquals(6, CalcMagicNumber.calcPrimeNumbers(range));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}
}
