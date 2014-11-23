package co.wa2do_app.wa2do.vo;

import co.wa2do_app.wa2do.InterestTypes;

public class EventVo {
    public InterestTypes eventType;
    public String eventName;
    public String organizerName;
    public int numberSpotsLeft;
    public int numberSpotsAvailable;
    public int distanceAway;
    public int timeEventStarts;

    public EventVo(InterestTypes eventType, String eventName, String organizerName, int numberSpotsLeft, int numberSpotsAvailable, int distanceAway, int timeEventStarts) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.organizerName = organizerName;
        this.numberSpotsLeft = numberSpotsLeft;
        this.numberSpotsAvailable = numberSpotsAvailable;
        this.distanceAway = distanceAway;
        this.timeEventStarts = timeEventStarts;
    }
}
