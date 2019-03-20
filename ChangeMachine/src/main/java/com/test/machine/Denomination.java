package com.test.machine;


public class Denomination implements Comparable<Denomination>{

	private int value;
	private String name;
	private int count;
	
	/**
	 * Constructor for the Denomination
	 * 
	 * @param val Integer value of the denomination. For example, 1 for penny, 5 for nickel, 10 for dime etc...
	 * @param name Name of the denomination.
	 * @param count Number of coins of this denomination in the machine
	 */
	public Denomination(int val, String name, int count){
		this.value = val;
		this.name = name;
		this.count = count;
	}
	
	
	public int getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	public int getCount() {
		return count;
	}
	
	/**
	 * Method to modify the count of the denomination.
	 * @param used value by which to decrease the count in the machine. Throws ArithmenticException if the passed value is more than the count 
	 */
	public void decreaseCount(int used){
		
		if(this.count < used)
		{
			throw new ArithmeticException("Don't have any coins available to dispense");
		}
		
		this.count = this.getCount() - used;
	}


	@Override
	public int compareTo(Denomination other) {
		return (this.value - other.value);
	}
	
	
	
}
