package co.wa2do_app.wa2do.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.fragment.dialog.CategoryChooserDialogFragment;
import co.wa2do_app.wa2do.fragment.dialog.TimePickerFragment;
import co.wa2do_app.wa2do.vo.EventVo;

public class CreateEventFragment extends Fragment {

    private ImageView mCategoryChooser;
    private EditText mEventTitle;
    private EditText mOrganizedBy;
    private EditText mAddress;
    private EditText mCity;
    private Spinner mState;
    private Button mTime;
    private Spinner mHowManyPeople;
    private ImageView mDeclineEvent;
    private ImageView mAcceptEvent;

    private InterestTypes mSelectedCategory;

    // TODO should not be holding onto a fragment. Find better picker first, then try to fix issue.
    private TimePickerFragment mTimePickerFragment;

    private CreateEventListener mListener;

    public interface CreateEventListener {
        public void eventCreated(EventVo createdEvent);
    }

    public static CreateEventFragment newInstance() {
        CreateEventFragment createEventFragment = new CreateEventFragment();

        return createEventFragment;
    }

    public void setListener(CreateEventListener listener) {
        mListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_event_fragment, container, false);

        mCategoryChooser = (ImageView) view.findViewById(R.id.category_chooser);
        mEventTitle = (EditText) view.findViewById(R.id.create_event_title);
        mOrganizedBy = (EditText) view.findViewById(R.id.create_event_organized_by);
        mAddress = (EditText) view.findViewById(R.id.address_edittext);
        mCity = (EditText) view.findViewById(R.id.city_edittext);
        mState = (Spinner) view.findViewById(R.id.state_spinner);
        mTime = (Button) view.findViewById(R.id.create_event_what_time);
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
                FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
                CategoryChooserDialogFragment fragment = new CategoryChooserDialogFragment();

                fragment.setListener(new CategoryChooserDialogFragment.CategoryChooserListener() {
                    @Override
                    public void categoryChosen(InterestTypes category) {
                        mSelectedCategory = category;
                        mCategoryChooser.setImageDrawable(getResources().getDrawable(category.accept(new InterestTypes.Visitor<Integer>() {
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
                    }
                });
                fragment.show(ft, "categoryChooser");
            }
        });

        ArrayAdapter<CharSequence> stateAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.state_array, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mState.setAdapter(stateAdapter);

        ArrayAdapter<CharSequence> howManyPeopleAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.number_of_people, android.R.layout.simple_spinner_item);
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mHowManyPeople.setAdapter(howManyPeopleAdapter);

        mTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();

                mTimePickerFragment = TimePickerFragment.newInstance();
                mTimePickerFragment.show(ft, "dialog");
            }
        });

        mDeclineEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getFragmentManager().popBackStack();
            }
        });

        mAcceptEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener == null) {
                    throw new IllegalStateException("Forgot to set listener");
                }

                Toast.makeText(getActivity(), "Event created successfully", Toast.LENGTH_LONG).show();

                getActivity().getFragmentManager().popBackStack();

                mListener.eventCreated(createEvent());
            }
        });
    }

    private EventVo createEvent() {
        return new EventVo(mSelectedCategory,
                                    mEventTitle.getText().toString(),
                                    mOrganizedBy.getText().toString(),
                                    mAddress.getText().toString(),
                                    mCity.getText().toString(),
                                    (String) mState.getSelectedItem(),
                                    Integer.valueOf((String) mHowManyPeople.getSelectedItem()),
                                    Integer.valueOf((String) mHowManyPeople.getSelectedItem()),
                                    5,
                                    mTimePickerFragment.getHour(),
                                    mTimePickerFragment.getMinute());
<<<<<<< Updated upstream
=======



        return event;
>>>>>>> Stashed changes
    }

}
