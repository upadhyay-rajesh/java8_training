package com;

import static org.junit.Assert.*;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PrimeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		System.out.println("before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after class");
	}
	
	Primes p;

	@Before
	public void setUp() throws Exception {
		p=new Primes();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("after test");
	}

	@Test
	public void testIsPrime() {
		IntStream.of(2,3,5,7,11,13,17,19)
		.forEach(n->assertTrue(p.isPrime(n)));
		
		assertFalse(p.isPrime(4));
	}
	
	@Test
	public void testAbc() {
		assertTrue(Stream.of(2,3,11,5,7).allMatch(p::isPrime));
	}
	
	@Test
	public void testNextPrime() {
		
		try {
			
			int i=p.nextPrime(1);
			assert i==2 : "your input is wrong";
			
			assertEquals(2,p.nextPrime(1));
			assertEquals(7,p.nextPrime(5));
			assertEquals(13,p.nextPrime(11));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
