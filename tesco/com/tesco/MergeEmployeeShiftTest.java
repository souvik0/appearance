package com.tesco;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeEmployeeShiftTest {

    @Test
    public void testMergeOverlappingIntervals() {
        Interval interval1 = new Interval(1, 3);
        Interval interval2 = new Interval(2, 6);
        Interval interval3 = new Interval(8, 10);
        Interval interval4 = new Interval(15, 18);

        List<Interval> inputIntervals = new ArrayList<>(Arrays.asList(interval1, interval2, interval3, interval4));
        List<Interval> expectedOutput = new ArrayList<>(Arrays.asList(new Interval(1, 6), new Interval(8, 10), new Interval(15, 18)));

        // Output from actual method invocation
        List<Interval> mergedIntervals = MergeEmployeeShifts.mergeShift(inputIntervals);

        Assertions.assertEquals(expectedOutput, mergedIntervals);
    }
}
