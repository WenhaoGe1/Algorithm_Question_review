package yelp;

import java.util.*;

public class BusinessOpenHourRatio {
	public List<TimeRange> openHours;
	
	private class TimeRange {
        public int start;
        public int end;

        public TimeRange(int start, int end) {
        	this.start = start;
        	this.end = end;
        }
    }
	
	public BusinessOpenHourRatio(){
		
	}
	
	public float ratio(TimeRange queryTimeRange, List<TimeRange> openHours) {
		
	}
}
