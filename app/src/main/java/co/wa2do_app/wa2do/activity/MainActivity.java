package co.wa2do_app.wa2do.activity;

import android.app.Activity;
import android.os.Bundle;
import co.wa2do_app.wa2do.R;
import co.wa2do_app.wa2do.application.Wa2DoApplication;
import co.wa2do_app.wa2do.fragment.SwipeFragment;
import co.wa2do_app.wa2do.util.UserUtil;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject UserUtil mUserUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Wa2DoApplication.inject(this);

        setupFragment();
    }

    private void setupFragment() {
        // TODO make the isUserBrowsedTopics() actually matter.
        if (!mUserUtil.isUserBrowsedTopics()) {
            getFragmentManager().beginTransaction().add(R.id.fragment_container, SwipeFragment.newInstance()).commit();
        }
    }

}
