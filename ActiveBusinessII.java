package yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActiveBusinessII{
    public List<Event> events;
    public int eventTypeAmount;

    private class Event{
        String type;
        int times;
        int biz_id;

        public Event(String type, int times, int biz_id) {
            this.type = type;
            this.times = times;
            this.biz_id = biz_id;
        }
    }

    public ActiveBusinessII(){
        events = new ArrayList<>();
        eventTypeAmount = 4;
        events.add(new Event("ads", 7, 3));
        events.add(new Event("ads", 8, 2));
        events.add(new Event("ads", 5, 1));
        events.add(new Event("page_views", 11, 2));
        events.add(new Event("page_views", 12, 3));
        events.add(new Event("photo_views", 10, 3));
        events.add(new Event("reviews", 7, 2));
    }
    private List<Integer> findActive(List<Event> events){
    	List<Integer> result = new ArrayList<>();
    	Map<Integer, Integer[]> bizs = new HashMap<>();
    	
    	// [ph, ads, pg, re]
    	int[] sum = new int[eventTypeAmount];
    	// count how many events types
    	int[] count = new int[eventTypeAmount];
    	
    	for(int i = 0;i < events.size(); i++) {
    		if (events.get(i).type.equals("photo_views")) {
    			sum[0] += events.get(i).times;
    			count[0]++;
    			if (!bizs.containsKey(events.get(i).biz_id)) {
    				Integer[] temp = {0, 0, 0, 0};
    				temp[0] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    			} else {
    				Integer[] temp = bizs.get(events.get(i).biz_id);
    				temp[0] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    			}
    		} else if (events.get(i).type.equals("ads")) {
    			sum[1] += events.get(i).times;
    			count[1]++;
    			if (!bizs.containsKey(events.get(i).biz_id)) {
    				Integer[] temp = {0, 0, 0, 0};
    				temp[1] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    			} else {
    				Integer[] temp = bizs.get(events.get(i).biz_id);
    				temp[1] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    			}
    		} else if (events.get(i).type.equals("page_views")) {
    			sum[2] += events.get(i).times;
    			count[2]++;
    			if (!bizs.containsKey(events.get(i).biz_id)) {
    				Integer[] temp = {0, 0, 0, 0};
    				temp[2] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    			} else {
    				Integer[] temp = bizs.get(events.get(i).biz_id);
    				temp[2] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    			}
    		} else if (events.get(i).type.equals("reviews")) {
    			sum[3] += events.get(i).times;
    			count[3]++;
    			if (!bizs.containsKey(events.get(i).biz_id)) {
    				Integer[] temp = {0, 0, 0, 0};
    				temp[3] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    			} else{
    				Integer[] temp = bizs.get(events.get(i).biz_id);
    				temp[3] = events.get(i).times;
    				bizs.put(events.get(i).biz_id, temp);
    				
    			}
    		}
    	}
    	
    	double[] ave = new double[4];
		for (int i = 0; i < sum.length; i++) {
			if (count[i] != 0) {
				ave[i] = sum[i] / count[i];
			}
		}
		for (int id : bizs.keySet()) {
			Integer[] t = bizs.get(id);
			int numOfGoodType = 0;
			for (int k = 0; k < t.length; k++) {
				if (t[k] >= ave[k]) {
					numOfGoodType++;
				}
				if (numOfGoodType >= 2) {
					result.add(id);
				}
			}
		}
    	return result;
    }
    
    public void print3() {
    	List<Integer> lis = findActive(events);
        for (Integer s: lis) {
            System.out.print(s + " ");
        }
        System.out.println("");
    }

}
