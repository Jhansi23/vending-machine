package com.test.machine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class ChangeMachineManager {

	/**
	 * Method to check if enough cash is available in the machine to dispense change for the given amount
	 * 
	 * @param changeMachine ChangeMachine which contains the denominations
	 * @param moneyToChange Amount to be converted into change
	 * 
	 * @return true if enough change is available, otherwise false
	 */
	
	public static boolean checkIfEnoughChangeAvailable(ChangeMachine changeMachine, BigDecimal moneyToChange){
		
		// if the changemachine is null or if there are no denominations in the machine, return false
		if(changeMachine == null || changeMachine.getDenominations() == null || 
				changeMachine.getDenominations().size() == 0 || moneyToChange == null )
			return false;
		
		if(moneyToChange.doubleValue() ==0 )
			return false;
		
		int totalMoneyAvailableInTheMachine = 0;
		
		//iterate over all the denominations in the machine and add up the amount
		
		for ( Denomination denom : changeMachine.getDenominations()){
			totalMoneyAvailableInTheMachine = totalMoneyAvailableInTheMachine + (denom.getCount() * denom.getValue());
		}
		
		//Convert the given amount to cents value.
		int moneyToChangeInt  = moneyToChange.multiply(new BigDecimal("100")).intValue();
		
		
		return (totalMoneyAvailableInTheMachine >= moneyToChangeInt)? true: false;
		
	}
	
	/**
	 * Method to dispense Change for the given amount
	 * 
	 * @param changeMachine ChangeMachine which contains the denominations
	 * @param moneyToChange Amount to be converted into change
	 * 
	 * @return List of denominations that represent the change for given amount. Null if the change machine is null or if it doesn't contain any denominations
	 * 
	 */
	public static List<Denomination> dispenseChange(ChangeMachine changeMachine, BigDecimal moneyToChange){
		
		if(changeMachine == null || changeMachine.getDenominations() == null || 
				changeMachine.getDenominations().size() == 0 || moneyToChange == null )
			return null;
		
		if(moneyToChange.doubleValue() == 0 )
			return null;
		
		//convert given amount to cents by multiplying with 100
		
		int moneyToChangeInt  = moneyToChange.multiply(new BigDecimal("100")).intValue();
		
		List<Denomination> changeDenoms = new ArrayList<Denomination>();
		
		
		//iterate over all the available denominations in the change machine to dispense change
		
		for(Denomination denom : changeMachine.getDenominations()){
			
			/*
			 * divide the moneyToChange by the current denomination value to check how 
			 * many coins of this type to dispense
			 */
			
			
			int numberofCoinsToDispense = (moneyToChangeInt)/(denom.getValue());
			
			
			/*
			 * Skip the loop if we don't need to dispense any coins of the denomination
			 */
			
			if(numberofCoinsToDispense == 0)
			 continue;
			
			Denomination newDenom = null;
			
			
			if(numberofCoinsToDispense > denom.getCount()){
				

				/*
				 * If the numberofCoinsToDispense is more than the number of available coins, then we can dispense
				 * only the available coints. the remaining amount has to be dispensed in other denominations.
				 */
				
				int avail = denom.getCount();
				
				newDenom = new Denomination(denom.getValue(), denom.getName(), avail);
				
				denom.decreaseCount(avail);
				
				//this will calculate how much remaining money to dispense.
				
				moneyToChangeInt = (moneyToChangeInt)%(denom.getValue()) + (numberofCoinsToDispense - avail)*denom.getValue();
				
				
			}else{
				
				//we have enough coins available to dispense
				
				newDenom = new Denomination(denom.getValue(), denom.getName(), numberofCoinsToDispense);
				denom.decreaseCount(numberofCoinsToDispense);
				
				
				//remaining money to dispense
				moneyToChangeInt = (moneyToChangeInt)%(denom.getValue());
			}
			
			
			changeDenoms.add(newDenom);
			
			if(moneyToChangeInt == 0)
				break;
			
		}
		

		return changeDenoms;
	}
	
}
