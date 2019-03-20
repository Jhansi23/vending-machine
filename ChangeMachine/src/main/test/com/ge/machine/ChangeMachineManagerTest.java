package com.test.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ChangeMachineManagerTest {

	private ChangeMachine changeMachine;
	
	@Before
	public void initiateChangeMachine(){
		Denomination dime = new Denomination(10, "Dime", 10);
		Denomination quarter = new Denomination(25, "Quarter", 10);
		Denomination nickel = new Denomination(25, "Nickel", 10);
		Denomination penny = new Denomination(25, "Penny", 10);
		
		changeMachine = new ChangeMachine(dime, quarter, nickel, penny);
		
	}
	
	@Test
	public void testCheckIfEnoughChangeAvailable(){
		
		
		BigDecimal change1 = new BigDecimal("2");
		
		assertTrue(ChangeMachineManager.checkIfEnoughChangeAvailable(changeMachine, change1));
		
	
	}
	
	@Test
	public void testCheckIfEnoughChangeAvailableNegative(){
		
		BigDecimal change2 = new BigDecimal("10.12");
		
		assertFalse(ChangeMachineManager.checkIfEnoughChangeAvailable(changeMachine, change2));
		
	}
	
	
	@Test
	public void testDispenseChange(){

		BigDecimal change1 = new BigDecimal("2.6");
		
		List<Denomination> returnedList = ChangeMachineManager.dispenseChange(changeMachine, change1);
		
		assertEquals(2, returnedList.size());
		
	}
	
}
