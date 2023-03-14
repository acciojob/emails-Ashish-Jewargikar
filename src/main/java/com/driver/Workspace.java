package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.*;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
       super(emailId,Integer.MAX_VALUE);
       calendar= new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        List<Pair<LocalTime,Integer>> endtimes = new ArrayList<>();
        for(int i=0;i<calendar.size();i++){
            endtimes.add(Pair.of(calendar.get(i).getEndTime(),i));
        }

        Collections.sort(endtimes);

        LocalTime temp = endtimes.get(0).getLeft();
        int cnt=0;
        if(!endtimes.isEmpty()){
            cnt+=1;
        }
        for(int i=1;i<calendar.size();i++){
          if(calendar.get(endtimes.get(i).getRight()).getStartTime().compareTo(temp)>0){
              cnt++;
              temp=endtimes.get(i).getLeft();
          }

        }


        return cnt;
    }
}