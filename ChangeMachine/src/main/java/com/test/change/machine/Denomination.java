package com.test.change.machine;

public class Denomination implements Comparable<Denomination>{

	private Integer value;
	private String name;
	private Integer count;
	
	public Denomination(Integer val, String name, Integer count){
		this.value = val;
		this.name = name;
		this.count = count;
	}
	
	
	public Integer getValue() {
		return value;
	}
	public String getName() {
		return name;
	}
	public Integer getCount() {
		return count;
	}
	
	public void decreaseCount(Integer used){
		this.count = this.getCount() - used;
	}


	@Override
	public int compareTo(Denomination other) {
		return (this.value - other.value);
	}
	
	
}
