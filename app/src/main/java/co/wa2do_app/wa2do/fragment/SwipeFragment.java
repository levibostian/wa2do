package co.wa2do_app.wa2do.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
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
        final ArrayList<InterestVo> events = new ArrayList<InterestVo>();
        events.add(new InterestVo(R.drawable.sports, "Sports"));
        events.add(new InterestVo(R.drawable.concert, "Concerts"));
        events.add(new InterestVo(R.drawable.video_games, "Video Games"));

        final EventsSwipeCardAdapter adapter = new EventsSwipeCardAdapter(getActivity(), R.layout.events_swipe_view, events);

        mSwipeEventsAdapter.setAdapter(adapter);
        mSwipeEventsAdapter.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                Toast.makeText(getActivity(), "remove item", Toast.LENGTH_SHORT).show();
                events.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                Toast.makeText(getActivity(), "left exit", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object o) {
                Toast.makeText(getActivity(), "right exit", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
                Toast.makeText(getActivity(), "almost out of data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
