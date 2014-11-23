package co.wa2do_app.wa2do.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.adapter.EventsSwipeCardAdapter;
import co.wa2do_app.wa2do.vo.InterestVo;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class SwipeFragment extends Fragment {

    private SwipeFlingAdapterView mSwipeEventsAdapter;

    public static SwipeFragment newInstance() {
        return new SwipeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.swipe_fragment, container, false);

        mSwipeEventsAdapter = (SwipeFlingAdapterView) view.findViewById(R.id.swipe_events_adapter);

        setupEventsAdapter();

        return view;
    }

    private void setupEventsAdapter() {
        final ArrayList<InterestVo> interests = new ArrayList<InterestVo>();
        interests.add(new InterestVo(R.drawable.sports, InterestTypes.SPORTS));
        interests.add(new InterestVo(R.drawable.arts, InterestTypes.ARTS));
        interests.add(new InterestVo(R.drawable.games, InterestTypes.VIDEO_GAMES));
        interests.add(new InterestVo(R.drawable.drinking, InterestTypes.DRINKING));
        interests.add(new InterestVo(R.drawable.exercise, InterestTypes.EXERCISE));
        interests.add(new InterestVo(R.drawable.bookclub, InterestTypes.BOOK_CLUB));

        final EventsSwipeCardAdapter adapter = new EventsSwipeCardAdapter(getActivity(), R.layout.events_swipe_view, interests);

        final ArrayList<InterestVo> selectedInterests = new ArrayList<InterestVo>();

        mSwipeEventsAdapter.setAdapter(adapter);
        mSwipeEventsAdapter.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
            }

            @Override
            public void onLeftCardExit(Object o) {
                interests.remove(0);
                adapter.notifyDataSetChanged();

                if (interests.size() == 0) {
                    getActivity().getFragmentManager().beginTransaction().replace(R.id.fragment_container, EventFragment.newInstance(selectedInterests)).commit();
                }
            }

            @Override
            public void onRightCardExit(Object o) {
                // like interest
                InterestVo interest = interests.remove(0);
                selectedInterests.add(interest);

                adapter.notifyDataSetChanged();

                if (interests.size() == 0) {
                    getActivity().getFragmentManager().beginTransaction().replace(R.id.fragment_container, EventFragment.newInstance(selectedInterests)).commit();
                }
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
            }
        });
    }
}
