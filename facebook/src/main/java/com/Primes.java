package com;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Primes {

	public static void main(String[] args) throws Exception {
		Primes p=new Primes();
		System.out.println(p.nextPrime(12));

	}
	
	public boolean isPrime(int num) {
		int limit=(int) (Math.sqrt(num)+1);
		return num==2|| num>1 && IntStream.range(2,limit)
				.noneMatch(divisor->num%divisor==0);
	}
	
	public int nextPrime(int num) throws Exception {
		OptionalInt op=IntStream.iterate(num+1,n->n+1)
				.filter(this::isPrime)
				.findFirst();
		return op.orElseThrow(Exception::new);
	}

}
