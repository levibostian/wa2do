package co.wa2do_app.wa2do.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.vo.InterestVo;

import java.util.ArrayList;
import java.util.List;

public class EventsSwipeCardAdapter extends ArrayAdapter<InterestVo> {

    private Context mContext;
    private ArrayList<InterestVo> mInterests;

    public EventsSwipeCardAdapter(Context context, int resource, List<InterestVo> interests) {
        super(context, resource, interests);

        mContext = context;
        mInterests = (ArrayList<InterestVo>) interests;
    }

    static class ViewHolder {
        public ImageView eventImage;
        public TextView eventName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View swipeView = convertView;

        if (swipeView == null) {
            swipeView = LayoutInflater.from(mContext).inflate(R.layout.events_swipe_view, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.eventImage = (ImageView) swipeView.findViewById(R.id.event_imageview);
            viewHolder.eventName = (TextView) swipeView.findViewById(R.id.event_name_textview);

            swipeView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) swipeView.getTag();

        final InterestVo interest = mInterests.get(position);

        viewHolder.eventImage.setImageDrawable(mContext.getResources().getDrawable(interest.eventImageRes));
        viewHolder.eventName.setText(interest.interest.accept(new InterestTypes.Visitor<CharSequence>() {
            @Override
            public CharSequence visitSports() {
                return "Sports";
            }

            @Override
            public CharSequence visitArts() {
                return "Arts";
            }

            @Override
            public CharSequence visitVideoGames() {
                return "Video Games";
            }

            @Override
            public CharSequence visitDrinking() {
                return "Drinking";
            }

            @Override
            public CharSequence visitExercise() {
                return "Exercise";
            }

            @Override
            public CharSequence visitBookClub() {
                return "Book Club";
            }
        }));

        return swipeView;
    }

}
