package co.wa2do_app.wa2do.vo;

import android.os.Parcel;
import android.os.Parcelable;
import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.vo.firebase.Event;

public class EventVo implements Parcelable {
    public InterestTypes eventType;
    public String eventName;
    public String organizerName;
    public String address;
    public String city;
    public String state;
    public long numberSpotsLeft;
    public long numberSpotsAvailable;
    public long distanceAway;
    public long hour;
    public long minute;

    public EventVo(InterestTypes eventType,
                   String eventName,
                   String organizerName,
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
        this.organizerName = organizerName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.numberSpotsLeft = numberSpotsLeft;
        this.numberSpotsAvailable = numberSpotsAvailable;
        this.distanceAway = distanceAway;
        this.hour = hour;
        this.minute = minute;
    }

    public static Event createEvent(EventVo eventVo) {
        Event event = new Event(eventVo.eventType.accept(new InterestTypes.Visitor<InterestTypes>() {
            @Override
            public InterestTypes visitSports() {
                return InterestTypes.SPORTS;
            }

            @Override
            public InterestTypes visitArts() {
                return InterestTypes.ARTS;
            }

            @Override
            public InterestTypes visitVideoGames() {
                return InterestTypes.VIDEO_GAMES;
            }

            @Override
            public InterestTypes visitDrinking() {
                return InterestTypes.DRINKING;
            }

            @Override
            public InterestTypes visitExercise() {
                return InterestTypes.EXERCISE;
            }

            @Override
            public InterestTypes visitBookClub() {
                return InterestTypes.BOOK_CLUB;
            }
        }),
                                eventVo.eventName,
                                eventVo.firstName,
                                eventVo.lastName,
                                eventVo.address,
                                eventVo.city,
                                eventVo.state,
                                eventVo.numberSpotsLeft,
                                eventVo.numberSpotsAvailable,
                                eventVo.distanceAway,
                                eventVo.hour,
                                eventVo.minute);

        return event;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.eventType);
        dest.writeString(this.eventName);
        dest.writeString(this.organizerName);
        dest.writeString(this.address);
        dest.writeString(this.city);
        dest.writeString(this.state);
        dest.writeLong(this.numberSpotsLeft);
        dest.writeLong(this.numberSpotsAvailable);
        dest.writeLong(this.distanceAway);
        dest.writeLong(this.hour);
        dest.writeLong(this.minute);
    }

    private EventVo(Parcel in) {
        this.eventType = (InterestTypes) in.readSerializable();
        this.eventName = in.readString();
        this.organizerName = in.readString();
        this.address = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.numberSpotsLeft = in.readLong();
        this.numberSpotsAvailable = in.readLong();
        this.distanceAway = in.readLong();
        this.hour = in.readLong();
        this.minute = in.readLong();
    }

    public static final Parcelable.Creator<EventVo> CREATOR = new Parcelable.Creator<EventVo>() {
        public EventVo createFromParcel(Parcel source) {
            return new EventVo(source);
        }

        public EventVo[] newArray(int size) {
            return new EventVo[size];
        }
    };
}
