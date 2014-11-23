package co.wa2do_app.wa2do.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import co.wa2do_app.wa2do.InterestTypes;
import co.wa2do_app.wa2do.vo.InterestVo;

import java.util.ArrayList;
import java.util.List;

public class CategoryFilterAdapter extends ArrayAdapter<InterestVo> implements SpinnerAdapter {

    private Context mContext;
    private ArrayList<InterestVo> mInterests;

    public CategoryFilterAdapter(Context context, int resource, List<InterestVo> interests) {
        super(context, resource, interests);

        mContext = context;
        mInterests = (ArrayList<InterestVo>) interests;
    }

    static class ViewHolder {
        public TextView categoryName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View swipeView = convertView;

        if (swipeView == null) {
            swipeView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_spinner_item, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.categoryName = (TextView) swipeView.findViewById(android.R.id.text1);

            swipeView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) swipeView.getTag();

        final InterestVo interest = mInterests.get(position);

        viewHolder.categoryName.setText(interest.interest.accept(new InterestTypes.Visitor<CharSequence>() {
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

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View swipeView = convertView;

        if (swipeView == null) {
            swipeView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_spinner_dropdown_item, parent, false);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.categoryName = (TextView) swipeView.findViewById(android.R.id.text1);

            swipeView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) swipeView.getTag();

        final InterestVo interest = mInterests.get(position);

        viewHolder.categoryName.setText(interest.interest.accept(new InterestTypes.Visitor<CharSequence>() {
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
