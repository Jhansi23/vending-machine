package com.test.machine;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ChangeMachine {

	private Set<Denomination> denominations;
	
	/**
	 * Private Default Constructor
	 * Change machine shouldn't be initialized without passing any values for denominations
	 */
	@SuppressWarnings("unused")
	private ChangeMachine(){
		
	}
	
	/**
	 * Constructor for ChangeMachine which takes varargs Denomination. The collection that contains the denominations is
	 * sorted in descending order based on the natural ordering of the Denomination class.
	 * 
	 * 
	 * @param denoms
	 */
	
	public ChangeMachine(Denomination... denoms ){
		
		if(denoms == null || denoms.length <=0)
			throw new IllegalArgumentException("Pass at least one denomination to initialize the change machine");
		
		
		denominations = new TreeSet<Denomination>(Collections.reverseOrder());
		
		for(Denomination denom : denoms){
			denominations.add(denom);
		}
		
		
	}

	
	public Set<Denomination> getDenominations(){
		
		return this.denominations;
	}
	
}
