package co.wa2do_app.wa2do.vo;

import android.os.Parcel;
import android.os.Parcelable;
import co.wa2do_app.wa2do.InterestTypes;

public class InterestVo implements Parcelable {

    public int eventImageRes;
    public InterestTypes interest;

    public InterestVo(int eventImageRes, InterestTypes interest) {
        this.eventImageRes = eventImageRes;
        this.interest = interest;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.eventImageRes);
        dest.writeInt(this.interest == null ? -1 : this.interest.ordinal());
    }

    private InterestVo(Parcel in) {
        this.eventImageRes = in.readInt();
        int tmpInterest = in.readInt();
        this.interest = tmpInterest == -1 ? null : InterestTypes.values()[tmpInterest];
    }

    public static final Parcelable.Creator<InterestVo> CREATOR = new Parcelable.Creator<InterestVo>() {
        public InterestVo createFromParcel(Parcel source) {
            return new InterestVo(source);
        }

        public InterestVo[] newArray(int size) {
            return new InterestVo[size];
        }
    };
}
