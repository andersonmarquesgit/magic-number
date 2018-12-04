package com.magic;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.magic.exception.BusinessException;

/**
 * @author Anderson Marques
 *
 * Números Mágicos
 * 
 * Um número X é dito “mágico” quando a raiz quadrada de X existe e é um número primo.
 * Escreva um programa que receba como entrada uma lista de intervalos [A,B] e retorne o
 * somatório da quantidade de números mágicos encontrados em cada intervalo. É garantido
 * que os números A e B serão inteiros positivos e que A será sempre menor ou igual que B
 * Para a entrada: [[8,27], [49,49]]
 * Resultado: 3
 * Seriam os números 9 e 25 do primeiro intervalo e 49 do segundo
 */
public class CalcMagicNumber {

	public static int[] parseArray(String arrayDeArray, int[] range) {
		String regex = "([\\w])+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(arrayDeArray);
		while (m.find()) {
			range = addElement(range, Integer.parseInt(m.group()));
		}
		return range;
	}

	public static int calcPrimeNumbers(int[] range) throws BusinessException {
		int max = 0;
		int qttMagicNumber = 0;
		int ini = 0;
		
		if(range.length <= 1) {
			throw new BusinessException("A lista não contem dois números!");
		}
		
		while(ini < range.length) {
			int start = range[ini];
			int finish = range[max+1];
			
			if(start > finish) {
				throw new BusinessException("Número inicial maior que número final!");
			}
			
			while (start <= finish) {
				if(isPrime(Math.sqrt(start))) {
					qttMagicNumber++;
				}
				start++;
			}
			ini = max+2;
			max = ini;
		}
		
		System.out.println("Quantidade de números mágicos: " + qttMagicNumber);
		return qttMagicNumber;
	}
	
	public static boolean isPrime(double raiz) {
		int numDivisores = 0;
		
        for (int i = 1; i <= raiz; i++) {
        	if(raiz % i == 0) {
        		numDivisores++;
        	}
		}
        
        if(numDivisores == 2) {
        	return true;
        }
        
        return false;
	}
	
	public static int[] addElement(int[] a, int e) {
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = e;
	    return a;
	}
}
