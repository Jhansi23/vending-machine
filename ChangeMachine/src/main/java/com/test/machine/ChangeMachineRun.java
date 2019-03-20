package com.test.machine;

import java.math.BigDecimal;
import java.util.List;


public class ChangeMachineRun {

	public static void main(String[] args) {
		
		Denomination penny = new Denomination(1, "Penny", 20);
		Denomination nickel = new Denomination(5, "Nickel", 20);
		Denomination dime = new Denomination(10, "Dime", 20);
		Denomination quarter = new Denomination(25, "Quarter", 20);
		
		ChangeMachine changeMachine = new ChangeMachine(penny, nickel, dime, quarter);
		
		BigDecimal moneyToChange = new BigDecimal("6.13");
		
		boolean enoughChangeAvail = ChangeMachineManager.checkIfEnoughChangeAvailable(changeMachine, moneyToChange);
		
		if(enoughChangeAvail){
			List<Denomination> changeDenoms = ChangeMachineManager.dispenseChange(changeMachine, moneyToChange);
			
			System.out.println("Dispensing change for ....");
			
			for(Denomination denom : changeDenoms){
				System.out.println(denom.getName()+" - "+ denom.getCount());
			}
		}
		else{
			System.out.println("Not enough change avaialble");
		}
		
	}
}
