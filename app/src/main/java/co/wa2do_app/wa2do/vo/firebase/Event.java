package co.wa2do_app.wa2do.vo.firebase;

import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.vo.EventVo;

public class Event {
    public String eventType;
    public String eventName;
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public long numberSpotsLeft;
    public long numberSpotsAvailable;
    public long distanceAway;
    public long hour;
    public long minute;

    public Event(InterestTypes eventType,
                   String eventName,
                   String firstName,
                   String lastName,
                   String address,
                   String city,
                   String state,
                   long numberSpotsLeft,
                   long numberSpotsAvailable,
                   long distanceAway,
                   long hour,
                   long minute) {
        this.eventType = eventType.accept(new InterestTypes.Visitor<String>() {
            @Override
            public String visitSports() {
                return "Sports";
            }

            @Override
            public String visitArts() {
                return "Arts";
            }

            @Override
            public String visitVideoGames() {
                return "Video Games";
            }

            @Override
            public String visitDrinking() {
                return "Drinking";
            }

            @Override
            public String visitExercise() {
                return "Exercise";
            }

            @Override
            public String visitBookClub() {
                return "Book Club";
            }
        });
        this.eventName = eventName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.numberSpotsLeft = numberSpotsLeft;
        this.numberSpotsAvailable = numberSpotsAvailable;
        this.distanceAway = distanceAway;
        this.hour = hour;
        this.minute = minute;
    }

    public Event(String eventType,
                 String eventName,
                 String firstName,
                 String lastName,
                 String address,
                 String city,
                 String state,
                 long numberSpotsLeft,
                 long numberSpotsAvailable,
                 long distanceAway,
                 long hour,
                 long minute) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.numberSpotsLeft = numberSpotsLeft;
        this.numberSpotsAvailable = numberSpotsAvailable;
        this.distanceAway = distanceAway;
        this.hour = hour;
        this.minute = minute;
    }

    public static EventVo createEventVo(Event event) {
        // TODO this is bad but it's crunch time.
        InterestTypes category;

        if (event.eventType.equals("Sports")) {
            category = InterestTypes.SPORTS;
        } else if (event.eventType.equals("Arts")) {
            category = InterestTypes.ARTS;
        } else if (event.eventType.equals("Video Games")) {
            category = InterestTypes.VIDEO_GAMES;
        } else if (event.eventType.equals("Drinking")) {
            category = InterestTypes.DRINKING;
        } else if (event.eventType.equals("Exercise")) {
            category = InterestTypes.EXERCISE;
        } else { // book club
            category = InterestTypes.BOOK_CLUB;
        }

        EventVo eventVo = new EventVo(category,
                                      event.eventName,
                                      event.firstName,
                                      event.lastName,
                                      event.address,
                                      event.city,
                                      event.state,
                                      event.numberSpotsLeft,
                                      event.numberSpotsAvailable,
                                      event.distanceAway,
                                      event.hour,
                                      event.minute);

        return eventVo;
    }

}
