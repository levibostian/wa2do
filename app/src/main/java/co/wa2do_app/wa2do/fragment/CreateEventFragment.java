package co.wa2do_app.wa2do.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import co.wa2do_app.wa2do.R;

public class CreateEventFragment extends Fragment {

    private ImageView mCategoryChooser;
    private EditText mEventTitle;
    private EditText mOrganizedBy;
    private EditText mAddress;
    private EditText mCity;
    private Spinner mState;
    private EditText mTime;
    private Spinner mHowManyPeople;
    private ImageView mDeclineEvent;
    private ImageView mAcceptEvent;

    public static CreateEventFragment newInstance() {
        CreateEventFragment createEventFragment = new CreateEventFragment();

        return createEventFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_event_fragment, container, false);

        mCategoryChooser = (ImageView) view.findViewById(R.id.category_chooser);
        mEventTitle = (EditText) view.findViewById(R.id.event_title);
        mOrganizedBy = (EditText) view.findViewById(R.id.organized_by);
        mAddress = (EditText) view.findViewById(R.id.address_edittext);
        mCity = (EditText) view.findViewById(R.id.city_edittext);
        mState = (Spinner) view.findViewById(R.id.state_spinner);
        mTime = (EditText) view.findViewById(R.id.what_time);
        mHowManyPeople = (Spinner) view.findViewById(R.id.how_many_people);
        mDeclineEvent = (ImageView) view.findViewById(R.id.decline_event);
        mAcceptEvent = (ImageView) view.findViewById(R.id.accept_event);

        setupViews();

        return view;
    }

    private void setupViews() {
        mCategoryChooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO bring up category chooser
            }
        });

        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.state_array, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mState.setAdapter(stateAdapter);

        ArrayAdapter<CharSequence> howManyPeopleAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.number_of_people, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mHowManyPeople.setAdapter(howManyPeopleAdapter);

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

                Toast.makeText(getActivity(), "Event created successfully", Toast.LENGTH_LONG).show();

                getActivity().getFragmentManager().popBackStack();
            }
        });
    }

}
