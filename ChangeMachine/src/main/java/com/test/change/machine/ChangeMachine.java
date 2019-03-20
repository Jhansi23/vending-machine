package com.test.change.machine;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.TreeSet;

public class ChangeMachine {

	
	
	public static void main(String[] args) {
		
		//Solution 1
		
		Map<Integer, String> denomMap = new TreeMap<Integer, String>(Collections.reverseOrder());
		
		denomMap.put(1, "Penny");
		denomMap.put(5, "Nickel");
		denomMap.put(10, "Dime");
		denomMap.put(25, "Quarter");
		
		
		BigDecimal price = new BigDecimal("4.10");
		
		price = price.multiply(new BigDecimal("100"));
		
		Integer newPrice = price.intValue();
		
		StringBuffer change = new StringBuffer("");
		
		for(Entry<Integer, String> denomEntry : denomMap.entrySet()){
			
			int count = (newPrice)/(denomEntry.getKey());
			
			change.append(denomEntry.getValue()).append(" - ").append(count).append("\n");
			
			newPrice = (newPrice) %  (denomEntry.getKey());
			
		}
		
		//System.out.println(change.toString());
		
		
		//Solution 2
		
		Denomination penny = new Denomination(1, "Penny", 0);
		Denomination nickel = new Denomination(5, "Nickel", 0);
		Denomination dime = new Denomination(10, "Dime", 10);
		Denomination quarter = new Denomination(25, "Quarter", 4);
	
		
		Set<Denomination> denomSet = new TreeSet<Denomination>(Collections.reverseOrder());
	
		denomSet.add(nickel);
		denomSet.add(penny);
		denomSet.add(quarter);
		denomSet.add(dime);
		
		
		BigDecimal price2 = new BigDecimal("1.75");
		
		price2 = price2.multiply(new BigDecimal("100"));
		
		Integer newPrice2 = price2.intValue();
		
		
		if(totalAvailableMoneyInTheMachine(denomSet) > newPrice2){
			System.out.println("Enough money available");
			convertMoneyToChange(newPrice2, denomSet);
		}else{
			//throw new Exception("There is not ");
			System.out.println("There is not enough money in the machine to serve the change request");
		};
		
		
		BigDecimal price3 = new BigDecimal("23.50");
		
		price3 = price3.multiply(new BigDecimal("100"));
		
		Integer newPrice3 = price3.intValue();
		
		
		if(totalAvailableMoneyInTheMachine(denomSet) > newPrice3){
			System.out.println("Enough money available");
			convertMoneyToChange(newPrice3, denomSet);
		}else{
			//throw new Exception("There is not ");
			System.out.println("There is not enough money in the machine to serve the change request");
		};
		
		
		
	}
	
	private static void convertMoneyToChange(Integer price, Set<Denomination> denomSet){
		
		StringBuffer change2 = new StringBuffer("");
		
		for(Denomination denom : denomSet){
			
			int count = (price)/(denom.getValue());
			
			if(count == 0)
			 continue;
			
			if(count > denom.getCount()){
				
				int avail = denom.getCount();
				
				change2.append(denom.getName()).append(" - ").append(avail).append("\n");
				denom.decreaseCount(avail);
				
				price = (price)%(denom.getValue()) + (count - avail)*denom.getValue();
				
			}else{
				change2.append(denom.getName()).append(" - ").append(count).append("\n");
				denom.decreaseCount(count);
				price = (price)%(denom.getValue());
			}
			
			if(price == 0)
				break;
			
		}
		
		System.out.println(change2.toString());
		
	}
	
	
	private static Integer totalAvailableMoneyInTheMachine(Set<Denomination> denomSet){
		
		Integer availMoney = 0;
		
		for(Denomination denom : denomSet){
			availMoney = availMoney + (denom.getCount() * denom.getValue());
		}
		
		return availMoney;
	}
}
