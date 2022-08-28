package org.example.__temp._generic_null;

import java.time.temporal.Temporal;

/**
 * @param <TimeType> the type of the time it handles.
 */
public class Interval<TimeType extends Temporal>{
    private final TimeType start;
    private final TimeType end;

    public Interval(TimeType start, TimeType end){
        this.start = start;
        this.end = end;
    }

    public TimeType getStart(){
        return this.start;
    }

    public TimeType getEnd(){
        return this.end;
    }
}
