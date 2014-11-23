package co.wa2do_app.wa2do.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import co.wa2do_app.wa2do.EventTypes;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.adapter.EventsListAdapter;
import co.wa2do_app.wa2do.vo.EventVo;

import java.util.ArrayList;

public class EventFragment extends Fragment {

    private Spinner mCategorySpinner;
    private Spinner mDistanceSpinner;
    private ListView mEventsList;

    public static EventFragment newInstance() {
        return new EventFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_fragment, container, false);

        mCategorySpinner = (Spinner) view.findViewById(R.id.category_spinner);
        mDistanceSpinner = (Spinner) view.findViewById(R.id.distance_spinner);
        mEventsList = (ListView) view.findViewById(R.id.events_list);

        setupView();

        return view;
    }

    private void setupView() {
        ArrayAdapter<CharSequence> distanceSpinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.distance_filter, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> categorySpinnerAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.category_filter, android.R.layout.simple_spinner_item);

        distanceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mCategorySpinner.setAdapter(distanceSpinnerAdapter);
        mDistanceSpinner.setAdapter(categorySpinnerAdapter);

        mCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        mDistanceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        ArrayList<EventVo> events = new ArrayList<EventVo>();
        events.add(new EventVo(EventTypes.SPORTS, "Racketball", "Levi Bostian", 3, 5, 32, 5));
        events.add(new EventVo(EventTypes.ARTS, "Nickelback", "Trevor Carlson", 999, 1000, 5, 12));

        EventsListAdapter eventsListAdapter = new EventsListAdapter(getActivity(), R.layout.events_list_row, events);
        mEventsList.setAdapter(eventsListAdapter);
    }

}
