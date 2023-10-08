package com.tesco;

import java.util.*;

public class MergeEmployeeShifts {

    public static void main(String[] args) {
        List<Interval> empShiftList = new ArrayList<>();
        empShiftList.add(new Interval(1, 3));
        empShiftList.add(new Interval(2, 6));
        empShiftList.add(new Interval(8, 10));
        empShiftList.add(new Interval(15, 18));

        mergeShift(empShiftList);
    }

    public static List<Interval> mergeShift(List<Interval> intervals) {
         List<Interval> mergedIntervals = new ArrayList<>();
         if (intervals == null || intervals.isEmpty()) {
             return mergedIntervals;
         }

         // Sort intervals by their start values
         intervals.sort(Comparator.comparing(interval -> interval.startShift));

         Interval currentInterval = intervals.get(0);

         for (int i = 1; i < intervals.size(); i++) {
             Interval nextInterval = intervals.get(i);

             if (currentInterval.endShift >= nextInterval.startShift) {
                 // Overlapping intervals, merge them
                 currentInterval.endShift = Math.max(currentInterval.endShift, nextInterval.endShift);
             } else {
                 // Non-overlapping intervals, add current interval to result and update currentInterval
                 mergedIntervals.add(currentInterval);
                 currentInterval = nextInterval;
             }
         }

         // Add the last interval
         mergedIntervals.add(currentInterval);

         return mergedIntervals;
    }
}

class Interval {
    public int startShift;
    public int endShift;

    Interval(int startShift, int endShift) {
        this.startShift = startShift;
        this.endShift = endShift;
    }
}
