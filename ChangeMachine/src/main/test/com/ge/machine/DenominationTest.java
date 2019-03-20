package com.test.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;


public class DenominationTest {

	Denomination denomination = null;
	
	@Before
	public void iniitateDenomination(){
		denomination = new Denomination(1, "Penny", 100);
	}
	
	
	@Test
	public void testDecreaseCount(){
			
		denomination.decreaseCount(10);
		
		assertEquals(90,  denomination.getCount());
		
		assertNotEquals(100, denomination.getCount());
	}
	
	
	@Test
	public void testDecreaseCountNegative(){
		
		denomination.decreaseCount(10);
		
		assertNotEquals(100, denomination.getCount());
	}
	
	
	@Test(expected = ArithmeticException.class)
	public void testDecreaseCountException(){
		denomination.decreaseCount(110);
	}
	
}
