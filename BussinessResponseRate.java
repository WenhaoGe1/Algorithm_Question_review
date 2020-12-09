package yelp;

import java.util.*;

public class BussinessResponseRate {
    public MyMessage[] messages;
    private int[] sender = {1, 42, 2, 2, 3, 3};
    private int[] recipient = {42, 1, 42, 42, 88, 42};
    private int[] con = {1, 1, 2, 2, 3, 4};

    public BussinessResponseRate() {
        messages = new MyMessage[6];
        for (int i = 0; i < 6; i++) {
            messages[i] = new MyMessage(sender[i], recipient[i], con[i]);
        }
    }

    private class MyMessage {
        public int sender;
        public int recipient;
        public int conversation_id;

        public MyMessage(int s, int r, int c) {
            sender = s;
            recipient = r;
            conversation_id = c;
        }
    }

    public int bussiness_resonsiveness_rate(int biz_owner, MyMessage[] messages) {
    	double res = 0;
    	Map<Integer, Integer> receive = new HashMap<>();
    	Map<Integer, Integer> response = new HashMap<>();
    	for (int i = 0; i < messages.length; i++) {
    		if (messages[i].recipient == biz_owner) {
    			if (!receive.containsKey(messages[i].conversation_id)) {
    				receive.put(messages[i].conversation_id, messages[i].sender);
    			}
    		}
    		if (messages[i].sender == biz_owner) {
	    		if (!response.containsKey(messages[i].conversation_id)) {
	    			response.put(messages[i].conversation_id, messages[i].recipient);
	    		}
    		}
    	}
    	//matched, in the same conversation,
    	for (int i : receive.keySet()) {
    		if (response.containsKey(i)) {
    			if (response.get(i).equals(receive.get(i))) {
    				res++;
    			}
    		}
    	}
    	
    	System.out.println();
    	
    	
    	res = res / receive.size() * 100;
    	
    	return (int) res;
    }
}