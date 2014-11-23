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
import co.wa2do_app.wa2do.vo.EventVo;

import java.util.ArrayList;
import java.util.List;

public class EventsListAdapter extends ArrayAdapter<EventVo> {

    private Context mContext;
    private ArrayList<EventVo> mEvents;

    public EventsListAdapter(Context context, int resource, List<EventVo> events) {
        super(context, resource, events);

        mContext = context;
        mEvents = (ArrayList<EventVo>) events;
    }

    static class ViewHolder {
        public ImageView categoryImage;
        public TextView eventName;
        public TextView eventOrganizerName;
        public TextView numberOfSpotsLeft;
        public TextView distanceAway;
        public TextView timeEventStarts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        if (rowView == null) {
            rowView = LayoutInflater.from(mContext).inflate(R.layout.events_list_row, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.categoryImage = (ImageView) rowView.findViewById(R.id.category_image);
            viewHolder.eventName = (TextView) rowView.findViewById(R.id.event_name);
            viewHolder.eventOrganizerName = (TextView) rowView.findViewById(R.id.event_organizer_name);
            viewHolder.numberOfSpotsLeft = (TextView) rowView.findViewById(R.id.number_spots_available);
            viewHolder.distanceAway = (TextView) rowView.findViewById(R.id.distance_away);
            viewHolder.timeEventStarts = (TextView) rowView.findViewById(R.id.time_event_starts);

            rowView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) rowView.getTag();

        final EventVo event = mEvents.get(position);

        viewHolder.categoryImage.setImageDrawable(mContext.getResources().getDrawable(event.eventType.accept(new InterestTypes.Visitor<Integer>() {
            @Override
            public Integer visitSports() {
                return R.drawable.sports;
            }

            @Override
            public Integer visitArts() {
                return R.drawable.arts;
            }

            @Override
            public Integer visitVideoGames() {
                return R.drawable.games;
            }

            @Override
            public Integer visitDrinking() {
                return R.drawable.drinking;
            }

            @Override
            public Integer visitExercise() {
                return R.drawable.exercise;
            }

            @Override
            public Integer visitBookClub() {
                return R.drawable.bookclub;
            }
        })));
        viewHolder.eventName.setText(event.eventName);
        viewHolder.eventOrganizerName.setText("organized by: " + event.organizerName);
        viewHolder.numberOfSpotsLeft.setText(event.numberSpotsLeft + "/" + event.numberSpotsAvailable);
        viewHolder.distanceAway.setText(event.distanceAway+"mi");
        viewHolder.timeEventStarts.setText("begins " + event.hour + " min");

        return rowView;
    }
}
