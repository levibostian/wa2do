package co.wa2do_app.wa2do.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.vo.EventVo;

public class EventDetailsFragment extends Fragment {

    private ImageView mCategory;
    private TextView mEventTitle;
    private TextView mOrganizedBy;
    private TextView mAddress;
    private TextView mCity;
    private TextView mState;
    private TextView mTime;
    private TextView mHowManyPeople;
    private ImageView mDeclineEvent;
    private ImageView mAcceptEvent;

    private static final String EVENT_KEY = "eventDetailsFragment.eventKey";

    private EventVo mEvent;

    public static EventDetailsFragment newInstance(EventVo event) {
        EventDetailsFragment eventDetailsFragment = new EventDetailsFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelable(EVENT_KEY, event);
        eventDetailsFragment.setArguments(bundle);

        return eventDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mEvent = getArguments().getParcelable(EVENT_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_details_fragment, container, false);

        mCategory = (ImageView) view.findViewById(R.id.category);
        mEventTitle = (TextView) view.findViewById(R.id.event_title);
        mOrganizedBy = (TextView) view.findViewById(R.id.organized_by);
        mAddress = (TextView) view.findViewById(R.id.address_textview);
        mCity = (TextView) view.findViewById(R.id.city_textview);
        mState = (TextView) view.findViewById(R.id.state_textview);
        mTime = (TextView) view.findViewById(R.id.what_time);
        mHowManyPeople = (TextView) view.findViewById(R.id.spots_remaining);
        mDeclineEvent = (ImageView) view.findViewById(R.id.decline_event);
        mAcceptEvent = (ImageView) view.findViewById(R.id.accept_event);

        setupViews();

        return view;
    }

    private void setupViews() {
        mCategory.setImageDrawable(getResources().getDrawable(mEvent.eventType.accept(new InterestTypes.Visitor<Integer>() {
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
        mEventTitle.setText(mEvent.eventName);
        mOrganizedBy.setText(mEvent.organizerName);
        mAddress.setText(mEvent.address);
        mCity.setText(mEvent.city + ",");
        mState.setText(mEvent.state);
        mTime.setText("begins " + mEvent.timeEventStarts + "min");
        mHowManyPeople.setText(mEvent.numberSpotsLeft + "/" + mEvent.numberSpotsAvailable);

        mDeclineEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getFragmentManager().popBackStack();
            }
        });

        mAcceptEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO create event with all info.

                Toast.makeText(getActivity(), "Accepted event.\n Have fun!", Toast.LENGTH_LONG).show();

                getActivity().getFragmentManager().popBackStack();
            }
        });
    }
}
