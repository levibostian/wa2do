package co.wa2do_app.wa2do.vo;

import android.os.Parcel;
import android.os.Parcelable;
import co.wa2do_app.wa2do.InterestTypes;

public class EventVo implements Parcelable {
    public InterestTypes eventType;
    public String eventName;
    public String organizerName;
    public String address;
    public String city;
    public String state;
    public int numberSpotsLeft;
    public int numberSpotsAvailable;
    public int distanceAway;
    public int timeEventStarts;

    public EventVo(InterestTypes eventType,
                   String eventName,
                   String organizerName,
                   String address,
                   String city,
                   String state,
                   int numberSpotsLeft,
                   int numberSpotsAvailable,
                   int distanceAway,
                   int timeEventStarts) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.organizerName = organizerName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.numberSpotsLeft = numberSpotsLeft;
        this.numberSpotsAvailable = numberSpotsAvailable;
        this.distanceAway = distanceAway;
        this.timeEventStarts = timeEventStarts;
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
        dest.writeInt(this.numberSpotsLeft);
        dest.writeInt(this.numberSpotsAvailable);
        dest.writeInt(this.distanceAway);
        dest.writeInt(this.timeEventStarts);
    }

    private EventVo(Parcel in) {
        this.eventType = (InterestTypes) in.readSerializable();
        this.eventName = in.readString();
        this.organizerName = in.readString();
        this.address = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.numberSpotsLeft = in.readInt();
        this.numberSpotsAvailable = in.readInt();
        this.distanceAway = in.readInt();
        this.timeEventStarts = in.readInt();
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
