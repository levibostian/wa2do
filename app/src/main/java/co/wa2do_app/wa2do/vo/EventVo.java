package co.wa2do_app.wa2do.vo;

import co.wa2do_app.wa2do.EventTypes;

public class EventVo {
    public EventTypes eventType;
    public String eventName;
    public String organizerName;
    public int numberSpotsLeft;
    public int numberSpotsAvailable;
    public int distanceAway;
    public int timeEventStarts;

    public EventVo(EventTypes eventType, String eventName, String organizerName, int numberSpotsLeft, int numberSpotsAvailable, int distanceAway, int timeEventStarts) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.organizerName = organizerName;
        this.numberSpotsLeft = numberSpotsLeft;
        this.numberSpotsAvailable = numberSpotsAvailable;
        this.distanceAway = distanceAway;
        this.timeEventStarts = timeEventStarts;
    }
}
