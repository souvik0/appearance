package com.oracle;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaximumNumberOfMeetings {

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<Meeting>();
        meetings.add(new Meeting(1, 3));
        meetings.add(new Meeting(2, 4));
        meetings.add(new Meeting(3, 6));
        meetings.add(new Meeting(5, 7));
        meetings.add(new Meeting(8, 9));
        meetings.add(new Meeting(5, 9));

        int maxMeetings = getMaximumNumberOfMeetings(meetings);
        System.out.println("Maximum number of meetings: " + maxMeetings);
    }

    public static int getMaximumNumberOfMeetings(List<Meeting> meetings) {
        // Sort meetings by end times
        Collections.sort(meetings, Comparator.comparingInt(meeting -> meeting.end));

        int count = 0;
        int lastMeetingEndTime = 0;

        // Iterate through meetings and select non-overlapping meetings
        for (Meeting meeting : meetings) {
            if (meeting.start >= lastMeetingEndTime) {
                // Select meeting if its start time is after the end time of the last selected meeting
                count++;
                lastMeetingEndTime = meeting.end;
            }
        }

        return count;
    }
}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
