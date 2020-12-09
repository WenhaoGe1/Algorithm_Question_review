package yelp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessLocation {
    public List<Store> stores;

    private class Store {
        String name;
        String city;
        int businessID;

        public Store(String name, String city, int busineesID) {
            this.name = name;
            this.city = city;
            this.businessID = businessID;
        }
    }

    public BusinessLocation() {
        stores = new ArrayList<>();
        stores.add(new Store("Walmart", "San Jose", 1));
        stores.add(new Store("Walmart", "Los Angeles", 2));
        stores.add(new Store("Bestbuy", "San Jose", 3));
        stores.add(new Store("Bestbuy", "Los Angeles", 4));
        stores.add(new Store("Bestbuy", "Dallas", 5));
        stores.add(new Store("Bed&Bath", "San Jose", 6));
        stores.add(new Store("Bestbuy", "San Jose", 7));
        stores.add(new Store("Bestbuy", "San Jose", 8));
        stores.add(new Store("Walmart", "San Jose", 9));
        stores.add(new Store("Walgreen", "San Jose", 10));
        stores.add(new Store("Walgreen", "San Jose", 11));
    }
    
    public List<Map.Entry<String, Integer>> findStores(List<Store> stores, String city){  	
    	Map<String, Integer> map = new HashMap<>();
    	for (int i = 0; i < stores.size(); i++) {
    		if (stores.get(i).city.equals(city)) {
    			if (map.containsKey(stores.get(i).name)) {
    				Integer temp = map.get(stores.get(i).name);
    				map.put(stores.get(i).name, temp + 1);
    			} else {
    				map.put(stores.get(i).name, 1);
    			}
    		}
    	}
    	
    	List<Map.Entry<String, Integer>> result = new ArrayList<>(map.entrySet());
    	Collections.sort(result, new Comparator<Map.Entry<String, Integer>>(){
    		public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
    			if (o1.getValue() < o2.getValue()) {
    				return o2.getValue().compareTo(o1.getValue());
    			} else if (o1.getValue().equals(o2.getValue())) {
    				return o2.getValue().compareTo(o1.getValue());
    			} else {
    				return o2.getValue().compareTo(o1.getValue());
    			}
    		}
    		
    		}		
    	);
    	return result;
    }
    public void print2() {
    	List<Map.Entry<String, Integer>> result = findStores(stores, "San Jose");
    	System.out.print(result);
    }
}
