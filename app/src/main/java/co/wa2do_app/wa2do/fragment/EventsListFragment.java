package co.wa2do_app.wa2do.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.adapter.CategoryFilterAdapter;
import co.wa2do_app.wa2do.adapter.EventsListAdapter;
import co.wa2do_app.wa2do.mock.MockEvents;
import co.wa2do_app.wa2do.vo.EventVo;
import co.wa2do_app.wa2do.vo.InterestVo;

import java.util.ArrayList;

public class EventsListFragment extends Fragment {

    private Spinner mCategorySpinner;
    private Spinner mDistanceSpinner;
    private ListView mEventsList;

    private static final String INTERESTS_KEY = "eventsFragment.interestsKey";

    private ArrayList<InterestVo> mInterestedItems;

    public static EventsListFragment newInstance(ArrayList<InterestVo> interestedItems) {
        EventsListFragment eventFragment = new EventsListFragment();

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(INTERESTS_KEY, interestedItems);

        eventFragment.setArguments(bundle);

        return eventFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        mInterestedItems = getArguments().getParcelableArrayList(INTERESTS_KEY);
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
        CategoryFilterAdapter categorySpinnerAdapter = new CategoryFilterAdapter(getActivity(), android.R.layout.simple_spinner_item, mInterestedItems);

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

        setupList(getFilteredEvents());

        mEventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getActivity().getFragmentManager()
                             .beginTransaction()
                             .replace(R.id.fragment_container, EventDetailsFragment.newInstance(getFilteredEvents().get(position)))
                             .addToBackStack(null)
                             .commit();
            }
        });
    }

    private void setupList(ArrayList<EventVo> events) {
        EventsListAdapter eventsListAdapter = new EventsListAdapter(getActivity(), R.layout.events_list_row, events);
        mEventsList.setAdapter(eventsListAdapter);
        eventsListAdapter.notifyDataSetChanged();
    }

    private ArrayList<EventVo> getFilteredEvents() {
        ArrayList<EventVo> events = MockEvents.getEvents();

        ArrayList<EventVo> filteredEvents = new ArrayList<EventVo>();
        for (EventVo event : events) {
            for (InterestVo interest : mInterestedItems) {
                if (event.eventType.equals(interest.interest)) {
                    filteredEvents.add(event);
                }
            }
        }

        return filteredEvents;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.event_list_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.create_event:
                CreateEventFragment fragment = CreateEventFragment.newInstance();
                fragment.setListener(new CreateEventFragment.CreateEventListener() {
                    @Override
                    public void eventCreated(EventVo createdEvent) {
                        ArrayList<EventVo> events = getFilteredEvents();
                        events.add(createdEvent);
                        setupList(events);
                    }
                });

                getActivity().getFragmentManager()
                             .beginTransaction()
                             .replace(R.id.fragment_container, fragment)
                             .addToBackStack(null)
                             .commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
