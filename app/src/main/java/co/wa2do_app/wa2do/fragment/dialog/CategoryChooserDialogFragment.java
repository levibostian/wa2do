package co.wa2do_app.wa2do.fragment.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.R;

public class CategoryChooserDialogFragment extends DialogFragment {

    private CategoryChooserListener mListener;

    public interface CategoryChooserListener {
        public void categoryChosen(InterestTypes category);
    }

    public void setListener(CategoryChooserListener listener) {
        mListener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        getDialog().setTitle("Choose a category for event.");
        View view = inflater.inflate(R.layout.category_chooser_dialog_fragment, container);

        // TODO AAAAAHHHHHHH I do not like this code.
        final ImageView sports = (ImageView) view.findViewById(R.id.sports_category);
        final ImageView arts = (ImageView) view.findViewById(R.id.arts_category);
        final ImageView videoGames = (ImageView) view.findViewById(R.id.video_games_category);
        final ImageView drinking = (ImageView) view.findViewById(R.id.drinking_category);
        final ImageView exercise = (ImageView) view.findViewById(R.id.exercise_category);
        final ImageView bookClub = (ImageView) view.findViewById(R.id.book_club_category);

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.categoryChosen(InterestTypes.SPORTS);
                getDialog().cancel();
            }
        });
        arts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.categoryChosen(InterestTypes.ARTS);
                getDialog().cancel();
            }
        });
        videoGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.categoryChosen(InterestTypes.VIDEO_GAMES);
                getDialog().cancel();
            }
        });
        drinking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.categoryChosen(InterestTypes.DRINKING);
                getDialog().cancel();
            }
        });
        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.categoryChosen(InterestTypes.EXERCISE);
                getDialog().cancel();
            }
        });
        bookClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.categoryChosen(InterestTypes.BOOK_CLUB);
                getDialog().cancel();
            }
        });

        return view;
    }

}
