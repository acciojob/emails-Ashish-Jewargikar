package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
    	super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();

    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
    	calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
    	int n = calendar.size();
        int count = 0;
        int i = 0;

        // sort the meetings in ascending order of their ending time
        calendar.sort((a, b) -> a.getEndTime().compareTo(b.getEndTime()));

        // loop through all the meetings and check if the current meeting can be attended
        for (int j = 0; j < n; j++) {
            if (calendar.get(j).getStartTime().isAfter(calendar.get(i).getEndTime())) {
                count++;
                i = j;
            }
        }

        return count;
    }
}
