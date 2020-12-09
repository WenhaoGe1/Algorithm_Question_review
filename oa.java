package yelp;

import java.util.LinkedList;
import java.util.List;

public class oa {
	public static void main(String[] args) {
		String reviews = "reviews";
		String ads = "ads";
		String pageViews = "pageViews";
		
		List<String> eventType = new LinkedList<>();
		eventType.add(reviews);
		eventType.add(reviews);
		eventType.add(ads);
		eventType.add(ads);
		eventType.add(ads);
		eventType.add(pageViews);
		eventType.add(pageViews);
		
		List<Integer> occurance = new LinkedList<>();
		occurance.add(7);
		occurance.add(3);
		occurance.add(11);
		occurance.add(7);
		occurance.add(6);
		occurance.add(3);
		occurance.add(12);
		
		List<Integer> bizId = new LinkedList<>();
		bizId.add(1);
		bizId.add(3);
		bizId.add(1);
		bizId.add(2);
		bizId.add(3);
		bizId.add(1);
		bizId.add(2);
		
		List<Integer> result = new LinkedList<>();
		result = findActive(eventType, occurance, bizId);
//		System.out.println(bizId.get(1));
//		System.out.println(bizId.indexOf(45));
		
		System.out.println(result);
	}
	
	public static List<Integer> findActive(List<String> eventType, List<Integer> occurance, List<Integer> bizId){
		
		List<Integer> result = new LinkedList<>();
		return result;
	}
}
